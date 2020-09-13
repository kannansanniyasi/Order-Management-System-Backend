package com.ordermngnt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class ItemsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="item_id")
	private Long itemId;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="product_id")
	private ProductEntity product;
	

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="order_id")
	private OrdersEntity orders;


	public Long getItemId() {
		return itemId;
	}


	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}


	public ProductEntity getProduct() {
		return product;
	}


	public void setProduct(ProductEntity product) {
		this.product = product;
	}


	public OrdersEntity getOrders() {
		return orders;
	}


	public void setOrders(OrdersEntity orders) {
		this.orders = orders;
	}




	
	
	
	
	

}
