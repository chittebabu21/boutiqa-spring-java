package com.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	// find by product name
	// SELECT p FROM Product p WHERE p.name LIKE %:searchTerm% OR p.description LIKE %:searchTerm%
	@Query("SELECT p FROM Product p WHERE p.productName LIKE %:searchTerm%")
	List<Product> findBySearchTerm(@Param("searchTerm") String searchTerm);
}
