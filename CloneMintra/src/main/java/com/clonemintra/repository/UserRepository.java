package com.clonemintra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clonemintra.entity.Users;

@Repository
//@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Users, Integer>{

//	@Query("select p from products p join wishlist_product wp on p.id = wp.product_id join wishlist w on wp.wishlist_id = w.id join users u on w.user_id = u.user_id where u.user_id = :id")
//	Optional<List<Users>> findAllProductsIntWishlistByUser();

//	@Query("select p from products p "+"join wishlist_product wp on p.id = wp.product_id "+"join wishlist w on wp.wishlist_id = w.id "+" join users u on w.user_id = u.user_id "+" where u.user_id = :id")
//	public String findAllProductsIntWishlistByUser(Integer id);
	
//	@Query("SELECT u FROM users u where id = :id")
//	public String findAllProductsIntWishlistByUser(Integer id);
	
	@Query("SELECT u FROM Users u")
	List<Users> xxx();
	
}
