package com.Food_Delivery.controller;

public class FoodController {
	public class ProductController {
		private final ProductService productService;
		
		
	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }
		
		
	    public Product createProduct(@RequestBody Product product) {
	        return productService.saveProduct(product);
	    }
		
		
	    public Product getProductById(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }
		
	
	    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        return productService.updateProduct(id, product);
	    }
		
		
	    public void deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	    }
	}


}
