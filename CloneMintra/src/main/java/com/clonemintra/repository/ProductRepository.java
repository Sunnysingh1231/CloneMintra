package com.clonemintra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clonemintra.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

//	@Query("select u from product u where id = 4")
//	List<Product> newpdtList(String name);
	

	
//	@Query("SELECT p FROM Product p "
//			+"JOIN p.wishlist_Product wp "
//			+"JOIN wp.wishlist w "
//			+"JOIN w.users u "
//			+"WHERE u.userId = :id")
	
	@Query("SELECT p FROM Product p "
			+"JOIN p.wishlists w "
			+"JOIN w.users u "
			+"WHERE u.userId = :userId")
	List<Product> findWishlistProductByUserId(@Param("userId") Integer wishlistId);
	
	
	@Query("SELECT p FROM Product p "
			+"JOIN p.bags b "
			+"JOIN b.users u "
			+"where u.userId = :userId")
	List<Product> findBagListProductByUserId(@Param("userId") Integer id); 
}
