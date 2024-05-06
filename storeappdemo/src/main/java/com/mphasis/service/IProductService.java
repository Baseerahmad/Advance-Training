package com.mphasis.service;

import java.util.List;
import java.util.Map;

import com.mphasis.domain.Product;

public interface IProductService {

	Product save(Product product);

	Product update(Product product);
	
	void patchProduct(Map<String, Object> updates, int id);

	void delete(int id);

	Product getProductById(int id);

	List<Product> getAllProducts();

	List<Product> getAllProductsByName(String name);

	List<Product> getAllProductsByPrice(Double price);
	
	List<Product> getAllSortedProducts();


}
