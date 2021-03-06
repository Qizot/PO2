package pl.edu.agh.to.lab4.searchstrategy;

import pl.edu.agh.to.lab4.suspect.CracovCitizen;
import pl.edu.agh.to.lab4.suspect.Suspect;

public class AgeSearchStrategy implements SearchStrategy {

    private final int from;
    private final int to;

    public AgeSearchStrategy(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public AgeSearchStrategy(int from) {
        this.from = from;
        this.to = 1000;
    }

    @Override
    public boolean filter(Suspect suspect) {
        if (suspect instanceof CracovCitizen) {
            int suspectAge = ((CracovCitizen) suspect).getAge();
            return from <= suspectAge && suspectAge <= to;
        }
        return true;
    }
}
