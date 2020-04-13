package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.elements.Room;

import java.util.Random;
import java.util.Vector;

public class Maze {
    private Vector<Room> rooms;

    public Maze() {
        this.rooms = new Vector<Room>();
    }

    public void addRoom(Room room){
        for (var oldRoom: rooms) {
            if (oldRoom.getRoomNumber() == room.getRoomNumber()) {
                throw new IllegalArgumentException("Room  with given number already exists");
            }
        }
        rooms.add(room);
    }

    public Room findRoom(int roomNumber) {
       return rooms
        .stream()
        .filter(room -> room.getRoomNumber() == roomNumber)
        .findFirst()
        .orElse(null);
    }

    public Room getRandomRoom() {
        Random r = new Random();
        return rooms.get(r.nextInt(rooms.size()));
    }

    public boolean containsRoom(Room room) {
        return rooms.contains(room);
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers() {
        return rooms.size();
    }
}
