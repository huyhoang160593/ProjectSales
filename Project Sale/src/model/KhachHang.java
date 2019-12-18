package model;

import java.io.Serializable;

public class KhachHang implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ma_khach_hang;
	private String ho_ten;
	private String so_dien_thoai;
	private String dia_chi;
	
	public int getMa_khach_hang() {
		return ma_khach_hang;
	}
	public void setMa_khach_hang(int ma_khach_hang) {
		this.ma_khach_hang = ma_khach_hang;
	}
	public String getHo_ten() {
		return ho_ten;
	}
	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}
	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}
	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chỉ) {
		this.dia_chi = dia_chỉ;
	}
	
	
	
	
}
