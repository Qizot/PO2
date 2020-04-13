package pl.agh.edu.dp.labirynth.elements;

public class Wall extends MapSite {
    public Wall(){

    }

    @Override
    public void Enter(){
        System.out.println("Encountered wall!");
    }
}
