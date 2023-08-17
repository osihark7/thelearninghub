package com.dreamsathis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PaymentController {
	
	@GetMapping("/payments")
	public String getPayment() {
		System.out.println("hellosss");
		
		return "payment";
	}

}
