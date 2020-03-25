package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.item.*;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		
		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName()); 
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("Używany", item.isSecondhand());

		if (item instanceof Book) {
			propertiesMap.put("Liczba stron", ((Book) item).getPages());
			propertiesMap.put("Twarda oprawa", ((Book) item).isHardBinding());
		}
		if (item instanceof Electronics) {
			propertiesMap.put("Mobilny", ((Electronics) item).isMobile());
			propertiesMap.put("Gwarancja", ((Electronics) item).isWarranty());
		}
		if (item instanceof Food) {
			propertiesMap.put("Data przydatności", ((Food) item).getExpirationDate());
		}
		if (item instanceof Music) {
			propertiesMap.put("Typ", ((Music) item).getGenre().getDisplayName());
			propertiesMap.put("Dołączone wideo", ((Music) item).isVideoIncluded());
		}
		
		return propertiesMap;
	}
}
