package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.dao.IProductDAO;
import com.laptrinhjavaweb.mapper.ProductMapper;
import com.laptrinhjavaweb.model.ProductModel;
@Repository
public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {
	
	@Override
	public List<ProductModel> spmoi() {
		StringBuilder sql = new StringBuilder("SELECT * FROM product where nhom = N'mới'");
		return query(sql.toString(), new ProductMapper());
	}
	@Override
	public List<ProductModel> spnoibat() {
		StringBuilder sql = new StringBuilder("SELECT * FROM product where nhom = N'nổi bật'");
		return query(sql.toString(), new ProductMapper());
	}
	
	/*
	 * @Override public List<ProductModel> search() { StringBuilder sql = new
	 * StringBuilder("SELECT * FROM product where tensp like % "); return
	 * query(sql.toString(), new ProductMapper()); }
	 */

}
