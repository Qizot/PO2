package pl.edu.agh.to.lab4.suspect;

import pl.edu.agh.to.lab4.suspect.Suspect;

public class CracovCitizen extends Suspect {
    private final int age;

    public CracovCitizen(String name, String surname, int age) {
        super(name, surname);
        this.age = age;
    }

    public boolean canBeAccused(String name) {
        return super.canBeAccused(name) && age >= 18;
    }

    public int getAge() {
        return age;
    }
}
