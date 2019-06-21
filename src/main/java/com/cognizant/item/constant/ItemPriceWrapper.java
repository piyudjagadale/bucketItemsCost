package com.cognizant.item.constant;

import java.util.HashMap;
import java.util.Map;

public class ItemPriceWrapper {

	private static final Map<String, Integer> itemToPriceMap = new HashMap<>();
	
	static {

		itemToPriceMap.put("BANANA", 10);
		itemToPriceMap.put("ORANGE", 5);
		itemToPriceMap.put("APPLE", 2);
		itemToPriceMap.put("LEMON", 8);
		itemToPriceMap.put("PEACH", 10);
	}

	public static Map<String, Integer> getItemtopricemap() {
		return itemToPriceMap;
	}
}
