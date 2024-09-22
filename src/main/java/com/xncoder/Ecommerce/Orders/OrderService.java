package com.xncoder.Ecommerce.Orders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xncoder.Ecommerce.ExceptionClass;
import com.xncoder.Ecommerce.Carts.Carts;
import com.xncoder.Ecommerce.Customer.CustomerRepository;
import com.xncoder.Ecommerce.Customer.Customers;
import com.xncoder.Ecommerce.Products.Product;
import com.xncoder.Ecommerce.Products.ProductRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository or;
    
    @Autowired
    private CustomerRepository cr;
    
    @Autowired
    private ProductRepository pr;
    
    public CustomerOrder addOrders(Long customerId, String name, String mobile, String address, String payment) {
        
        Customers c = cr.findById(customerId).orElseThrow(() -> new ExceptionClass("Customer not found"));
        c.setName(name);
        c.setMobile(mobile);
        c.setAddress(address);
        cr.save(c);
        
        List<Carts> cartItems = c.getCartItems();
        CustomerOrder o = new CustomerOrder();
        o.setAddress(address);
        o.setMobile(mobile);
        o.setPayment(payment);
        o.setCustomer(customerId);
        
        List<Long> products = new ArrayList<>();
        for(Carts cart: cartItems) {
            Product p = pr.findById(cart.getProduct()).orElseThrow(() -> new ExceptionClass("Product not found"));
            products.add(p.getId());
            p.setQuantity(p.getQuantity() - cart.getQuantity());
            pr.save(p);
        }
        o.setProducts(products);
        return or.save(o);
    }
    
    public CustomerOrder getOrderById(Long id) {
    	return or.findById(id).orElseThrow(() -> new ExceptionClass("Order not found"));
    }
  
    public List<CustomerOrder> getOrderByCustomerId(Long id) {
        Customers c = cr.findById(id).orElseThrow(() -> new ExceptionClass("Customer not found"));
        return or.getOrderByCustomer(c);
    }
}