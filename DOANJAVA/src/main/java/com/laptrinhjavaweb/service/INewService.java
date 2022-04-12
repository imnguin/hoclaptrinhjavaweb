package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.DTO.NewDTO;

public interface INewService {
	List<NewDTO> findAll();
	NewDTO findById(long id);
	
	NewDTO save(NewDTO dto);
	
	void delete(long[] ids);
}
