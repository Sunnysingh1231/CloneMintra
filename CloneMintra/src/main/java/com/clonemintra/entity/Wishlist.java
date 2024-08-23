package com.clonemintra.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Wishlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// --------Join Tables----------------------------------------------------------------------------------
	
	@OneToOne
//	@JoinTable(name = "user_id")
	@JoinColumn(name = "user_id")
	private Users users;
	
	@ManyToMany
	@JoinTable(name = "wishlist_product",
				joinColumns = @JoinColumn(name = "wishlist_id"),
				inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products = new ArrayList<>();

	// -------Getter & Setters-------------------------------------------------------------------------------

//	public int getWishlist_id() {
//		return id;
//	}
//
//	public void setWishlist_id(int wishlist_id) {
//		this.id = wishlist_id;
//	}

//	public Users getUsers() {
//		return users;
//	}

//	public void setUsers(Users users) {
//		this.users = users;
//	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Wishlist [products=" + products + "]";
	}

	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
