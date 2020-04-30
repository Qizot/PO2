package pl.edu.agh.to.lab4.searchstrategy;

import pl.edu.agh.to.lab4.suspect.Suspect;

public class NameSearchStrategy implements SearchStrategy {

    private final String name;

    public NameSearchStrategy(String name) {
        this.name = name;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getName().equals(name);
    }
}
