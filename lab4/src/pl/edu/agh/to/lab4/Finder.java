package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.SearchStrategy.AgeSearchStrategy;
import pl.edu.agh.to.lab4.SearchStrategy.CompositeStrategySearch;
import pl.edu.agh.to.lab4.SearchStrategy.NameSearchStrategy;
import pl.edu.agh.to.lab4.SearchStrategy.SearchStrategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Finder {
    private final CompositeAggregate peopleAggregate;

    public Finder(Collection<CracovCitizen> allCracovCitizens, Map<String, Collection<Prisoner>> allPrisoners) {
        SuspectAggregate citizens = new SuspectAggregate() {
            @Override
            public Iterator<? extends Suspect> iterator() {
                return allCracovCitizens.iterator();
            }
        };

       Iterator<? extends Suspect> prisonersIter = new FlatIterator<Prisoner>(
            allPrisoners
            .values()
            .stream()
            .map(Collection::iterator)
            .collect(Collectors.toList())
        );

        SuspectAggregate prisoners = new SuspectAggregate() {
            @Override
            public Iterator<? extends Suspect> iterator() {
                return prisonersIter;
            }
        };

        this.peopleAggregate = new CompositeAggregate(List.of(prisoners, citizens));

    }

    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
        this.peopleAggregate = new CompositeAggregate(List.of(prisonersDatabase, personDataProvider));
    }

    public void displayAllSuspectsWithName(String name) {
        SearchStrategy searchStrategy = new CompositeStrategySearch(
            List.of(
                new AgeSearchStrategy(18),
                new NameSearchStrategy(name)
            )
        );

        List<Suspect> suspected = findSuspects(searchStrategy)
            .limit(10)
            .collect(Collectors.toList());


        int t = suspected.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Suspect n : suspected) {
            System.out.println(n.display());
        }
    }

    private Stream<Suspect> findSuspects(SearchStrategy searchStrategy) {
        Spliterator<Suspect> spliterator = Spliterators.spliteratorUnknownSize(
                peopleAggregate.iterator(), Spliterator.NONNULL);
        return  StreamSupport
                .stream(spliterator, false)
                .filter(searchStrategy::filter);
    }

    public Collection<Suspect> display(SearchStrategy searchStrategy) {
        return findSuspects(searchStrategy).collect(Collectors.toList());
    }
}
