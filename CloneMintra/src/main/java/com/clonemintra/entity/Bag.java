package com.clonemintra.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
//@Table(name = "bag")
public class Bag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
//	@JoinTable(joinColumns = @JoinColumn(name = "user_idd"))
	@JoinColumn(name = "user_id")
	private Users users;
	
	@ManyToMany
	@JoinTable(name  = "bag_product", 
				joinColumns = @JoinColumn(name = "bag_id"),
				inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;

	public Bag(int id, Users users, List<Product> products) {
		super();
		this.id = id;
		this.users = users;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
//
//	public Users getUsers() {
//		return users;
//	}
//
	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Product> getProducts() {
		return products;
	}

//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}

	public Bag() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
