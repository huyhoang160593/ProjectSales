package dao;

import java.util.List;

import model.MatHang;

public interface MatHangDAO {
	public List<MatHang> getList();
	
	public int createOrUpdate(MatHang matHang);
	
	public MatHang getMatHangInfo(String ten_mat_hang);
	
	public MatHang getMatHangInfoByMaMatHang(int ma_mat_hang);
	
	public int count();
	
	public int delete(int ma_mat_hang);
}
