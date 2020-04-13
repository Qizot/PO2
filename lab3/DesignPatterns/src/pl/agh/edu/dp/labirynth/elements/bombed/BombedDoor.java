package pl.agh.edu.dp.labirynth.elements.bombed;

import pl.agh.edu.dp.labirynth.elements.Door;
import pl.agh.edu.dp.labirynth.elements.Room;
import pl.agh.edu.dp.labirynth.elements.Wall;

public class BombedDoor extends Door {
    public BombedDoor(Room r1, Room r2) {
        super(r1, r2);
    }

    @Override
    public void Enter() {
        super.Enter();
        System.out.println("Wow, bombed door, you got lucky it does nothing!");
    }
}
