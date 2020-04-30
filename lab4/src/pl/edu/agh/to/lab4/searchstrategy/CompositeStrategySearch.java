package pl.edu.agh.to.lab4.searchstrategy;

import pl.edu.agh.to.lab4.suspect.Suspect;

import java.util.List;

public class CompositeStrategySearch implements SearchStrategy {
    private final List<SearchStrategy> strategies;

    public CompositeStrategySearch(List<SearchStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return strategies.stream().allMatch(st -> st.filter(suspect));
    }
}
