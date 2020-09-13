package com.ordermngnt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermngnt.dto.OrderDto;
import com.ordermngnt.entity.ItemsEntity;
import com.ordermngnt.entity.OrdersEntity;
import com.ordermngnt.entity.ProductEntity;
import com.ordermngnt.repository.ItemsRepository;
import com.ordermngnt.repository.OrderRepository;
import com.ordermngnt.utils.ResponseUtils;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemsRepository itemRepository;
	
	public List<OrderDto> doGetOrderList() {
		// TODO Auto-generated method stub
		List<OrdersEntity> orderList=new ArrayList<OrdersEntity>();
		List<OrderDto> OrderDtoList=new ArrayList<>();
		try
		{
			orderList=orderRepository.doGetOrderList();
			System.out.println("OrderList Size :"+orderList.size());
			
			orderList.forEach(order->
			{
				OrderDto orderDto=new OrderDto();
				orderDto.setCustomerName(order.getCustomerName());
				orderDto.setOrderDate(order.getOrderDate());
				orderDto.setCounts(Integer.parseInt(order.getOrderItems()));
				orderDto.setTotal(order.getTotal());
				orderDto.setShippingAddress(order.getShippingAddress());
				orderDto.setProductName(order.getProductName());
				
				
				OrderDtoList.add(orderDto);
			});
			
		}catch(Exception e)
		{
			System.out.println("Error :"+e.getMessage());
		}
		
		return OrderDtoList;
	}

	public ResponseUtils saveOrder(OrderDto orderDto) {
		// TODO Auto-generated method stub
		ResponseUtils response=new ResponseUtils();
		try
		{
			OrdersEntity OrdersEntity=new OrdersEntity();
			OrdersEntity.setCustomerName(orderDto.getCustomerName());
			OrdersEntity.setOrderDate(orderDto.getOrderDate());
			OrdersEntity.setOrderItems(String.valueOf(orderDto.getCounts()));
			OrdersEntity.setShippingAddress(orderDto.getShippingAddress());
			OrdersEntity.setOrderItems(String.valueOf(orderDto.getCounts()));
			
			String productDetails=orderDto.getProductName();
			System.out.println("Product :"+productDetails);
			String product[]=productDetails.split(",");
			System.out.println("id :"+product[0]);
			System.out.println("name :"+product[1]);
			System.out.println("quantity :"+product[2]);
			System.out.println("Price :"+product[3]);
			int count=orderDto.getCounts();
			
			OrdersEntity.setTotal(String.valueOf(Double.parseDouble(product[3])*count));
			OrdersEntity.setProductName(product[1]);
			
			orderRepository.save(OrdersEntity);
			
			ProductEntity productEntiry=new ProductEntity();
			productEntiry.setProductId(Long.parseLong(product[0]));
			productEntiry.setProductName(product[1]);
			productEntiry.setQuantity(product[2]);
			productEntiry.setPrice(product[3]);
			
			ItemsEntity itemEntity=new ItemsEntity();
			itemEntity.setOrders(OrdersEntity);
			itemEntity.setProduct(productEntiry);
			
			itemRepository.save(itemEntity);
			response.setFlg(true);
			response.setMessage("Save Successfully");
			
			
		}catch(Exception e)
		{
			System.out.println("Error :"+e.getMessage());
			response.setFlg(false);
			response.setMessage(e.getMessage());
		}
		
		return response;
	}

}
