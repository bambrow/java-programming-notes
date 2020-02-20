package design.builder.meal;

import design.builder.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	
	private List<Item> items = new ArrayList<Item>();
	
	public void addItem(Item newItem) {
		items.add(newItem);
	}
	
	public void printItems() {
		for (Item item : items) {
			System.out.print("Item: " + item.name() + "; ");
			System.out.print("Packing: " + item.packing().pack() + "; ");
			System.out.println("Price: " + item.price());
		}
	}
	
	public float totalCost() {
		float total = .0f;
		for (Item item : items) {
			total += item.price();
		}
		return total;
	}

}
