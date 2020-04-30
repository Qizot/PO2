package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.provider.PersonDataProvider;
import pl.edu.agh.to.lab4.provider.PrisonersDatabase;

public class Application {

    public static void main(String[] args) {
        Finder suspects = new Finder(new PersonDataProvider(), new PrisonersDatabase());
        suspects.displayAllSuspectsWithName("Janusz");
    }
}
