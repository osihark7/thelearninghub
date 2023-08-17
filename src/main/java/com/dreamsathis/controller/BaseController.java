package com.dreamsathis.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.dreamsathis.bean.ResultDTO;
import com.dreamsathis.repository.BlogDetailsRepository;
import com.dreamsathis.repository.CourseRepositoty;
import com.dreamsathis.repository.FeedbackRepository;
import com.dreamsathis.repository.ProductRepository;
import com.dreamsathis.service.BlogDetailsService;
import com.dreamsathis.service.CourseService;
import com.dreamsathis.service.FeedbackService;
import com.dreamsathis.service.ProductService;

public class BaseController {
	ResultDTO<?> responsePacket = null;
	
	@Autowired
	protected BlogDetailsRepository blogDetails;
	
	@Autowired
	protected BlogDetailsService blogDetailsService;
	
	
	@Autowired
	protected FeedbackRepository feedbackRepository;
	
	@Autowired
	protected FeedbackService feedbackService;
	
	@Autowired
	protected CourseRepositoty courseRepositoty;
	
	@Autowired
	protected CourseService courseService;
	
	@Autowired
	protected ProductRepository productRepository;
	
	@Autowired
	protected ProductService productService;

}
