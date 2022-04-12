package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.ProductModel;

public interface IProductDAO extends GenericDAO<ProductModel> {
	List<ProductModel> spmoi();
	List<ProductModel> spnoibat();
	//List<ProductModel> search(String name);
}
