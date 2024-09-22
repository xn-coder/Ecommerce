package com.xncoder.Ecommerce.Carts;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xncoder.Ecommerce.Customer.Customers;
import com.xncoder.Ecommerce.ExceptionClass;
import com.xncoder.Ecommerce.Customer.CustomerRepository;
import com.xncoder.Ecommerce.Products.Product;
import com.xncoder.Ecommerce.Products.ProductRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cr;
	
	@Autowired
	private CustomerRepository cmr;
	
	@Autowired
	private ProductRepository pr;
	
	public Carts getCartById(Long cartId) {
		return cr.findById(cartId).orElseThrow(() -> new ExceptionClass("Cart is not found."));
	}
	
	public void addProductToCart(Long customerId, Long productId) {
        Optional<Customers> customer = cmr.findById(customerId);
        Optional<Product> product = pr.findById(productId);

        if (customer.isPresent() && product.isPresent()) {
            Carts cartItem = cr.findByCustomerAndProduct(customer.get(), product.get());

            if (cartItem != null) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
            } else {
                cartItem = new Carts();
                cartItem.setCustomer(customer.get());
                cartItem.setProduct(product.get());
                cartItem.setQuantity(1);
            }
            
            cr.save(cartItem);
        } else {
            throw new RuntimeException("Customer or Product not found");
        }
    }
	
	public void removeProductFromCart(Long customerId, Long productId) {
        Optional<Customers> customer = cmr.findById(customerId);
        Optional<Product> product = pr.findById(productId);

        if (customer.isPresent() && product.isPresent()) {
            Carts cartItem = cr.findByCustomerAndProduct(customer.get(), product.get());

            if (cartItem != null) {
                if (cartItem.getQuantity() > 1) {
                    cartItem.setQuantity(cartItem.getQuantity() - 1);
                    cr.save(cartItem);
                } else {
                    cr.delete(cartItem);
                }
            } else {
                throw new RuntimeException("Product is not in the cart");
            }
        } else {
            throw new RuntimeException("Customer or Product not found");
        }
    }
	
	public int getCartProductCount(Long customerId) {
        List<Carts> cartItems = cr.findByCustomerId(customerId);

        int totalQuantity = cartItems.stream()
                .mapToInt(Carts::getQuantity)
                .sum();

        return totalQuantity;
    }

	public List<CartDTO>getAllCartProducts(Long customerId) {
		List<CartDTO> carts = new ArrayList<CartDTO>();
		for(Carts cart: cr.findByCustomerId(customerId)) {
			CartDTO c = new CartDTO(cart.getId(), cart.getProduct().getProduct_id(), Base64.getEncoder().encodeToString(cart.getProduct().getImage()), cart.getProduct().getName(), cart.getQuantity(), cart.getProduct().getPrice());
			carts.add(c);
		}
		return carts;
	}
	
}
