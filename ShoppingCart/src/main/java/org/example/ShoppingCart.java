package org.example;
//Refactor to more specific import to improve efficiency
import java.util.ArrayList;

public class ShoppingCart {

	//ArrayList should have an identifier = Product
	private ArrayList<Product> items;
	
	public ShoppingCart() {
		this.items = new ArrayList<>();
	}
	
	public double getBalance() {
		double balance = 0.00;
		//Add Product Identifier
		//For loop can be more efficient --> refactor
        for (Product item : items) {
            balance += item.getPrice();
        }
		return balance;
	}
	
	public void addItem(Product item) {
		items.add(item);
	}
	
	public void removeItem(Product item)
			throws ProductNotFoundException {
		if (!items.remove(item)) {
			throw new ProductNotFoundException();}
	}
	
	public int getItemCount() {
		return items.size();
	}

	//Refactor to more descriptive name
	public void removeAll() {
		items.clear();
	}
}

