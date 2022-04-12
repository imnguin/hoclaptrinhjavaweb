package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.DTO.VideoDTO;
import com.laptrinhjavaweb.converter.VideoConverter;
import com.laptrinhjavaweb.entity.VideoEntity;
import com.laptrinhjavaweb.repository.VideoRepository;
import com.laptrinhjavaweb.service.IVideoService;
@Service
public class VideoService implements IVideoService {


	@Autowired
	private VideoRepository videoRepository;
	@Autowired
	private VideoConverter videoConverter;
	@Override
	public List<VideoDTO> findAll() {
		List<VideoDTO> models = new ArrayList<>();
		List<VideoEntity> entities = videoRepository.findAll();
		for (VideoEntity item : entities) {
			VideoDTO videoDTO = videoConverter.toDto(item);
			models.add(videoDTO);		 
		}
		return models;
	}
	@Override
	public VideoDTO findById(long id) {
		VideoEntity entity = videoRepository.findOne(id);
		return videoConverter.toDto(entity);
	}

	@Override		
	@Transactional
	public VideoDTO save(VideoDTO dto) {
		VideoEntity videoEntity = new VideoEntity();
		if (dto.getId() != null) {
			VideoEntity oldVideo = videoRepository.findOne(dto.getId());
			videoEntity = videoConverter.toEntity(oldVideo, dto);
		} else {
			videoEntity = videoConverter.toEntity(dto);
		}
		return videoConverter.toDto(videoRepository.save(videoEntity));
	}
	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			videoRepository.delete(id);
		}
	}
}
