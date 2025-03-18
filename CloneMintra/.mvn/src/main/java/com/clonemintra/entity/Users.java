package com.clonemintra.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "users")
public class Users implements UserDetails, CredentialsContainer{  // lode user by user name implements UserDetails,CredentialsContainer

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
	@Column(length = 10,unique = true)
	private String mobileNo;

//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$",
//            message = "Password must be 8-16 characters long, contain at least one digit, one special character, and one uppercase letter")
//	@Column(length = 16)
	@Size(min = 8)
	private String password;

	@Column(length = 35,unique = true)
	@Email(message = "Email should be valid")
	@Nullable
	@Pattern(
	        regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",
	        message = "Email must be a valid Gmail address"
	    )
	private String email;

	@CreationTimestamp
	private LocalDateTime createdAt;

	// --------Join Tables----------------------------------------------------------------------------------

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<UserAddress> userAddress = new ArrayList<>();

	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Wishlist wishlist;
	
	@OneToOne(mappedBy = "users",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
	private Bag bag;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "Roles_and_Authorities",
			joinColumns = @JoinColumn(referencedColumnName = "userId"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
		)
	private Set<RoleAndAuthority> roleAndAuthorities = new HashSet<>();

	@Override
	public void eraseCredentials() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//Code to convert the roles and authority to the Collection<? extends GrantedAuthority>
		Set<SimpleGrantedAuthority> set = new HashSet<>();
		for(RoleAndAuthority role : roleAndAuthorities) {
			set.add(new SimpleGrantedAuthority(role.getName()));
		}
		return set;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}
