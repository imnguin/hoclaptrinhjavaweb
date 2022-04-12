package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.ProductModel;

public class ProductMapper implements RowMapper<ProductModel> {

	@Override
	public ProductModel mapRow(ResultSet resultSet) {
		try {
			ProductModel products = new ProductModel();

			products.setId(resultSet.getLong("id"));

			products.setTensp(resultSet.getString("tensp"));

			products.setMota(resultSet.getString("mota"));

			products.setHinhanh(resultSet.getString("hinhanh"));

			products.setCategory_id(resultSet.getLong("category_id"));

			products.setNhom(resultSet.getString("nhom"));
			
			return products;

		} catch (SQLException e) {
			return null;
		}
	}
}
