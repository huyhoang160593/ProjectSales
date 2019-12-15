package model;

import java.util.Date;

public class DonHang {
	private int ma_hoa_don;
	private int ma_nhan_vien;
	private Date ngay_ban;
	private int ma_khach_hang;
	private int thanh_tien;
	private String ten_nhan_vien;
	private String ten_khach_hang;
	
	public int getMa_hoa_don() {
		return ma_hoa_don;
	}
	public void setMa_hoa_don(int ma_hoa_don) {
		this.ma_hoa_don = ma_hoa_don;
	}
	public int getMa_nhan_vien() {
		return ma_nhan_vien;
	}
	public void setMa_nhan_vien(int ma_nhan_vien) {
		this.ma_nhan_vien = ma_nhan_vien;
	}
	public Date getNgay_ban() {
		return ngay_ban;
	}
	public void setNgay_ban(Date ngay_ban) {
		this.ngay_ban = ngay_ban;
	}
	public int getMa_khach_hang() {
		return ma_khach_hang;
	}
	public void setMa_khach_hang(int ma_khach_hang) {
		this.ma_khach_hang = ma_khach_hang;
	}
	public int getThanh_tien() {
		return thanh_tien;
	}
	public void setThanh_tien(int thanh_tien) {
		this.thanh_tien = thanh_tien;
	}
	public String getTen_nhan_vien() {
		return ten_nhan_vien;
	}
	public void setTen_nhan_vien(String ten_nhan_vien) {
		this.ten_nhan_vien = ten_nhan_vien;
	}
	public String getTen_khach_hang() {
		return ten_khach_hang;
	}
	public void setTen_khach_hang(String ten_khach_hang) {
		this.ten_khach_hang = ten_khach_hang;
	}
	
	
			
}
