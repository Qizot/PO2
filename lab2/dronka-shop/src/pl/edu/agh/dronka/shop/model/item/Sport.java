package pl.edu.agh.dronka.shop.model.item;

import pl.edu.agh.dronka.shop.model.Category;

public class Sport extends Item {
    public Sport(String name, int price, int quantity) {
        super(name, Category.SPORT, price, quantity);
    }

    public Sport() {
        super();
        setCategory(Category.SPORT);
    }
}
