package com.dreamsathis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dreamsathis.bean.ResultDTO;
import com.dreamsathis.entity.Product;
import com.dreamsathis.utils.Constants;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/home")
public class ProductController extends BaseController {

	@PostMapping("/addProduct")
	public ResponseEntity<?> addCourse(@ModelAttribute Product product,
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "file3", required = false) MultipartFile file3) {
		System.err.println("::::::ProductController.addCourse::::");
		try {
			if (productRepository.existsByProductName(product.getProductName())) {
				responsePacket = new ResultDTO<>(true, null, "This Course is Already exists !!");
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else if (product.getProductName().isEmpty()) {
				responsePacket = new ResultDTO<>(true, null, "Please enter course name  !!");
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				productService.addProduct(product, file1, file2, file3);
				responsePacket = new ResultDTO<>(true, null, Constants.addData);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}

		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getProductList")
	public ResponseEntity<?> getCourseList() {
		System.err.println("::::::ProductController.getProductList::::");
		try {
			List<Product> courses = productRepository.findByStatus(true);
			if (courses.isEmpty()) {
				responsePacket = new ResultDTO<>(true, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>(true, courses, Constants.dataGetSucceed);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}

		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/getProductById")
	public ResponseEntity<?> getProductById(@ModelAttribute Product product) {
		System.err.println("::::::ProductController.getProductById::::");
		try {
			Optional<Product> courses = productRepository.findById(product.getId());
			if (courses.isPresent()) {
				responsePacket = new ResultDTO<>(true, courses, Constants.dataGetSucceed);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>(true, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	
}
