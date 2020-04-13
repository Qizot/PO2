package pl.agh.edu.dp.labirynth;

public enum Direction {
    North("N"), South("S"), East("E"), West("W");
    private String direction;


    Direction(String dir) {
        this.direction = dir;
    }

    public Direction getOpposite() {
        switch (this) {
            case North:
                return South;
            case South:
                return North;
            case East:
                return West;
            case West:
                return East;
            default:
                return null;
        }
    }

    static public Direction fromString(String direction) {
        for (var dir: values()) {
            if (dir.direction.equals(direction)) {
                return dir;
            }
        }
        return null;
    }
}