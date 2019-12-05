package service;
import model.KhachHang;
import java.util.List;
public interface KhachHangService {
	
	public List<KhachHang> getList();
	
	public int createOrUpdate(KhachHang khachHang);
}
