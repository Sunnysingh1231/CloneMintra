package com.clonemintra.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.clonemintra.entity.Product;
import com.clonemintra.exception.ProductNotFoundException;
import com.clonemintra.serviceImpl.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductController {

	@Autowired
	private ProductService productService;

	// ---------------------------------------------------------------------------------------------------

	@GetMapping("/findallproduct") // GET http://localhost:1999/findallproduct
	public ResponseEntity<List<Product>> getAllProduct() {
		return new ResponseEntity<List<Product>>(productService.findAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/findproductbyid/{id}") // GET http://localhost:1999/findproductbyid/{id}
	public ResponseEntity<Optional<Product>> findProductById(@PathVariable("id") int id)
			throws ProductNotFoundException {
		return new ResponseEntity<Optional<Product>>(productService.findProductById(id), HttpStatus.OK);
	}
	
	@GetMapping("/wishlistedproductbyuser/{id}") // GET http://localhost:1999/wishlistedproductbyuser/{id}
	public ResponseEntity<List<Product>> findWishlistedProductByUserId(@PathVariable("id") Integer id) throws ProductNotFoundException {		
		return new ResponseEntity<List<Product>>(productService.allProductWishlistedByUser(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/findbaglistproductbyid/{id}") // GET http://localhost:1999/findbaglistproductbyid/{id}
	public ResponseEntity<List<Product>> findAllProductBagListByUser(@PathVariable("id") Integer id) {
		return new ResponseEntity<List<Product>>(productService.allProductBagListByUser(id), HttpStatus.OK);
	}
	

	@PostMapping("/addnewproduct") // POST http://localhost:1999/addnewproduct
	public ResponseEntity<String> addProduct(@Valid @RequestBody Product p3, BindingResult result) {
		productService.addNewProduct(p3);
		return new ResponseEntity<String>("product added successfully", HttpStatus.CREATED);
	}

	@PatchMapping("updateproductbyid/{id}") // PATCH http://localhost:1999/updateproductbyid/{id}
	public ResponseEntity<Product> modifyProduct(@PathVariable("id") Integer id, @RequestBody Product p5)
			throws ProductNotFoundException {
		return new ResponseEntity<Product>(productService.updateProductById(id, p5), HttpStatus.OK);
	}

	@DeleteMapping("/deletproductebyid/{id}") // DELETE http://localhost:1999/deletproductebyid/{id}
	public ResponseEntity<Product> deletebyidd(@PathVariable("id") Integer id) throws ProductNotFoundException {
		return new ResponseEntity<Product>(productService.deleteProductById(id), HttpStatus.OK);
	}
	
	
	

}
