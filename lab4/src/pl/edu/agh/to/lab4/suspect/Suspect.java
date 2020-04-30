package pl.edu.agh.to.lab4.suspect;

abstract public class Suspect {
    private final String name;
    private final String surname;

    public Suspect(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public boolean canBeAccused(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String display() {
        return getName() + " " + getSurname();
    }
}
