package com.ordermngnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordermngnt.dto.ProductDto;
import com.ordermngnt.services.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/productList")
	public List<ProductDto> doGetProductList()
	{
		return productService.doGetProductList();
	}
}
