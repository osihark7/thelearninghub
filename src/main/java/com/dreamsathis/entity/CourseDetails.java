package com.dreamsathis.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CourseDetails {
	

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	
	private Long id;
	

}
