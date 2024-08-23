package com.clonemintra.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {

// ------------Model----------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String product_image;
	
//	@NotNull(message = "Must be provide Brand name")
	@Column(length = 30)
	private String brand_name;
	
	@Column(length = 30)
	private String category;
	
	@Column(length = 30)
	private String type;
	
	@Column(length = 6)
	private int sale_price;
	
	@Column(length = 6)
	private int market_price;
	
	
	
	// --------Join Tables----------------------------------------------------------------------------------
	
	@ManyToMany(mappedBy = "products")
	private List<Wishlist> wishlists;
	
	@ManyToMany(mappedBy = "products")
	private List<Bag> bags;
	
	// -------Getter & Setters-------------------------------------------------------------------------------

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Product(int id, String product_image, String brand_name, String category, String type, int sale_price,
			int market_price) {
		super();
		this.id = id;
		this.product_image = product_image;
		this.brand_name = brand_name;
		this.category = category;
		this.type = type;
		this.sale_price = sale_price;
		this.market_price = market_price;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSale_price() {
		return sale_price;
	}

	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}

	public int getMarket_price() {
		return market_price;
	}

	public void setMarket_price(int market_price) {
		this.market_price = market_price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_image=" + product_image + ", brand_name=" + brand_name + ", category="
				+ category + ", type=" + type + ", sale_price=" + sale_price + ", market_price=" + market_price
				+ "]";
	}
	
}
