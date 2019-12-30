package dao;

import model.KhachHang;
import java.util.List;
public interface KhachHangDAO {
	public List<KhachHang> getList();
	
	public int createOrUpdate(KhachHang khachHang);
	
	public KhachHang getKhachHangInfo(String ho_ten);
	
	public KhachHang getKhachHangInfoBySDT(String sdt);
	
	public KhachHang getKhachHangSDT(int ma_khach_hang);
	
	public int count();
	
	public int delete(int ma_khach_hang);
}
