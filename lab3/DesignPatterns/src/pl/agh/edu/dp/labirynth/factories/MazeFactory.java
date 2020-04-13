package pl.agh.edu.dp.labirynth.factories;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.elements.Door;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.elements.Wall;
import pl.agh.edu.dp.labirynth.elements.magic.MagicDoor;

public class MazeFactory {
    private static MazeFactory instance;

    protected MazeFactory() {}

    public static MazeFactory getInstance() {
        if (instance == null) {
            instance = new MazeFactory();
        }
        return instance;
    }

    public Room makeRoom(int number) {
       return new Room(number);
   }

   public Wall makeWall() {
       return new Wall();
   }

   public Door makeDoor(Room r1, Room r2, Direction dir) {
       if (!(r1.getSide(dir) instanceof Wall) || !(r2.getSide(dir.getOpposite()) instanceof Wall)) {
           throw new IllegalArgumentException("either of rooms was lacking required wall");
       }
       Door door = new Door(r1, r2);
       r1.setSide(dir, door);
       r2.setSide(dir.getOpposite(), door);
       return door;
   }
}
