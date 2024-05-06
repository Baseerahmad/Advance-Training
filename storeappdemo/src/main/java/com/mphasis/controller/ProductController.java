package com.mphasis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.domain.Product;
import com.mphasis.service.IProductService;

//@Controller
@RestController
@Scope("request")
//@RequestMapping(value = "/products")
 
//@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	@Qualifier("productService")
	private IProductService productService;

	@RequestMapping("/")
	//@ResponseBody
	public String greet() {
		
		return "Hello to all!jjj!";
	}
	
	
	//http://localhost:8080/products
	//@RequestMapping(value="/getprod", method = RequestMethod.GET,	produces = { MediaType.APPLICATION_JSON_VALUE })
	//@ResponseBody
	@GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Product> getAllProducts() {
		 
		return productService.getAllProducts();
	}
	
	//http://localhost:8080/products/1
	@GetMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Product getProductById(@PathVariable("id") int id) {
		
		return productService.getProductById(id);
	}
	
	@GetMapping(value = "/products/name/{name}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Product> getAllProductsByName(@PathVariable("name") String name) {

		return productService.getAllProductsByName(name);
	}
	
	@GetMapping(value = "/products/price/{price}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Product> getAllProductsByPrice(@PathVariable("price") Double price) {

		return productService.getAllProductsByPrice(price);
	}
		
	@PostMapping(value = "/products", 
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product addProduct(@RequestBody Product product) {
		
		return productService.save(product);
	}
	
	@PutMapping(value = "/products", 
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Product updateProduct(@RequestBody Product product) {
		
		return productService.update(product);
	}
	
		
	
	// 200
	// 204
	@DeleteMapping(value = "/products/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteProductById(@PathVariable("id") int id) {
			
		productService.delete(id);
	}
	
	@PatchMapping(value = "/products/{id}",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void patchProduct(
			@RequestBody Map<String, Object> updates, 
			@PathVariable("id") int id) {
		productService.patchProduct(updates, id);
	}
	
	@GetMapping(value = "/products/ordername", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Product> getAllSortedProducts( ) {

		return productService.getAllSortedProducts();
	}
}






















