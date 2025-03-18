package com.clonemintra.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clonemintra.entity.RoleAndAuthority;
import com.clonemintra.repository.RoleAndAuthorityrepository;
import com.clonemintra.serviceInterface.RoleAndAuthorityServiceInterface;

@Service
public class RoleAndAuthorityService implements RoleAndAuthorityServiceInterface {
	
	@Autowired
	private RoleAndAuthorityrepository roleAndAuthorityrepository;

	@Override
	public RoleAndAuthority RoleAndAuthorityFindByName(String name) {
		// TODO Auto-generated method stub
		return roleAndAuthorityrepository.findByName(name);
	}

}
