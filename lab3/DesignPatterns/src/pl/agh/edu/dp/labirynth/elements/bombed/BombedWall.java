package pl.agh.edu.dp.labirynth.elements.bombed;

import pl.agh.edu.dp.labirynth.elements.Wall;

public class BombedWall extends Wall {
    @Override
    public void Enter() {
        super.Enter();
        System.out.println("It is a bombed wall, prepare to die!");
    }
}
