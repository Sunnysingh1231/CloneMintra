package com.clonemintra.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clonemintra.entity.Users;
import com.clonemintra.repository.userDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	private userDetailsRepository userDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String e) throws UsernameNotFoundException {
		
		Optional<Users> userr = userDetailsRepository.findUserByEmail(e);		
		return userr.orElseThrow(() -> new UsernameNotFoundException("//invalid user"));
		
	}
}
