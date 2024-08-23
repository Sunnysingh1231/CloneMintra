package com.clonemintra.serviceInterface;

import java.util.List;

import com.clonemintra.entity.UserAddress;

public interface UserAddressService {

	public List<UserAddress> findAllUserAddressByUserId(Integer id);
}
