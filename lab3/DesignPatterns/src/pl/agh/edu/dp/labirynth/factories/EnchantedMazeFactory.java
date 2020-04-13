package pl.agh.edu.dp.labirynth.factories;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.elements.*;
import pl.agh.edu.dp.labirynth.elements.bombed.BombedDoor;
import pl.agh.edu.dp.labirynth.elements.magic.MagicDoor;
import pl.agh.edu.dp.labirynth.elements.magic.MagicRoom;
import pl.agh.edu.dp.labirynth.elements.magic.MagicWall;

public class EnchantedMazeFactory extends MazeFactory {

    @Override
    public Room makeRoom(int number) {
        return new MagicRoom(number);
    }

    @Override
    public Wall makeWall() {
        return new MagicWall();
    }

    @Override
    public Door makeDoor(Room r1, Room r2, Direction dir) {
        if (!(r1.getSide(dir) instanceof Wall) || !(r2.getSide(dir.getOpposite()) instanceof Wall)) {
            throw new IllegalArgumentException("either of rooms was lacking required wall");
        }
        Door door = new MagicDoor(r1, r2, (Wall)r1.getSide(dir), (Wall)r2.getSide(dir.getOpposite()));
        r1.setSide(dir, door);
        r2.setSide(dir.getOpposite(), door);
        return door;
    }
}
