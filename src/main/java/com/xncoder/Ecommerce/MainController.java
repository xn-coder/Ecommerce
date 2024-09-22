package com.xncoder.Ecommerce;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.xncoder.Ecommerce.Products.Product;
import com.xncoder.Ecommerce.Products.ProductDTO;
import com.xncoder.Ecommerce.Products.ProductServices;

@Controller
public class MainController {
	@Autowired
	private ProductServices ps;

	@GetMapping("/")
	public String home(Model model) {
		List<Product> products = ps.getAllProducts();
		List<ProductDTO> productDTOs = products.stream().map(product -> {
            String base64Image = Base64.getEncoder().encodeToString(product.getImage());
            return new ProductDTO(product.getProduct_id(), product.getName(), product.getDescription(), product.getPrice(), base64Image);
        }).collect(Collectors.toList());
		model.addAttribute("products", productDTOs);
		return "index";
	}
	
	@GetMapping("/history")
	public String history() {
		return "history";
	}
	
	@GetMapping("/seller")
	public String seller(Model model) {
		model.addAttribute("product", new Product());
		return "seller";
	}
	
	@GetMapping("/login_or_signup")
	public String login_or_signup() {
		return "login_or_signup";
	}
	
	@GetMapping("/cart")
	public String cart(Model model) {
		return "cart";
	}
	
	@GetMapping("/buy")
	public String buy() {
		return "buy_now";
	}
	
	@GetMapping("/order_success")
	public String order() {
		return "order_success";
	}

	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
}
