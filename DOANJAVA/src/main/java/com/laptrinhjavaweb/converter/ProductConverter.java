
package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.DTO.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;

@Component
public class ProductConverter {

	public ProductDTO toDto(ProductEntity entity) {
		ProductDTO result = new ProductDTO();
		result.setId(entity.getId());
		result.setTensp(entity.getTensp());
		result.setHinhanh(entity.getHinhanh());
		result.setMota(entity.getMota());
		result.setNhom(entity.getNhom());
		result.setCategoryCode(entity.getCategory().getCode());
		return result;
	}

	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity result = new ProductEntity();
		result.setTensp(dto.getTensp());
		result.setHinhanh(dto.getHinhanh());
		result.setMota(dto.getMota());
		result.setNhom(dto.getNhom());
		return result;
	}

	public ProductEntity toEntity(ProductEntity result, ProductDTO dto) {
		result.setTensp(dto.getTensp());
		result.setHinhanh(dto.getHinhanh());
		result.setMota(dto.getMota());
		result.setNhom(dto.getNhom());
		return result;
	}

}
