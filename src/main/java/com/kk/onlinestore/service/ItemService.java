package com.kk.onlinestore.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.kk.onlinestore.domain.Item;

public class ItemService {
	
	private Map<Integer, Item> itemDB = new HashMap<>();
	
	public ItemService() {
		itemDB.put(1,new Item(1, "Chair", 15.99f));
		itemDB.put(4,new Item(4, "Table", 129.99f));
		itemDB.put(6,new Item(6, "Moniter", 169.99f));
		itemDB.put(5,new Item(5, "phone", 999.99f));
		itemDB.put(2,new Item(2, "Laptop", 2399.99f));
		itemDB.put(3,new Item(3, "Tablet", 329.99f));
	}
	
	
	public Map<Integer, Item> getItemDB() {
		return itemDB;
	}


	public Collection<Item> displayallItems(){
		return itemDB.values();
	}
	
	public float totalAmount(int quantity, float price) {
		return (float) quantity * price;
	}
}
