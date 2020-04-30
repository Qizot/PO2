package pl.edu.agh.to.lab4.searchstrategy;

import pl.edu.agh.to.lab4.suspect.Suspect;

public interface SearchStrategy {
    boolean filter(Suspect suspect);
}
