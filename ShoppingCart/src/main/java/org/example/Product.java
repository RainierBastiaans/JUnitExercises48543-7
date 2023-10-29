package org.example;

public class Product {
	private String title;
	private double price;

	//Refactor to more descriptive parameters
	public Product (String title, double price) {
		this.title = title;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public double getPrice() {
		return price;
	}

	//Override equals method to compare Product objects
	//--> Without override we might encounter weird bugs
	@Override
	public boolean equals(Object o) {
		if (o instanceof Product) {
			Product p = (Product)o;
			return p.getTitle().equals(title);
		}
		return false;
	}
}

