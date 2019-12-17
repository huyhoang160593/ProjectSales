package dao;

import java.util.List;

import model.DonHang;
import model.MatHang;

public interface DonHangDAO {
	public List<DonHang> getList();
	
	public int create(DonHang donHang);
	
}
