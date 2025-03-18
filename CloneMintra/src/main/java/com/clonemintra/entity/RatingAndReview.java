package com.clonemintra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class RatingAndReview {
	
	@Id
	private int id;
	
	private int rating;
	
	private int count;

	@OneToOne
	private Product proRating;
}
