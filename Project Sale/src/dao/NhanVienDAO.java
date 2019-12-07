package dao;

import java.util.List;
import model.NhanVien;

public interface NhanVienDAO {
	public List<NhanVien> getList();
	 
    public int createOrUpdate(NhanVien nhanVien);
}
