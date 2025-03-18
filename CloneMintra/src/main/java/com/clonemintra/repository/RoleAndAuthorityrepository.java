package com.clonemintra.repository;

import java.security.Identity;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clonemintra.entity.RoleAndAuthority;

@Repository
public interface RoleAndAuthorityrepository extends JpaRepository<RoleAndAuthority, Integer>{

	RoleAndAuthority findByName(String name);
}
