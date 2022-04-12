package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.DTO.ProductDTO;
import com.laptrinhjavaweb.model.ProductModel;

public interface IProductService {
	List<ProductModel> spmoi();
	List<ProductDTO> findAll(String keyword);
	ProductDTO findById(long id);

	ProductDTO save(ProductDTO dto);

	void delete(long[] ids);

	List<ProductModel> spnoibat();

}
