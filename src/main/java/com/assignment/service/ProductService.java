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
	
	// find product through search query
	public List<Product> search(String searchTerm) {
		return productRepository.findBySearchTerm(searchTerm);
	}
}
