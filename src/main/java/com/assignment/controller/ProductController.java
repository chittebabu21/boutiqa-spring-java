package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.model.Product;
import com.assignment.service.LoginService;
import com.assignment.service.ProductService;

@Controller
public class ProductController {
	// get product service
	@Autowired
	private ProductService productService;
	
	// get all products
	@GetMapping("/products-list")
	public String listAllProducts(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "products-list";
	}
}
