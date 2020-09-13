package com.ordermngnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordermngnt.dto.OrderDto;
import com.ordermngnt.entity.OrdersEntity;
import com.ordermngnt.services.OrderService;
import com.ordermngnt.utils.ResponseUtils;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
	
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/welcome")
	public String welcomeMsg()
	{
		return "Welcome To Rest API Controller";
	}
	
	@RequestMapping(value="/orderList",method=RequestMethod.GET)
	public List<OrderDto> doGetOrderList()
	{
		System.out.println("do Get OrderList Start");
		return orderService.doGetOrderList();
	}
	
	@RequestMapping(value="/saveOrder",method=RequestMethod.POST)
	public ResponseUtils saveOrder(@RequestBody OrderDto orderDto) 
	{
		System.out.println("Customer Name :"+orderDto.getCustomerName());
		return orderService.saveOrder(orderDto);
	}
	
	

}
