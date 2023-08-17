package com.dreamsathis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dreamsathis.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

	boolean existsByProductName(String productName);

	List<Product> findByStatus(boolean b);

}
