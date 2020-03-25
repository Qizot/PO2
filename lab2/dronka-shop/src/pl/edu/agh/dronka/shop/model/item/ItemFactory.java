package pl.edu.agh.dronka.shop.model.item;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ItemFactory {

    static public Item createItemByCategory(Category category) {
        switch (category) {
            case FOOD:
                return new Food();
            case BOOKS:
                return new Book();
            case MUSIC:
                return new Music();
            case ELECTRONICS:
                return new Electronics();
            case SPORT:
                return new Sport();
            default:
                return null;
        }
    }

    static public List<Item> parseItems(CSVReader reader, Category category) {
       return reader
        .getData()
        .stream()
        .map(data -> {
            Item item = createItemByCategory(category);
            item.parseFromCsv(reader, data);
            return item;
        })
        .collect(Collectors.toList());
    }
}
