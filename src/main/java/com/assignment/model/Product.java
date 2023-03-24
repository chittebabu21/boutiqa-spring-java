package com.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_details")
public class Product {
	// variables
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "product_id")
		private Long productId;
		
		@Column(name = "product_name")
		private String productName;
		
		@Column(name = "product_description")
		private String productDescription;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "user_id")
		private Login login;
		
		// constructors
		public Product() {}

		public Product(Long productId, String productName, String productDescription, Login login) {
			this.productId = productId;
			this.productName = productName;
			this.productDescription = productDescription;
			this.login = login;
		}
		
		// getters and setters
		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getProductDescription() {
			return productDescription;
		}

		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}

		public Login getLogin() {
			return login;
		}

		public void setLogin(Login login) {
			this.login = login;
		}
		
}
