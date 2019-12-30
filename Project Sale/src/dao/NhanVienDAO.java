package dao;

import java.util.List;
import model.NhanVien;

public interface NhanVienDAO {
	public List<NhanVien> getList();
	 
    public int createOrUpdate(NhanVien nhanVien);
    
    public NhanVien getNhanVienInfo(String ten_nhan_vien);
    
    public int delete(int ma_nhan_vien);
}
