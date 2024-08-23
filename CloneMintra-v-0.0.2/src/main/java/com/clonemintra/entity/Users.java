package com.clonemintra.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {
	
//	@NotNull(message = "User id must not be null")	//it Allow empty string and 0
//	@Min(value = 1L, message = "id must be a +ive integer")	//is same as
//	@Positive(message = "id must be a +ive integer")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
//	@NotEmpty(message = "you must provide the customer name")	//null, "": Not accept " ": accepted
//	@NotBlank(message = "you must provide the customer name")	//null, "", " ": Not accept
//	@Size(min = 3, message="name must be of 3 characters at least")
//	@Column(length = 30)
	private String name;
	
//	@Pattern(regexp = "[6-9][0-9]{9}$", message = "Invalid mobile no.")
//	@Column(length = 10)
	private String mobileNo;
	
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$",
//            message = "Password must be 8-16 characters long, contain at least one digit, one special character, and one uppercase letter")
//	@Column(length = 16)
	private String password;
	
//	@Column(length = 35)
//	@Email(message = "Email should be valid")
//	@Nullable
//	@Pattern(
//	        regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",
//	        message = "Email must be a valid Gmail address"
//	    )
	private String email = "***@gmail.com";
	
	
	@CreationTimestamp
    private LocalDateTime createdAt;


	public Users(int userId, String name, String mobileNo, String password, String email, LocalDateTime createdAt) {
		super();
		this.userId = userId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.password = password;
		this.email = email;
		this.createdAt = createdAt;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", mobileNo=" + mobileNo + ", password=" + password
				+ ", email=" + email + ", createdAt=" + createdAt + "]";
	}
	
	// --------Join Tables----------------------------------------------------------------------------------

	
//	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//	private List<UserAddress> userAddress = new ArrayList<>();
////	
////	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
////	private List<Orders> usersOrders;
////	
//	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//	private Wishlist wishlist;
	
	// -------Getter & Setters-------------------------------------------------------------------------------

	
	
}
