package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.DTO.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

@Component
public class NewConverter {
	
	public NewDTO toDto(NewEntity entity) {
		NewDTO result = new NewDTO();
		result.setId(entity.getId());
		result.setTieude(entity.getTieude());
		result.setMota(entity.getMota());
		return result;
	}
	
	public NewEntity toEntity(NewDTO dto) {
		NewEntity result = new NewEntity();
		result.setTieude(dto.getTieude());
		result.setMota(dto.getMota());
		return result;
	}
	public NewEntity toEntity(NewEntity result, NewDTO dto) {
		result.setTieude(dto.getTieude());
		result.setMota(dto.getMota());
		return result;
	}
}
