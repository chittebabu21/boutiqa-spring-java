package com.assignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
	// find by product name
	Product findByProductName(String productName);
}
