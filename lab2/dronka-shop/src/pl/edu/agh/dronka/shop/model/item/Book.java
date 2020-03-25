package pl.edu.agh.dronka.shop.model.item;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;

public class Book extends Item {

    private int pages;
    private boolean hardBinding;

    public Book(String name, int price, int quantity, int pages, boolean hardBinding) {
        super(name, Category.BOOKS, price, quantity);
        this.pages = pages;
        this.hardBinding = hardBinding;
    }

    public Book() {
        super();
        setCategory(Category.BOOKS);
    }

    @Override
    public void parseFromCsv(CSVReader reader, String[] data) {
        super.parseFromCsv(reader, data);
        this.pages = Integer.parseInt(reader.getValue(data, "Liczba stron"));
        this.hardBinding = Boolean.parseBoolean(reader.getValue(data, "Twarda oprawa"));
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isHardBinding() {
        return hardBinding;
    }

    public void setHardBinding(boolean hardBinding) {
        this.hardBinding = hardBinding;
    }
}
