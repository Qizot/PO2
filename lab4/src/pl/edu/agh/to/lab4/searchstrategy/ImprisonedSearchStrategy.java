package pl.edu.agh.to.lab4.searchstrategy;

import pl.edu.agh.to.lab4.suspect.Prisoner;
import pl.edu.agh.to.lab4.suspect.Suspect;

public class ImprisonedSearchStrategy implements SearchStrategy{
    @Override
    public boolean filter(Suspect suspect) {
        if (suspect instanceof Prisoner) {
            return !((Prisoner) suspect).isImprisoned();
        }
        return true;
    }
}
