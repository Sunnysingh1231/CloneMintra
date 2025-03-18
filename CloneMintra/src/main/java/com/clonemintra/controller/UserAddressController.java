package com.clonemintra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.clonemintra.entity.UserAddress;
import com.clonemintra.serviceImpl.UserAddressServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserAddressController {

	
	@Autowired
	private UserAddressServiceImpl userAddressServiceImpl;
	
	@GetMapping("findalluseraddress/{id}")  //  GET http://localhost:1999/findalluseraddress/{id}
	public ResponseEntity<List<UserAddress>>findAllUserAddress(@PathVariable("id") Integer id) {
		return new ResponseEntity<List<UserAddress>>(userAddressServiceImpl.findAllUserAddressByUserId(id),HttpStatus.OK);
	}
	
	
}
