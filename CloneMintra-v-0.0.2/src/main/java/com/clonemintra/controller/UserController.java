package com.clonemintra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.clonemintra.entity.Product;
import com.clonemintra.entity.Users;
import com.clonemintra.exception.UserNotFoundException;
import com.clonemintra.serviceImpl.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController // ( @Controller+@RequestMapping )
//@RequestMapping("/users")

//@CrossOrigin(origins = "http://127.0.0.1:1999")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// ---------------------------------------------------------------------------------------------------

	@GetMapping("/findallusers") // GET http://localhost:1999/findallusers
	public ResponseEntity<List<Users>> allUsers() {
		ResponseEntity<List<Users>> allUsersEntity = new ResponseEntity<List<Users>>(userService.getAllUsers(),HttpStatus.OK);
		return allUsersEntity;
	}

	// ---------------------------------------------------------------------------------------------------

	@GetMapping("/finduserbyid/{id}") // GET http://localhost:1999/finduserbyid/id
	public ResponseEntity<Optional<Users>> findUserById(@PathVariable("id") int ID) throws UserNotFoundException {
		Optional<Users> findUserById = userService.findUserById(ID);
		if (findUserById.isPresent()) {
			return new ResponseEntity<Optional<Users>>(userService.findUserById(ID), HttpStatus.OK);
		}
		throw new UserNotFoundException("Invalid User id " + ID);
	}

	// ---------------------------------------------------------------------------------------------------

	@PostMapping("/addnewuser") // POST http://localhost:1999/addnewuser
	public ResponseEntity<Users> addUsers(@RequestBody Users u1) {
		
		String encryptedPass = passwordEncoder.encode(u1.getPassword());
		u1.setPassword(encryptedPass);
		
		return new ResponseEntity<Users>(userService.addNewUser(u1), HttpStatus.CREATED);
	}

	// ---------------------------------------------------------------------------------------------------

//	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@DeleteMapping("/deletebyid/{id}") // DELETE http://localhost:1999/deletebyid/{id}
	public ResponseEntity<Optional<Users>> deleteUsersbyid(@PathVariable("id") Integer id) throws UserNotFoundException {
		return new ResponseEntity<Optional<Users>>(userService.deleteUserByid(id), HttpStatus.OK);
	}

	// ---------------------------------------------------------------------------------------------------

	@PatchMapping("/updateusersbyid/{id}")  // PATCH http://localhost:1999/updateusersbyid/{id}
	public ResponseEntity<Users> updateUser(@PathVariable("id") int id, @RequestBody Users userDetails) throws UserNotFoundException {
		return new ResponseEntity<Users>(userService.updateUserById(userDetails, id), HttpStatus.OK);
	}

	// ---------------------------------------------------------------------------------------------------

//	@GetMapping("/findAllProductWishlistByUserweewwe") // GET http://localhost:1999/findallusers
//	public ResponseEntity<List<Users>> findAllProductWishlistByUserse() {
//		ResponseEntity<List<Users>> allUsersEntity = new ResponseEntity<List<Users>>(userService.findAllProductsIntWishlistByUser(),HttpStatus.OK);
//		return allUsersEntity;
//	}
}
