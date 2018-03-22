package be.iccbxl.pid.ingredient;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import be.iccbxl.pid.product.Product;

@Entity
public class Ingredient {
	
	@Id
	private int id;
	private String name;
	private double price;
	@ManyToOne
	private Product product;
	
	public Ingredient() {
		super();
	}

	public Ingredient(int id, String name, double price, int productId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.product = new Product(productId,"",0d);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
