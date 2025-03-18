package com.clonemintra.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clonemintra.entity.Product;
import com.clonemintra.exception.ProductNotFoundException;
import com.clonemintra.repository.ProductRepository;
import com.clonemintra.serviceInterface.ProductServiceInterface;

@Service
public class ProductService implements ProductServiceInterface{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public Optional<Product> findProductById(Integer id1) throws ProductNotFoundException{
		
		Optional<Product> p1 = productRepository.findById(id1);
		if(p1.isPresent()) {
			return p1;
		}
		
		throw new ProductNotFoundException("Product with id "+id1+"does not exist.");
	}
	
	@Override
	public Product addNewProduct(Product pro) {
		 return productRepository.save(pro);
	}
	
	@Override
	public Product updateProductById(Integer id2, Product p2) throws ProductNotFoundException {
		
		Optional<Product> p3 = productRepository.findById(id2);
		
		if(p3.isPresent()) {
			
			Product p4 = productRepository.findById(id2).orElseThrow();
			
			if(p2.getBrand_name()!=null) {
				p4.setBrand_name(p2.getBrand_name());
			}
			if(p2.getCategory()!=null) {
				p4.setCategory(p2.getCategory());
			}
			if(p2.getMarket_price()!=0) {
				p4.setMarket_price(p2.getMarket_price());
			}
			if(p2.getProduct_image()!=null) {
				p4.setProduct_image(p2.getProduct_image());
			}
			if(p2.getSale_price()!=0) {
				p4.setSale_price(p2.getSale_price());
			}
			if(p2.getType()!=null) {
				p4.setType(p2.getType());
			}
			return productRepository.save(p4);
		}
		
		throw new ProductNotFoundException("Product with id "+id2+"does not exist.");
		
	}
	
	@Override
	public Product deleteProductById(Integer id) throws ProductNotFoundException{
		
		Optional<Product> p5 = productRepository.findById(id);
		
		if(p5.isPresent()) {
			Product p6 = productRepository.findById(id).orElseThrow();
			productRepository.deleteById(id);
			return p6;
		}
		
		throw new ProductNotFoundException("Product with id "+id+"does not exist.");
	}

	@Override
	public List<Product> allProductWishlistedByUser(Integer userId) {
		return productRepository.findWishlistProductByUserId(userId);
	}

	@Override
	public List<Product> allProductBagListByUser(Integer userId) {
		return productRepository.findBagListProductByUserId(userId);
	}
	
	
	
	
	

}
