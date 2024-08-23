package com.clonemintra.serviceInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.clonemintra.entity.Product;
import com.clonemintra.entity.Users;
import com.clonemintra.exception.UserNotFoundException;

public interface User_Service_Interface {

	public List<Users> getAllUsers();
	
	public Optional<Users> findUserById(Integer id1) throws UserNotFoundException;
	
	public Users addNewUser(Users u1);
	
	public Optional<Users> deleteUserByid(Integer id2) throws UserNotFoundException;
	
	public Users updateUserById(Users u2,Integer id3) throws UserNotFoundException;
	
	public List<Users> xxxz();
		
}	
