package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.UserNotFoundException;
import com.shopping.model.Products;
import com.shopping.repo.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo productRepo;
	
	@Autowired
	public ProductService(ProductRepo productRepo) {
		super();
		this.productRepo = productRepo;
	}
	public Products addProduct(Products product) {
		return productRepo.save(product);
	}
	
	public List<Products> findAllProducts(){
		return productRepo.findAll();
	}
	
	public Products updateProduct(Products product) {
		return productRepo.save(product);
	}
	
	public Products findProductById(Long id) {
		return productRepo.findProductById(id).orElseThrow(() -> new UserNotFoundException("Product by id "+id+" was not found"));
	}
	
	 public void deleteProduct(Long id){
	        productRepo.deleteProductById(id);
	    }
}
