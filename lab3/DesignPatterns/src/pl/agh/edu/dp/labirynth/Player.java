package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.elements.Door;
import pl.agh.edu.dp.labirynth.elements.MapSite;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.elements.Wall;
import pl.agh.edu.dp.labirynth.elements.bombed.BombedDoor;
import pl.agh.edu.dp.labirynth.elements.bombed.BombedWall;

import java.util.Scanner;

public class Player {
    private Maze maze;
    private Room currentRoom;
    private boolean isAlive = true;

    Player(Maze maze) {
       this.maze = maze;
       this.currentRoom = maze.getRandomRoom();
    }

    private void die() {
        isAlive = false;
    }

    private void move(Direction dir) {
       MapSite side = currentRoom.getSide(dir);
       if (side instanceof Door) {
          Door door = (Door)side;
          door.Enter();
          if (door.getRoom1() == currentRoom) {
              currentRoom = door.getRoom2();
          } else {
              currentRoom = door.getRoom1();
          }
          currentRoom.Enter();
          return;
       }
       if (side instanceof Wall) {
           Wall wall = (Wall)side;
           wall.Enter();
           if (wall instanceof BombedWall) {
               die();
           }
           return;
       }
        System.out.println("Invalid movement");
    }


    public void play() {
        Scanner scanner = new Scanner(System.in);
        while(isAlive) {
            System.out.print("N/S/W/E> ");
            String input = scanner.nextLine();
            Direction direction = Direction.fromString(input);
            move(direction);
        }
    }
}
