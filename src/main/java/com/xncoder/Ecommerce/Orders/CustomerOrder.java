package com.xncoder.Ecommerce.Orders;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.xncoder.Ecommerce.Customer.Customers;
import com.xncoder.Ecommerce.Products.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")  // Update table name
public class CustomerOrder {  // Rename class
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long order_id;
    
    public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@OneToOne
    @JoinColumn(name = "cid", nullable = false)
    private Customers customer;
    
    @OneToMany
    @JoinColumn(name = "pid", nullable = false)
    private List<Product> products;
    
    @CreationTimestamp
    private LocalDateTime date;
    
    @Column(nullable = false)
    private String payment;
    
    private String address;
    
    private String mobile;
    
    public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPayment() {
        return payment;
    }
    public void setPayment(String payment) {
        this.payment = payment;
    }
    public Long getOrder_id() {
        return order_id;
    }
    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }
    public Customers getCustomer() {
        return customer;
    }
    public void setCustomer(Customers customer) {
        this.customer = customer;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}