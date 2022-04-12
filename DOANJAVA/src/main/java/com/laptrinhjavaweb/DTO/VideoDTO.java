package com.laptrinhjavaweb.DTO;

public class VideoDTO extends AbstractDTO<VideoDTO> {
	
	private String lienket;

	public String getLienket() {
		return lienket;
	}

	public void setLienket(String lienket) {
		this.lienket = lienket;
	}
}