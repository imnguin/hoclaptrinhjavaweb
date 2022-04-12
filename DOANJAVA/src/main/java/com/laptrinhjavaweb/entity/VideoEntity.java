package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class VideoEntity extends BaseEntity {
	@Column(name = "lienket")
	private String lienket;

	public String getLienket() {
		return lienket;
	}

	public void setLienket(String lienket) {
		this.lienket = lienket;
	}
	
}
