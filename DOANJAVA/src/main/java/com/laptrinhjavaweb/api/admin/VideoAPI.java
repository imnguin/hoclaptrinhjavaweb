package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.DTO.VideoDTO;
import com.laptrinhjavaweb.service.IVideoService;

@RestController(value = "videoAPIOfAdmin")
public class VideoAPI {

	@Autowired
	private IVideoService videoService;

	@PostMapping("/api/video")
	public VideoDTO createVideo(@RequestBody VideoDTO videoDTO) {
		return videoService.save(videoDTO);

	}

	@PutMapping("/api/video")
	public VideoDTO updateVideo(@RequestBody VideoDTO updateVideo) {
		return videoService.save(updateVideo);
	}

	@DeleteMapping("/api/video")
	public void deleteVideo(@RequestBody long[] ids) {
		videoService.delete(ids);
	}
}