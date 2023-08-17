package com.dreamsathis.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/home")
public class PaymentIntegrationController {
	/*
	 * @Value("${rzp_key_id}") private String keyId;
	 * 
	 * @Value("${rzp_key_secret}") private String secret;
	 * 
	 * @PostMapping("/payment") public String pyment(@ModelAttribute PaymentAccount
	 * account) throws RazorpayException { RazorpayClient razorpayClient = new
	 * RazorpayClient(keyId,secret); JSONObject options = new JSONObject();
	 * options.put("amount", account.getAmount()*100); options.put("currency",
	 * "INR"); options.put("receipt", "txn_123456"); Order order =
	 * razorpayClient.Orders.create(options); return order.toString(); }
	 */
	

}
