package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MatHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ma_mat_hang;
	private String ten_mat_hang;
	private int don_gia;
	private int ton_kho;
	private boolean co_san;
	private LocalDateTime thoi_gian_nhap;
	
	public int getMa_mat_hang() {
		return ma_mat_hang;
	}
	public void setMa_mat_hang(int ma_mat_hang) {
		this.ma_mat_hang = ma_mat_hang;
	}
	public String getTen_mat_hang() {
		return ten_mat_hang;
	}
	public void setTen_mat_hang(String ten_mat_hang) {
		this.ten_mat_hang = ten_mat_hang;
	}
	public int getDon_gia() {
		return don_gia;
	}
	public void setDon_gia(int don_gia) {
		this.don_gia = don_gia;
	}
	public int getTon_kho() {
		return ton_kho;
	}
	public void setTon_kho(int ton_kho) {
		this.ton_kho = ton_kho;
	}
	public boolean isCo_san() {
		return co_san;
	}
	public void setCo_san(boolean co_san) {
		this.co_san = co_san;
	}
	public LocalDateTime getThoi_gian_nhap() {
		return thoi_gian_nhap;
	}
	public void setThoi_gian_nhap(LocalDateTime thoi_gian_nhap) {
		this.thoi_gian_nhap = thoi_gian_nhap;
	}
	
	
}
