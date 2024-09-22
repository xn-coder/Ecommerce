package com.xncoder.Ecommerce.Orders;

public class OrderDTO {
	private Long productId;
	private int quantity;
	public OrderDTO(Long productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
