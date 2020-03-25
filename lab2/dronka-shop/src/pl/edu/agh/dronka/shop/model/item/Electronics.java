package pl.edu.agh.dronka.shop.model.item;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;

public class Electronics extends Item {

    private boolean mobile;
    private boolean warranty;

    public Electronics(String name, int price, int quantity, boolean mobile, boolean warranty) {
        super(name, Category.ELECTRONICS, price, quantity);
        this.mobile = mobile;
        this.warranty = warranty;
    }

    public Electronics() {
        super();
        setCategory(Category.ELECTRONICS);
    }

    @Override
    public void parseFromCsv(CSVReader reader, String[] data) {
        super.parseFromCsv(reader, data);
        this.mobile = Boolean.parseBoolean(reader.getValue(data, "Mobilny"));
        this.warranty = Boolean.parseBoolean(reader.getValue(data, "Gwarancja"));
    }

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public boolean isWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }
}
