package dao;

import model.KhachHang;
import java.util.List;
public interface KhachHangDAO {
	public List<KhachHang> getList();
	
	public int createOrUpdate(KhachHang khachHang);
}
