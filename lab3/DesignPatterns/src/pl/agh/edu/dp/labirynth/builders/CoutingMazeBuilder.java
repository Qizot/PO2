package pl.agh.edu.dp.labirynth.builders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.elements.Room;

public class CoutingMazeBuilder implements MazeBuilder {
    private int createdElements;

    private void increment() {
        createdElements += 1;
    }

    @Override
    public MazeBuilder addRoom(Room room) {
        increment();
        return this;
    }

    @Override
    public MazeBuilder addWall(Room room, Direction direction) {
        increment();
        return this;
    }

    @Override
    public MazeBuilder connectRoomsWithDoor(Room firstRoom, Room secondRoom) {
        increment();
        return this;
    }

    @Override
    public MazeBuilder connectRoomsWithDoor(Room firstRoom, Room secondRoom, Direction direction) {
        increment();
        return null;
    }

    @Override
    public Maze build() {
        return null;
    }

    public int getCounts() {
        return createdElements;
    }
}
