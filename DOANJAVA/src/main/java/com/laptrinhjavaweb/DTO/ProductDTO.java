package com.laptrinhjavaweb.DTO;

/*DTO =model khi dung model khong biet model la dto hay entity*/
/*DTO tranfer data giua API-client hoac controller-view
entity mapping tables o database*/
public class ProductDTO extends AbstractDTO<ProductDTO> {
	private String tensp;
	private String mota;
	private String hinhanh;
	private Long category_id;
	
	private String categoryCode;
	private String nhom;
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getNhom() {
		return nhom;
	}
	public void setNhom(String nhom) {
		this.nhom = nhom;
	}
	
}
