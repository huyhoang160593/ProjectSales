package dao;

import java.util.List;

import model.MatHang;

public interface MatHangDAO {
	public List<MatHang> getList();
	
	public int createOrUpdate(MatHang matHang);
	
	public MatHang getMatHangInfo(String ten_mat_hang);
}
