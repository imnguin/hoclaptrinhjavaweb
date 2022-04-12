package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhjavaweb.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

	
	@Query("SELECT p FROM ProductEntity p WHERE p.tensp LIKE %?1%")
    public List<ProductEntity> search(String keyword);
}
