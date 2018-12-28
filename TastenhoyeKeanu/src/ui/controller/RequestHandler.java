package ui.controller;

import domain.model.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class RequestHandler {
	
	private ProductService productService;
	
	public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response);
	
	public void setModel (ProductService bookService) {
		this.productService = bookService;
	}

	public ProductService getProductService() {
		return productService;
	}
	
	
}
