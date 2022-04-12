package com.laptrinhjavaweb.DTO;

public class NewDTO extends AbstractDTO<NewDTO> {
	
	private String tieude;
	private String mota;
	public String getTieude() {
		return tieude;
	}
	public void setTieude(String tieude) {
		this.tieude = tieude;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	
}
