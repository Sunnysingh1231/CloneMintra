package com.clonemintra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clonemintra.entity.Bag;
import com.clonemintra.entity.Product;

@Repository
public interface BagRepository extends JpaRepository<Bag, Integer>{

	
}
