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
@Table(name="product")
public class ProductEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="product_id")
	private Long productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="quantity")
	private String quantity;
	
	
	@Column(name="price")
	private String price;

	@OneToMany(mappedBy="product",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<ItemsEntity> itemsEntity;


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public List<ItemsEntity> getItemsEntity() {
		return itemsEntity;
	}


	public void setItemsEntity(List<ItemsEntity> itemsEntity) {
		this.itemsEntity = itemsEntity;
	}
	
	
	
	
	
	

}
