package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.item.*;

public class ItemFilter {

	private Item itemSpec = new Item();

	public Item getItemSpec() {
		return itemSpec;
	}

	public void setCurrentCategory(Category category) {
		itemSpec = ItemFactory.createItemByCategory(category);
	}

	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}
		if (item instanceof Book && itemSpec instanceof Book) {
			Book b1 = (Book)itemSpec;
			Book b2 = (Book)item;
			if (b1.isHardBinding() && !b2.isHardBinding()) {
				return false;
			}
		}
		if (item instanceof Electronics && itemSpec instanceof Electronics) {
			Electronics b1 = (Electronics)itemSpec;
			Electronics b2 = (Electronics)item;
			if (b1.isMobile() && !b2.isMobile()) {
				return false;
			}
			if (b1.isWarranty() && !b2.isWarranty()) {
				return false;
			}
		}
		if (item instanceof Music && itemSpec instanceof Music) {
			Music b1 = (Music)itemSpec;
			Music b2 = (Music)item;
			if (b1.isVideoIncluded() && !b2.isVideoIncluded()) {
				return false;
			}
		}

		return true;
	}

}