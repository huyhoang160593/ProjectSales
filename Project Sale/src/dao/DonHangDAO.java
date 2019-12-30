package dao;

import java.util.List;

import model.ChiTietHoaDon;
import model.DonHang;

public interface DonHangDAO {	//Interface lưu giữ các phương thức có thể được tái sử dụng cho mục đích khác nhau
	public List<DonHang> getList();	//Lấy list đơn hàng từ csdl
	
	public int create(DonHang donHang);	//tạo đơn hàng mới	
	
	public void createDetailOrder(ChiTietHoaDon chiTietHoaDon);	//Tạo chi tiết đơn hàng mới
	
	public List<ChiTietHoaDon> getDetailOrderList(int ma_hoa_don);	//Lấy list các chi tiết hoá đơn theo một đơn hàng
	
	public DonHang getOrderInfo(int ma_hoa_don);	//Lấy thông tin đơn hàng
	
	public int Count();	//Đếm số đơn hàng
}
