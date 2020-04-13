package pl.agh.edu.dp.labirynth.elements.magic;

import pl.agh.edu.dp.labirynth.elements.Door;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.elements.Wall;

public class MagicDoor extends Door {
    public MagicDoor(Room r1, Room r2, Wall r1Wall, Wall r2Wall){
        super(r1, r2);
    }
}
