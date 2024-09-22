package com.xncoder.Ecommerce.Carts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xncoder.Ecommerce.Customer.Customers;
import com.xncoder.Ecommerce.Products.Product;

@Repository
public interface CartRepository extends JpaRepository<Carts, Long>{
	List<Carts> findByCustomerId(Long customerId);
	Carts findByCustomerAndProduct(Customers customer, Product product);
}
