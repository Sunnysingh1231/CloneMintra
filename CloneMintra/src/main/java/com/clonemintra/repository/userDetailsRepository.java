package com.clonemintra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clonemintra.entity.Users;

@Repository
public interface userDetailsRepository extends JpaRepository<Users, Integer>{

	Optional<Users> findUserByName(String name);
	
}
