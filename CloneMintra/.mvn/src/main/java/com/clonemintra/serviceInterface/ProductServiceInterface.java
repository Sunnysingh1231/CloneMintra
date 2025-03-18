package com.clonemintra.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.clonemintra.entity.Product;
import com.clonemintra.exception.ProductNotFoundException;

public interface ProductServiceInterface {
	
	public List<Product> findAllProducts();
	
	public Optional<Product> findProductById(Integer id1) throws ProductNotFoundException;
	
	public Product addNewProduct(Product p1);
	
	public Product updateProductById(Integer id1, Product p2) throws ProductNotFoundException;
	
	public Product deleteProductById(Integer id1) throws ProductNotFoundException;
	
	public List<Product> allProductWishlistedByUser(Integer userId);
	
	public List<Product> allProductBagListByUser(Integer userId);

}
