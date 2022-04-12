package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.DTO.VideoDTO;

public interface IVideoService {
	List<VideoDTO> findAll();
	
	VideoDTO findById(long id);
	
	VideoDTO save(VideoDTO dto);
	
	void delete(long[] ids);
}
