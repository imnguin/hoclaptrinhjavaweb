package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.DTO.NewDTO;
import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService {
	@Autowired
	private NewRepository newRepository;
	@Autowired
	private NewConverter newConverter;
	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll();
		for (NewEntity item : entities) {
			NewDTO newDTO = newConverter.toDto(item);
			models.add(newDTO);		 
		}
		return models;
	}
	@Override
	public NewDTO findById(long id) {
		NewEntity entity = newRepository.findOne(id);
		return newConverter.toDto(entity);
	}

	@Override		
	@Transactional
	public NewDTO save(NewDTO dto) {
		NewEntity newEntity = new NewEntity();
		if (dto.getId() != null) {
			NewEntity oldNew = newRepository.findOne(dto.getId());
			newEntity = newConverter.toEntity(oldNew, dto);
		} else {
			newEntity = newConverter.toEntity(dto);
		}
		return newConverter.toDto(newRepository.save(newEntity));
	}

	@Override

	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			newRepository.delete(id);
		}
	}
}