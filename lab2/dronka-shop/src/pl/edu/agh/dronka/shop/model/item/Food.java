package pl.edu.agh.dronka.shop.model.item;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Food extends Item {

   private Date expirationDate;

    public Food(String name, int price, int quantity, Date expirationDate) {
        super(name, Category.FOOD, price, quantity);
        this.expirationDate = expirationDate;
    }

    public Food() {
        super();
        setCategory(Category.FOOD);
    }

    @Override
    public void parseFromCsv(CSVReader reader, String[] data) {
        super.parseFromCsv(reader, data);
        String dateString = reader.getValue(data, "Data przydatności");
        try {
            this.expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            System.out.println("[ERROR FOOD] Invalid date format, please check your csv file");
        }
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
