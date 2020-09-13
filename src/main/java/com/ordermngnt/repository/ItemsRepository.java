package com.ordermngnt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ordermngnt.entity.ItemsEntity;

@Transactional
@Repository
public interface ItemsRepository extends CrudRepository<ItemsEntity, Long> {

	@Query("from ItemsEntity i where i.itemId=:orderId")
	public ItemsEntity doGetItem(@Param("orderId") Long orderId);

}
