package pl.agh.edu.dp.labirynth.elements.bombed;

import pl.agh.edu.dp.labirynth.elements.Door;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.elements.Wall;

public class BombedDoor extends Door {
    public BombedDoor(Room r1, Room r2, Wall r1Wall, Wall r2Wall) {
        super(r1, r2, r1Wall, r2Wall);
    }

    @Override
    public void Enter() {
        super.Enter();
        System.out.println("Wow, bombed door, you got lucky it does nothing!");
    }
}
