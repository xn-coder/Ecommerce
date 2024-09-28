package com.xncoder.Ecommerce.Orders;

import java.util.List;

class Prod {
	private String image;
	private String name;
	private double price;
	private int quantity;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Prod(String image, String name, double price, int quantity) {
		super();
		this.image = image;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
}	

public class UserDTO {
	private Long order_id;
	private String date;
	private Double total_price;
	private List<Prod> products;
	
	public UserDTO(Long order_id, String date, Double total_price, List<Prod> products) {
		super();
		this.order_id = order_id;
		this.date = date;
		this.total_price = total_price;
		this.products = products;
	}
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public List<Prod> getProducts() {
		return products;
	}
	public void setProducts(List<Prod> products) {
		this.products = products;
	}
	
}
