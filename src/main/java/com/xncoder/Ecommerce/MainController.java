package com.xncoder.Ecommerce;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xncoder.Ecommerce.Orders.CustomerOrder;
import com.xncoder.Ecommerce.Orders.OrderDTO;
import com.xncoder.Ecommerce.Orders.OrderService;
import com.xncoder.Ecommerce.Orders.ProdDTO;
import com.xncoder.Ecommerce.Products.Product;
import com.xncoder.Ecommerce.Products.ProductDTO;
import com.xncoder.Ecommerce.Products.ProductServices;

@Controller
public class MainController {
	@Autowired
	private ProductServices ps;
	
	@Autowired
	private OrderService os;

	@GetMapping("/")
	public String home(Model model) {
		List<Product> products = ps.getAllProducts();
		List<ProductDTO> productDTOs = products.stream().map(product -> {
            String base64Image = Base64.getEncoder().encodeToString(product.getImage());
            return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), base64Image);
        }).collect(Collectors.toList());
		model.addAttribute("products", productDTOs);
		return "index";
	}

	@GetMapping("/history")
	public String history() {
		return "order_history";
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
	
	@GetMapping("/order_success/{orderid}")
	public String order(@PathVariable Long orderid, Model model) {
		CustomerOrder c = os.getOrderById(orderid);
		List<ProdDTO> prod = new ArrayList<ProdDTO>();
		for(int i=0; i<c.getQuantity().size(); i++) {
			prod.add(new ProdDTO(ps.getProductByID(c.getProducts().get(i)).getName(), c.getPrice().get(i), c.getQuantity().get(i)));
		}
		model.addAttribute("order", new OrderDTO(orderid, c.getName(), c.getEmail(), c.getMobile(), c.getAddress(), c.getPayment(), c.getTotalprice(), prod));
		return "order_success";
	}
	
	@GetMapping("/view_order/{orderid}")
	public String view(@PathVariable Long orderid, Model model) {
		CustomerOrder c = os.getOrderById(orderid);
		List<ProdDTO> prod = new ArrayList<ProdDTO>();
		for(int i=0; i<c.getQuantity().size(); i++) {
			prod.add(new ProdDTO(c.getName(), c.getPrice().get(i), c.getQuantity().get(i)));
		}
		model.addAttribute("order", new OrderDTO(orderid, c.getName(), c.getEmail(), c.getMobile(), c.getAddress(), c.getPayment(), c.getTotalprice(), prod));
		return "view_order";
	}

	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
}
