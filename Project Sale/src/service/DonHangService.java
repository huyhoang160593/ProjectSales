package service;

import java.util.List;

import model.ChiTietHoaDon;
import model.DonHang;

public interface DonHangService {
	
	public List<DonHang> getList();
	
	public int create(DonHang donHang);
	
	public void createDetailOrder(ChiTietHoaDon chiTietHoaDon);
}
