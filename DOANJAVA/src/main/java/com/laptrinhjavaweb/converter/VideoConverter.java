package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.DTO.VideoDTO;
import com.laptrinhjavaweb.entity.VideoEntity;

@Component
public class VideoConverter {
	
	public VideoDTO toDto(VideoEntity entity) {
		VideoDTO result = new VideoDTO();
		result.setId(entity.getId());
		result.setLienket(entity.getLienket());
		return result;
	}
	
	public VideoEntity toEntity(VideoDTO dto) {
		VideoEntity result = new VideoEntity();
		result.setLienket(dto.getLienket());
		return result;
	}
	public VideoEntity toEntity(VideoEntity result, VideoDTO dto) {
		result.setLienket(dto.getLienket());
		return result;
	}
}