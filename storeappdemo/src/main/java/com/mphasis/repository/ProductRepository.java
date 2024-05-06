package com.mphasis.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mphasis.domain.Product;

@Repository("productRepository")
@Scope("singleton")
public interface ProductRepository extends JpaRepository<Product, Integer>{

	//user defined methods
	List<Product> findByNameLike(String name);
	
	List<Product> findByPrice(Double price);
	
	@Query(value = "SELECT e FROM Product e ORDER BY name")
	   public List<Product> findAllSorted();
}
