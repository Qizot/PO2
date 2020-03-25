package pl.edu.agh.dronka.shop.model.item;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;

public class Item {

	private String name;

	private Category category;

	private int price;

	private int quantity;

	private boolean secondhand;

	private boolean polish;

	public Item(String name, Category category, int price, int quantity) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	public Item() {
		super();
	}

	public void parseFromCsv(CSVReader reader, String[] data) {
		this.name = reader.getValue(data,"Nazwa");
		this.price = Integer.parseInt(reader.getValue(data, "Cena"));
		this.quantity = Integer.parseInt(reader.getValue(data,
				"Ilość"));
		this.polish = Boolean.parseBoolean(reader.getValue(
				data, "Tanie bo polskie"));
		this.secondhand = Boolean.parseBoolean(reader.getValue(
				data, "Używany"));
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setSecondhand(boolean secondhand) {
		this.secondhand = secondhand;
	}

	public boolean isSecondhand() {
		return secondhand;
	}

	public void setPolish(boolean polish) {
		this.polish = polish;
	}

	public boolean isPolish() {
		return polish;
	}

	@Override
	public String toString() {
		return getName();
	}
}
