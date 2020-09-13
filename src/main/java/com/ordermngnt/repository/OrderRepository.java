package com.ordermngnt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ordermngnt.entity.OrdersEntity;

@Transactional
@Repository
public interface OrderRepository extends CrudRepository<OrdersEntity, Long> {

	@Query("from OrdersEntity")
	public List<OrdersEntity> doGetOrderList();

}
