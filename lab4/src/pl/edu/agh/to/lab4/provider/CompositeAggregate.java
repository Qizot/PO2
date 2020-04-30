package pl.edu.agh.to.lab4.provider;

import pl.edu.agh.to.lab4.FlatIterator;
import pl.edu.agh.to.lab4.suspect.Suspect;
import pl.edu.agh.to.lab4.provider.SuspectAggregate;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CompositeAggregate implements SuspectAggregate {

    private final List<SuspectAggregate> aggregates;

    public CompositeAggregate(List<SuspectAggregate> aggregates) {
        this.aggregates = aggregates;
    }

    @Override
    public Iterator<? extends Suspect> iterator() {
        return new FlatIterator<Suspect>(
            aggregates
            .stream()
            .map(s -> (Iterator<Suspect>) s.iterator())
            .collect(Collectors.toList())
        );
    }
}
