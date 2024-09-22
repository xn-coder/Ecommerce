package com.xncoder.Ecommerce.Orders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xncoder.Ecommerce.ExceptionClass;
import com.xncoder.Ecommerce.Carts.CartRepository;
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
    
    @Autowired
    private CartRepository crp;
    
    public void addOrders(Long customerId, String name, String mobile, String address, String payment) {
        
        Customers c = cr.findById(customerId).orElseThrow(() -> new ExceptionClass("Customer not found"));
        c.setName(name);
        c.setMobile(mobile);
        c.setAddress(address);
        cr.save(c);
        
        List<Carts> cartItems = c.getCartItems();
        CustomerOrder o = new CustomerOrder();
        o.setPayment(payment);
        o.setAddress(address);
        o.setMobile(mobile);
        o.setCustomer(c);
        
        List<Product> products = new ArrayList<>();
        for(Carts cart: cartItems) {
            Product p = cart.getProduct();
            products.add(p);
            p.setQuantity(p.getQuantity() - cart.getQuantity());
            pr.save(p);
            crp.delete(cart);
        }
        o.setProducts(products);
        or.save(o);
    }
   
    public List<CustomerOrder> getOrderById(Long id) {
        Customers c = cr.findById(id).orElseThrow(() -> new ExceptionClass("Customer not found"));
        return or.getOrderByCustomer(c);
    }
}