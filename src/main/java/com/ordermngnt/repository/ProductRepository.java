package com.ordermngnt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ordermngnt.entity.ProductEntity;

@Transactional
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

	@Query("from ProductEntity")
	public List<ProductEntity> doGetProductList();

}
