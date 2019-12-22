package bean;

import java.util.List;

import model.ChiTietHoaDon;

public class HoaDonInfoBean {
	private String maHoaDon;
	private String ngayBan;
	private String thanhTien;
	private String nhanVien;
	private String tenKhachHang;
	private String sDT;
	private List<ChiTietHoaDon> listOrder;
	
	public List<ChiTietHoaDon> getListOrder() {
		return listOrder;
	}
	public void setListOrder(List<ChiTietHoaDon> listOrder) {
		this.listOrder = listOrder;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getNgayBan() {
		return ngayBan;
	}
	public void setNgayBan(String ngayBan) {
		this.ngayBan = ngayBan;
	}
	public String getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(String thanhTien) {
		this.thanhTien = thanhTien;
	}
	public String getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(String nhanVien) {
		this.nhanVien = nhanVien;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	
}
