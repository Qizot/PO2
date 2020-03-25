package pl.edu.agh.dronka.shop.model.item;

public enum MusicGenre {

    ROCK("Rock"), POP("Pop"), RAP("Rap");

    private String genre;

    static public MusicGenre fromString(String genre) {
        for(MusicGenre music: MusicGenre.values()) {
            if (music.getDisplayName().equals(genre)) {
                return music;
            }
        }
        return null;
    }

    public String getDisplayName() {
        return genre;
    }

    private MusicGenre(String genre) { this.genre = genre; }
}
