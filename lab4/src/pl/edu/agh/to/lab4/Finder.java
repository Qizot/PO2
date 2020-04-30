package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.provider.CompositeAggregate;
import pl.edu.agh.to.lab4.provider.PersonDataProvider;
import pl.edu.agh.to.lab4.provider.PrisonersDatabase;
import pl.edu.agh.to.lab4.searchstrategy.*;
import pl.edu.agh.to.lab4.suspect.CracovCitizen;
import pl.edu.agh.to.lab4.suspect.Prisoner;
import pl.edu.agh.to.lab4.suspect.Suspect;
import pl.edu.agh.to.lab4.provider.SuspectAggregate;

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

        SuspectAggregate prisoners = new SuspectAggregate() {
            @Override
            public Iterator<? extends Suspect> iterator() {
                return new FlatIterator<Prisoner>(
                        allPrisoners
                                .values()
                                .stream()
                                .map(Collection::iterator)
                                .collect(Collectors.toList())
                );
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
                    new NameSearchStrategy(name),
                    new ImprisonedSearchStrategy()
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
