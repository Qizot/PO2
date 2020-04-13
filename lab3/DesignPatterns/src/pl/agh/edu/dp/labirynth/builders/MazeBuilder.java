package pl.agh.edu.dp.labirynth.builders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.elements.Room;

public interface MazeBuilder {
    MazeBuilder addRoom(Room room);
    MazeBuilder addWall(Room room, Direction direction);
    MazeBuilder connectRoomsWithDoor(Room firstRoom, Room secondRoom);
    Maze build();
}
