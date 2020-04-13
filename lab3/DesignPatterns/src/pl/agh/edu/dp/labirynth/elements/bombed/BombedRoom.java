package pl.agh.edu.dp.labirynth.elements.bombed;

import pl.agh.edu.dp.labirynth.elements.Room;

public class BombedRoom extends Room {
    public BombedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter() {
        super.Enter();
        System.out.println("This is a bombed room, watch out for bombed walls!");
    }
}
