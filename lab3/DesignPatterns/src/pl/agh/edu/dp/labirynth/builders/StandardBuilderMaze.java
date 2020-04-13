package pl.agh.edu.dp.labirynth.builders;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.elements.Door;
import pl.agh.edu.dp.labirynth.elements.MapSite;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.elements.Wall;

import java.util.NoSuchElementException;

public class StandardBuilderMaze implements MazeBuilder {
    final private Maze currentMaze;

    public StandardBuilderMaze() {
        currentMaze = new Maze();
    }


    @Override
    public MazeBuilder addRoom(Room room) {
        currentMaze.addRoom(room);
        return this;
    }

    @Override
    public MazeBuilder addWall(Room room, Direction direction) {
        if (currentMaze.containsRoom(room)) {
            throw new NoSuchElementException("given room has not been found in the maze");
        }
        room.setSide(direction, new Wall());
        return this;
    }

    @Override
    public MazeBuilder connectRoomsWithDoor(Room firstRoom, Room secondRoom) {
        if (currentMaze.containsRoom(firstRoom) || currentMaze.containsRoom(secondRoom)) {
            throw new NoSuchElementException("both rooms has to be a part of the maze");
        }
        Direction dir = commonWall(firstRoom, secondRoom);
        if (dir == null) {
            throw new IllegalArgumentException("couldn't find a common wall between given rooms");
        }

        Wall r1Wall = getRoomWall(firstRoom, dir);
        Wall r2Wall = getRoomWall(secondRoom, dir);

        Door door = new Door(firstRoom, secondRoom, r1Wall, r2Wall);
        firstRoom.setSide(dir, door);
        secondRoom.setSide(dir.getOpposite(), door);

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
