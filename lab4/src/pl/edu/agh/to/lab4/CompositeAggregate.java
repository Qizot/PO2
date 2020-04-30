package pl.edu.agh.to.lab4;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CompositeAggregate implements SuspectAggregate{

    private final List<SuspectAggregate> aggregates;

    CompositeAggregate(List<SuspectAggregate> aggregates) {
        this.aggregates = aggregates;
    }

    @Override
    public Iterator<? extends Suspect> iterator() {
        return new FlatIterator<Suspect>(
            aggregates
            .stream()
            .map(s -> (Iterator<Suspect>) s.iterator()
            )
            .collect(Collectors.toList())
        );
    }
}
