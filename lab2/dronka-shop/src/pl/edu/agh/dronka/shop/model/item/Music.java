package pl.edu.agh.dronka.shop.model.item;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;

public class Music extends Item {

    private MusicGenre genre;

    private boolean videoIncluded;

    public Music(String name, int price, int quantity, MusicGenre genre, boolean videoIncluded) {
        super(name, Category.MUSIC, price, quantity);
        this.genre = genre;
        this.videoIncluded = videoIncluded;
    }

    public Music() {
        super();
        setCategory(Category.MUSIC);
    }

    public void parseFromCsv(CSVReader reader, String[] data) {
        super.parseFromCsv(reader, data);
        this.genre = MusicGenre.fromString(reader.getValue(data, "Typ"));
        this.videoIncluded = Boolean.parseBoolean(reader.getValue(data, "Teledysk"));
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public boolean isVideoIncluded() {
        return videoIncluded;
    }

    public void setVideoIncluded(boolean videoIncluded) {
        this.videoIncluded = videoIncluded;
    }

}
