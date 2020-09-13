package com.ordermngnt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class OrdersEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="order_id")
	private Long orderId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="order_date")
	private String orderDate;
	
	@Column(name="shipping_address")
	private String shippingAddress;
	
	@Column(name="product_name")
	private String productName;
	
	
	@Column(name="order_items")
	private String orderItems;
	
	@Column(name="total")
	private String total;
	
	
	@OneToMany(mappedBy="orders",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<ItemsEntity> itemsEntity;


	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(String orderItems) {
		this.orderItems = orderItems;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<ItemsEntity> getItemsEntity() {
		return itemsEntity;
	}

	public void setItemsEntity(List<ItemsEntity> itemsEntity) {
		this.itemsEntity = itemsEntity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
	
	

}
