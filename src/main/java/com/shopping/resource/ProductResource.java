package com.shopping.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Products;
import com.shopping.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {
	private final ProductService productService;

	public ProductResource(ProductService productService) {
		super();
		this.productService = productService;
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/all")
	public ResponseEntity<List<Products>> getAllProducts(){
		List<Products> products=productService.findAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/find/{id}")
    public ResponseEntity<Products> getProductById (@PathVariable("id") Long id) {
        Products product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
	@CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/add")
    public ResponseEntity<Products> addProduct(@RequestBody Products product) {
        Products newproduct = productService.addProduct(product);
        return new ResponseEntity<>(newproduct, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Products> updateProduct(@RequestBody Products product) {
        Products updateproduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateproduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
