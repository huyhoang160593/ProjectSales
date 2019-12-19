package service;

import java.util.List;

import model.ChiTietHoaDon;
import model.DonHang;

public interface DonHangService {
	
	public List<DonHang> getList();
	
	public int create(DonHang donHang);
	
	public void createDetailOrder(ChiTietHoaDon chiTietHoaDon);
	
	public List<ChiTietHoaDon> getDetailOrderList(int ma_hoa_don);
	
	public DonHang getOrderInfo(int ma_hoa_don);
	
	public int count();
}
