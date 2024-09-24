package com.xncoder.Ecommerce.Orders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xncoder.Ecommerce.Customer.Customers;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
	public List<CustomerOrder> getOrderByCustomer(Long customerId);
}

