package com.clonemintra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clonemintra.entity.UserAddress;
import com.clonemintra.repository.UserAddressRepository;
import com.clonemintra.serviceInterface.UserAddressService;

@Service
public class UserAddressServiceImpl implements UserAddressService{
	
	@Autowired
	private UserAddressRepository userAddressRepository;

	@Override
	public List<UserAddress> findAllUserAddressByUserId(Integer id) {
		return userAddressRepository.findAllUserAddressByUsers(id);
	}

}
