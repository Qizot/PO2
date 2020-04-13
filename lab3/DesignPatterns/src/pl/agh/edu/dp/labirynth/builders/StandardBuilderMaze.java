package pl.agh.edu.dp.labirynth.builders;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.elements.Door;
import pl.agh.edu.dp.labirynth.elements.MapSite;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.elements.Wall;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;

import java.util.NoSuchElementException;

public class StandardBuilderMaze implements MazeBuilder {
    final private Maze currentMaze;
    final private MazeFactory factory;

    public StandardBuilderMaze(MazeFactory factory) {
        this.factory = factory;
        currentMaze = new Maze();
    }


    @Override
    public MazeBuilder addRoom(Room room) {
        currentMaze.addRoom(room);
        return this;
    }

    @Override
    public MazeBuilder addWall(Room room, Direction direction) {
        if (!currentMaze.containsRoom(room)) {
            throw new NoSuchElementException("given room has not been found in the maze");
        }
        room.setSide(direction, factory.makeWall());
        return this;
    }

    @Override
    public MazeBuilder connectRoomsWithDoor(Room firstRoom, Room secondRoom) {
        Direction dir = commonWall(firstRoom, secondRoom);
        connectRoomsWithDoor(firstRoom, secondRoom, dir);
        return this;
    }

    public MazeBuilder connectRoomsWithDoor(Room firstRoom, Room secondRoom, Direction dir) {
        if (!currentMaze.containsRoom(firstRoom) || !currentMaze.containsRoom(secondRoom)) {
            throw new NoSuchElementException("both rooms has to be a part of the maze");
        }
        if (dir == null) {
            throw new IllegalArgumentException("couldn't find a common wall between given rooms");
        }
        factory.makeDoor(firstRoom, secondRoom, dir);
        return this;
    }

    private Wall getRoomWall(Room room, Direction dir) {
        MapSite site = room.getSide(dir);
        if (!(site instanceof Wall)) {
            return null;
        }
        return (Wall)site;
    }

    private Direction commonWall(Room r1, Room r2) {
        for (var dir: Direction.values()) {
           if (getRoomWall(r1, dir) != null && getRoomWall(r2, dir.getOpposite()) != null) {
               return dir;
           }
        }
        return null;
    }

    @Override
    public Maze build() {
        return currentMaze;
    }
}
