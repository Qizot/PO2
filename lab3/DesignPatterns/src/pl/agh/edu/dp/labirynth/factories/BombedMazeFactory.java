package pl.agh.edu.dp.labirynth.factories;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.elements.*;
import pl.agh.edu.dp.labirynth.elements.bombed.BombedDoor;
import pl.agh.edu.dp.labirynth.elements.bombed.BombedRoom;
import pl.agh.edu.dp.labirynth.elements.bombed.BombedWall;

public class BombedMazeFactory extends MazeFactory {

    @Override
    public Room makeRoom(int number) {
        return new BombedRoom(number);
    }

    @Override
    public Wall makeWall() {
        return new BombedWall();
    }

    @Override
    public Door makeDoor(Room r1, Room r2, Direction dir) {
        if (!(r1.getSide(dir) instanceof Wall) || !(r2.getSide(dir.getOpposite()) instanceof Wall)) {
            throw new IllegalArgumentException("either of rooms was lacking required wall");
        }
        Door door = new BombedDoor(r1, r2, (Wall)r1.getSide(dir), (Wall)r2.getSide(dir.getOpposite()));
        r1.setSide(dir, door);
        r2.setSide(dir.getOpposite(), door);
        return door;
    }
}
