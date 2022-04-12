package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.VideoEntity;

public interface VideoRepository extends JpaRepository<VideoEntity, Long>{

}