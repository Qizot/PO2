package pl.agh.edu.dp.labirynth.elements;

public class Door extends MapSite {
    private Room room1;
    private Room room2;
    private Wall firstRoomWall;
    private Wall secondRoomWall;

    public Door(Room r1, Room r2, Wall r1Wall, Wall r2Wall){
        this.room1 = r1;
        this.room2 = r2;
        this.firstRoomWall = r1Wall;
        this.secondRoomWall = r2Wall;
    }


    @Override
    public void Enter(){
        System.out.println("Walking through door!");
    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room1 = room2;
    }

    public Wall getFirstWall() {
        return firstRoomWall;
    }

    public Wall getSecondWall() {
        return firstRoomWall;
    }

}
