package com.mphasis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mphasis.domain.Product;
import com.mphasis.repository.ProductRepository;
 
@SpringBootApplication
public class StoreappdemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StoreappdemoApplication.class, args);
	}

	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		productRepository.save(new Product(0, "LG super", 54433.0));
		productRepository.save(new Product(0, "Sony", 34433.0));
		productRepository.save(new Product(0, "Samsung", 24433.0));
		productRepository.save(new Product(0, "Lenovo", 44433.0));
		
		List<Product> pr=productRepository.findAll();
		System.out.println("Product id" +"Product Name"+ "Product Price");
		for(Product p:pr) 
		System.out.println(p.getId()+"      "+p.getName()+"   "+p.getPrice());
		
		productRepository.deleteById(4);
		
		System.out.println(productRepository.findAll());
	}

}
