package com.shopping.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.model.Products;

public interface ProductRepo extends JpaRepository<Products, Long>{
void deleteProductById(Long id);
	
	Optional<Products> findProductById(Long id);
}
