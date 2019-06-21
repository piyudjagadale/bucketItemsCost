package com.cognizant.item.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import com.cognizant.item.constant.ItemPriceWrapper;
import com.morrisons.item.service.IProcessItems;

public class ProcessItemsImpl implements IProcessItems{

	/**
	 *  Process Items and Calculate total cost of items
	 */
	@Override
	public Integer processItems(List<String> items) {

		Map<String, Integer> itemToQuantityMap = new HashMap<>();

		if (CollectionUtils.isNotEmpty(items)) {

			for (String item : items) {

				if (StringUtils.isNotEmpty(item)) {

					Integer quantity = itemToQuantityMap.get(item);
					itemToQuantityMap.put(item, (quantity == null) ? 1
							: quantity + 1);
				}

			}

			System.out.println("Total no of Items in basket : "
					+ itemToQuantityMap.size());

			if (MapUtils.isNotEmpty(itemToQuantityMap)) {
				
				Integer totalCost = calculateCost(itemToQuantityMap);

				System.out.println("Total Cost of Items in basket : "
						+ totalCost);

				return totalCost;
			}
			else {
				System.out.println("Item not found for Processing");
				throw new NullPointerException();
			}

		} else {
			System.out.println("Item not found in Basket");
			throw new NullPointerException();
		}

	}

	private static Integer calculateCost(Map<String, Integer> itemToQuantityMap) {

		Integer totalCost = 0;

		Map<String, Integer> itemToPriceMap = new HashMap<>(
				ItemPriceWrapper.getItemtopricemap());

		if (MapUtils.isNotEmpty(itemToPriceMap)) {

			for (Map.Entry<String, Integer> entry : itemToQuantityMap
					.entrySet()) {

				String itemName = entry.getKey();

				if (itemToPriceMap.containsKey(itemName.toUpperCase())) {
					Integer price = itemToPriceMap.get(itemName.toUpperCase());

					Integer quantity = entry.getValue();

					totalCost += price * quantity;
				}

			}
			return totalCost;
		} else {
			System.out.println("Price for items not found.");
			throw new NullPointerException();
		}
	}
}
