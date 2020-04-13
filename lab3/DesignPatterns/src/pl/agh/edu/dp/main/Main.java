package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;

public class Main {

    public static void main(String[] args) {
        MazeFactory factory = MazeFactory.getInstance();
        System.out.println("Testing singleton, are instances equal?: " + (factory == MazeFactory.getInstance()));
        System.out.println("Testing done, prepare for quick play!\n");

        MazeGame mazeGame = new MazeGame();
        mazeGame.play();
    }
}



