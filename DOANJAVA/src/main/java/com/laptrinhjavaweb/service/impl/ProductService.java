package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.DTO.ProductDTO;
import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dao.IProductDAO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductDAO productDAO;

	@Override
	public List<ProductModel> spmoi() {
		return productDAO.spmoi();
	}

	@Override
	public List<ProductModel> spnoibat() {
		return productDAO.spnoibat();
	}

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductConverter productConverter;

	@Override
	public List<ProductDTO> findAll(String keyword) {
	List<ProductDTO> models = new ArrayList<>();
		if(keyword!=null)
		{
			List<ProductEntity> entities = productRepository.search(keyword);
			for (ProductEntity item : entities) {
				ProductDTO productDTO = productConverter.toDto(item);
				models.add(productDTO);
			}
			return models;
		}
		else
		{
			List<ProductEntity> entities = productRepository.findAll();
			for (ProductEntity item : entities) {
				ProductDTO productDTO = productConverter.toDto(item);
				models.add(productDTO);
			}
			return models;
		}
	}

	@Override
	public ProductDTO findById(long id) {
		ProductEntity entity = productRepository.findOne(id);
		return productConverter.toDto(entity);
	}

	@Override		
	@Transactional
	public ProductDTO save(ProductDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		ProductEntity productEntity = new ProductEntity();
		if (dto.getId() != null) {
			ProductEntity oldProduct = productRepository.findOne(dto.getId());
			oldProduct.setCategory(category);
			productEntity = productConverter.toEntity(oldProduct, dto);
		} else {
			productEntity = productConverter.toEntity(dto);
			productEntity.setCategory(category);
		}
		return productConverter.toDto(productRepository.save(productEntity));
	}

	@Override

	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			productRepository.delete(id);
		}
	}
}
