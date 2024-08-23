package com.clonemintra.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clonemintra.entity.Product;
import com.clonemintra.entity.Users;
import com.clonemintra.exception.UserNotFoundException;
import com.clonemintra.repository.UserRepository;
import com.clonemintra.serviceInterface.User_Service_Interface;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements User_Service_Interface{

//	@Autowired
	private final UserRepository userRepository;
	
	
	
	// ---------------------------------------------------------------------------------------------------
	@Autowired
	public UserService(UserRepository userRepository) {
//		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
	
	// ---------------------------------------------------------------------------------------------------

	@Override
	public Optional<Users> findUserById(Integer id) throws UserNotFoundException{
		
		Optional<Users> u1 = userRepository.findById(id);
		if(u1.isPresent()) {
				return u1;
		}
		throw new UserNotFoundException("User with id "+id+" does not exist Please Enter a valid UserId");
		
	}
	
	// ---------------------------------------------------------------------------------------------------

	@Override
	public Users addNewUser(Users u1) {
		return userRepository.save(u1);
	}
	
	// ---------------------------------------------------------------------------------------------------

	@Override
	public Optional<Users> deleteUserByid(Integer id) throws UserNotFoundException{
		
		Optional<Users> deleteditemUsers = userRepository.findById(id);
		
		if(deleteditemUsers.isPresent()) {
			userRepository.deleteById(id);
			return deleteditemUsers;
		}
		throw new UserNotFoundException("");
		
	}
	
	// ---------------------------------------------------------------------------------------------------

	@Override
	public Users updateUserById(Users u2,Integer id3) throws UserNotFoundException{
		
		Optional<Users> u3 = userRepository.findById(id3);
		
		if(u3.isPresent()) {
			
			Users users = userRepository.findById(id3).orElseThrow();
			
			if(u2.getName()!=null) {
				users.setName(u2.getName());
			}
			if(u2.getMobileNo()!=null) {
				users.setMobileNo(u2.getMobileNo());
			}
			if(u2.getPassword()!=null) {
				users.setPassword(u2.getPassword());
			}
			
			return userRepository.save(users);
			
		}
		
		throw new UserNotFoundException("User with id "+id3+" does not exist Please Enter a valid UserId");
		
	}
	
	// ---------------------------------------------------------------------------------------------------


	// ---------------------------------------------------------------------------------------------------


	// ---------------------------------------------------------------------------------------------------

}
