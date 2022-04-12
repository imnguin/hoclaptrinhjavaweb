package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.DTO.CategoryDTO;

public interface ICategoryService {
	Map<String, String> findAll();
	
	CategoryDTO findById(long id);
	
	CategoryDTO save(CategoryDTO dto);
	
	List<CategoryDTO> Getlistcategory();
	void delete(long[] ids);
}
