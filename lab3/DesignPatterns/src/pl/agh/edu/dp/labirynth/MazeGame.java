package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.builders.MazeBuilder;
import pl.agh.edu.dp.labirynth.elements.Door;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.factories.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;

import java.util.ArrayList;
import java.util.List;

public class MazeGame {
    public Maze createMaze(MazeFactory factory){
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Room room = factory.makeRoom(i);
            for (var dir: Direction.values()) {
                room.setSide(dir, factory.makeWall());
            }
            rooms.add(room);
        }

        Door d1 = factory.makeDoor(rooms.get(0), rooms.get(1), Direction.North);
        Door d2 = factory.makeDoor(rooms.get(0), rooms.get(2), Direction.East);
        Door d3 = factory.makeDoor(rooms.get(2), rooms.get(3), Direction.South);
        Door d4 = factory.makeDoor(rooms.get(1), rooms.get(1), Direction.West);
        Door d5 = factory.makeDoor(rooms.get(3), rooms.get(4), Direction.West);
        Door d6 = factory.makeDoor(rooms.get(4), rooms.get(0), Direction.North);


        Maze maze = new Maze();
        rooms.forEach(maze::addRoom);

        return maze;
    }

    public void play() {
        Maze maze = createMaze(new BombedMazeFactory());
        Player player = new Player(maze);

        player.play();
    }
}
