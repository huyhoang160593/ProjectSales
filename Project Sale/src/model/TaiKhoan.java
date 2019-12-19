package model;

public class TaiKhoan {
	private int ma_tai_khoan;
	private String tai_khoan;
	private String mat_khau;
	private boolean tinh_trang;
	
	public int getMa_tai_khoan() {
		return ma_tai_khoan;
	}
	public void setMa_tai_khoan(int ma_tai_khoan) {
		this.ma_tai_khoan = ma_tai_khoan;
	}
	public String getTai_khoan() {
		return tai_khoan;
	}
	public void setTai_khoan(String tai_khoan) {
		this.tai_khoan = tai_khoan;
	}
	public String getMat_khau() {
		return mat_khau;
	}
	public void setMat_khau(String mat_khau) {
		this.mat_khau = mat_khau;
	}
	public boolean isTinh_trang() {
		return tinh_trang;
	}
	public void setTinh_trang(boolean tinh_trang) {
		this.tinh_trang = tinh_trang;
	}
	
	
}
