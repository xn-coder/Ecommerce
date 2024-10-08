package com.xncoder.Ecommerce.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {
	public Customers findByEmail(String email);
}
