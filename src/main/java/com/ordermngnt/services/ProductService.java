package com.ordermngnt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermngnt.dto.ProductDto;
import com.ordermngnt.entity.ProductEntity;
import com.ordermngnt.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	

	public List<ProductDto> doGetProductList() {
		// TODO Auto-generated method stub
		List<ProductEntity> productEntity=new ArrayList<ProductEntity>();
		List<ProductDto> productDtoList=new ArrayList<>();
		try
		{
			productEntity=productRepository.doGetProductList();
			System.out.println("Product List"+productEntity.size());
			
			productEntity.forEach(product->
			{
				ProductDto productDto=new ProductDto();
				productDto.setProductId(String.valueOf(product.getProductId()));
				productDto.setPrice(product.getPrice());
				productDto.setProductName(product.getProductName());
				productDto.setQuantity(product.getQuantity());
				productDtoList.add(productDto);
				
			});
		}catch(Exception e)
		{
			System.out.println("Error :"+e.getMessage());
		}
		return productDtoList;
	}
	
}
