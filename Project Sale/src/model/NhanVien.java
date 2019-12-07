package model;

import java.io.Serializable;
import java.sql.Date;
public class NhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ma_nhan_vien;
	private String ten_nhan_vien;
	private boolean gioi_tinh;
	private String dia_chi;
	private String so_dien_thoai;
	private Date ngay_sinh;
	private boolean tinh_trang;
	
	public int getMa_nhan_vien() {
		return ma_nhan_vien;
	}
	public void setMa_nhan_vien(int ma_nhan_vien) {
		this.ma_nhan_vien = ma_nhan_vien;
	}
	public String getTen_nhan_vien() {
		return ten_nhan_vien;
	}
	public void setTen_nhan_vien(String ten_nhan_vien) {
		this.ten_nhan_vien = ten_nhan_vien;
	}
	public boolean isGioi_tinh() {
		return gioi_tinh;
	}
	public void setGioi_tinh(boolean gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}
	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}
	public Date getNgay_sinh() {
		return ngay_sinh;
	}
	public void setNgay_sinh(Date ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}
	public boolean isTinh_trang() {
		return tinh_trang;
	}
	public void setTinh_trang(boolean tinh_trang) {
		this.tinh_trang = tinh_trang;
	}
	
	
}
