package com.clonemintra.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users implements UserDetails,CredentialsContainer{

//	@NotNull(message = "User id must not be null")	//it Allow empty string and 0
//	@Min(value = 1L, message = "id must be a +ive integer")	//is same as
//	@Positive(message = "id must be a +ive integer")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

//	@NotEmpty(message = "you must provide the customer name")	//null, "": Not accept " ": accepted
	@NotBlank(message = "you must provide the customer name") // null, "", " ": Not accept
	@Size(min = 3, message = "name must be of 3 characters at least")
	@Column(length = 30)
	private String name;

	@Pattern(regexp = "[6-9][0-9]{9}$", message = "Invalid mobile no.")
	@Column(length = 10)
	private String mobileNo;

//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$",
//            message = "Password must be 8-16 characters long, contain at least one digit, one special character, and one uppercase letter")
	@Column(length = 120)
	private String password;

	@Column(length = 35)
	@Email(message = "Email should be valid")
	@Nullable
//	@Pattern(
//	        regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",
//	        message = "Email must be a valid Gmail address"
//	    )
	private String email = "***@gmail.com";

	@CreationTimestamp
	private LocalDateTime createdAt;

	// --------Join Tables----------------------------------------------------------------------------------

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<UserAddress> userAddress = new ArrayList<>();

	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Wishlist wishlist;
	
	@OneToOne(mappedBy = "users",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
	private Bag bag;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Roles_and_Authorities",
			joinColumns = @JoinColumn(referencedColumnName = "userId"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
		)
	private Set<RoleAndAuthority> roleAndAuthorities = new HashSet<>();

	// -------Getter & Setters-------------------------------------------------------------------------------

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// -------Cunstructor using field-------------------------------------------------------------------------------

	public Users(int userId,
			@NotBlank(message = "you must provide the customer name") @Size(min = 3, message = "name must be of 3 characters at least") String name,
			@Pattern(regexp = "[6-9][0-9]{9}$", message = "Invalid mobile no.") String mobileNo, String password,
			@Email(message = "Email should be valid") String email, LocalDateTime createdAt,
			List<UserAddress> userAddress, Wishlist wishlist, Bag bag, Set<RoleAndAuthority> roleAndAuthorities) {
		super();
		this.userId = userId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.password = password;
		this.email = email;
		this.createdAt = createdAt;
		this.userAddress = userAddress;
		this.wishlist = wishlist;
		this.bag = bag;
		this.roleAndAuthorities = roleAndAuthorities;
	}

	// -------Getter & Setters-------------------------------------------------------------------------------

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

	public List<UserAddress> getUserAddress() {
		return userAddress;
	}

//	public void setUserAddress(List<UserAddress> userAddress) {
//		this.userAddress = userAddress;
//	}

	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

	public Bag getBag() {
		return bag;
	}

	public void setBag(Bag bag) {
		this.bag = bag;
	}
	
	

	public Set<RoleAndAuthority> getRoleAndAuthorities() {
		return roleAndAuthorities;
	}

//	public void setRoleAndAuthorities(Set<RoleAndAuthority> roleAndAuthorities) {
//		this.roleAndAuthorities = roleAndAuthorities;
//	}
	
	// --------------------------------------------------------------------------------------

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eraseCredentials() {
		// TODO Auto-generated method stub
		
	}

}
