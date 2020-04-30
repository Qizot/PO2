package pl.edu.agh.to.lab4.provider;

import pl.edu.agh.to.lab4.suspect.Suspect;

import java.util.Iterator;

public interface SuspectAggregate {
    Iterator<? extends Suspect> iterator();
}
