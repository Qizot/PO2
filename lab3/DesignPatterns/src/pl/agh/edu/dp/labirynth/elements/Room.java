package pl.agh.edu.dp.labirynth.elements;

import pl.agh.edu.dp.labirynth.Direction;

import java.util.EnumMap;
import java.util.Map;

public class Room extends MapSite
{
    final private int roomNumber;
    final private Map<Direction, MapSite> sides;


    public Room(int number){
        this.sides = new EnumMap<>(Direction.class);
        this.roomNumber = number;
    }

    public MapSite getSide(Direction direction){
        return this.sides.get(direction);
    }

    public void setSide(Direction direction, MapSite ms){
        this.sides.put(direction, ms);
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    @Override
    public void Enter(){
        System.out.println("Entered room!");
    }
}
