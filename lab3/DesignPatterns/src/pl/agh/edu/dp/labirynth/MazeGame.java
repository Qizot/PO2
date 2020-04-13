package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.builders.MazeBuilder;
import pl.agh.edu.dp.labirynth.builders.StandardBuilderMaze;
import pl.agh.edu.dp.labirynth.elements.Door;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.factories.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;

import java.util.ArrayList;
import java.util.List;

public class MazeGame {
    public Maze createMaze(MazeFactory factory){
        StandardBuilderMaze builder = new StandardBuilderMaze(factory);
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Room room = factory.makeRoom(i);
            builder.addRoom(room);
            for (var dir: Direction.values()) {
                builder.addWall(room, dir);
            }
            rooms.add(room);
        }

        builder.connectRoomsWithDoor(rooms.get(0), rooms.get(1), Direction.North);
        builder.connectRoomsWithDoor(rooms.get(0), rooms.get(2), Direction.East);
        builder.connectRoomsWithDoor(rooms.get(2), rooms.get(3), Direction.South);
        builder.connectRoomsWithDoor(rooms.get(1), rooms.get(1), Direction.West);
        builder.connectRoomsWithDoor(rooms.get(3), rooms.get(4), Direction.West);
        builder.connectRoomsWithDoor(rooms.get(4), rooms.get(0), Direction.North);

        return builder.build();
    }

    public void play() {
        Maze maze = createMaze(new BombedMazeFactory());
        Player player = new Player(maze);

        player.play();
    }
}
