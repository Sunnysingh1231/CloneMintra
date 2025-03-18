package com.clonemintra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.clonemintra.entity.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress, Integer>{

	@Query("SELECT ua FROM UserAddress ua Join users u where u.userId = :id")
	List<UserAddress> findAllUserAddressByUsers(@Param("id")Integer id);
}
