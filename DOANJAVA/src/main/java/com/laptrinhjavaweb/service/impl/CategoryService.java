package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.DTO.CategoryDTO;
import com.laptrinhjavaweb.converter.CategoryConverter;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryConverter categoryConverter;
	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item: entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}
	@Override
	public List<CategoryDTO> Getlistcategory() {
		List<CategoryDTO> models = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item : entities) {
			CategoryDTO categoryDTO = categoryConverter.toDto(item);
			models.add(categoryDTO);		 
		}
		return models;
	}
	@Override
	public CategoryDTO findById(long id) {
		CategoryEntity entity = categoryRepository.findOne(id);
		return categoryConverter.toDto(entity);
	}

	@Override		
	@Transactional
	public CategoryDTO save(CategoryDTO dto) {
		CategoryEntity categoryEntity = new CategoryEntity();
		if (dto.getId() != null) {
			CategoryEntity oldCategory = categoryRepository.findOne(dto.getId());
			categoryEntity = categoryConverter.toEntity(oldCategory, dto);
		} else {
			categoryEntity = categoryConverter.toEntity(dto);
		}
		return categoryConverter.toDto(categoryRepository.save(categoryEntity));
	}

	@Override

	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			categoryRepository.delete(id);
		}
	}
}