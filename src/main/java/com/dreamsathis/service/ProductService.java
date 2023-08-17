package com.dreamsathis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dreamsathis.entity.Product;
import com.dreamsathis.repository.ProductRepository;
import com.dreamsathis.utils.Constants;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public void addProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) {
		
		String path = Constants.BASE_DIR + Constants.BLOG_IMAGE;
		String fname = Constants.getRandomPassword() + ".jpg";
		String fname2 = Constants.getRandomPassword() + ".jpg";
		String fname3 = Constants.getRandomPassword() + ".jpg";
		String fileName = Constants.saveMultiPartFile(file1, path, fname);
		String fileName2 = Constants.saveMultiPartFile(file2, path, fname2);
		String fileName3 = Constants.saveMultiPartFile(file3, path, fname3);
		String url = Constants.BASE_IP + Constants.BLOG_IMAGE;
		
		
		product.setImage1(fileName);
		product.setImage2(fileName2);
		product.setImage3(fileName3);
		product.setImgUrl(url);
		product.setStatus(true);
		product.setCreatedAt(Constants.getDateAndTime());
		product.setUpdatedAt(Constants.getDateAndTime());
		
		productRepository.save(product);
	}

}
