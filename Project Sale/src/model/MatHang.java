package model;

import java.io.Serializable;

public class MatHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ma_mat_hang;
	private String ten_mat_hang;
	private int don_gia;
	private int ton_kho;
	
	public String getMa_mat_hang() {
		return ma_mat_hang;
	}
	public void setMa_mat_hang(String ma_mat_hang) {
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
	
	
}
