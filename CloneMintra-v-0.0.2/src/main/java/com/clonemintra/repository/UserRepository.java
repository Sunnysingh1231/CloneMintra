package com.clonemintra.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.clonemintra.entity.Users;

@Repository
//@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Users, Integer>{

	
}
