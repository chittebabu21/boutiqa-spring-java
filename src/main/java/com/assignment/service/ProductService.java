package com.assignment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.model.Product;
import com.assignment.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	// get access to repository
	@Autowired
	private ProductRepository productRepository;
	
	// get all products
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}
	
	// insert new peoduct
	public void insert(Product product) {
		productRepository.save(product);
	}
	
	// delete a product by id
	public void delete(Product product) {
		productRepository.delete(product);;
	}
	
	// get product by name
	public Product getProductByName(String productName) {
		return productRepository.findByProductName(productName);
	}
}
