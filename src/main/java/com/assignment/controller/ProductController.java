package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.model.Product;
import com.assignment.service.LoginService;
import com.assignment.service.ProductService;

@Controller
public class ProductController {
	// get product service
	@Autowired
	private ProductService productService;
	
	// get all products from search query
	@RequestMapping("/search")
	public String searchProducts(@RequestParam("searchTerm") String searchTerm, Model model) {
		List<Product> products = productService.search(searchTerm);
		if (products.isEmpty()) {
			model.addAttribute("error", "No products found...");
			return "products-list";
		} else {
			model.addAttribute("products", products);
			return "products-list";
		}
	}
	
}
