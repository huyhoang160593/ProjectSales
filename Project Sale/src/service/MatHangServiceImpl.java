package service;

import java.util.List;

import dao.MatHangDAO;
import dao.MatHangDAOImpl;
import model.MatHang;

public class MatHangServiceImpl implements MatHangService {
	
	private MatHangDAO matHangDAO = null;
	
	public MatHangServiceImpl() {
		this.matHangDAO = new MatHangDAOImpl();
	}

	@Override
	public List<MatHang> getList() {
		// TODO Auto-generated method stub
		return matHangDAO.getList();
	}

	@Override
	public int createOrUpdate(MatHang matHang) {
		// TODO Auto-generated method stub		
		return matHangDAO.createOrUpdate(matHang);
	}

	@Override
	public MatHang getMatHangInfo(String ten_mat_hang) {
		// TODO Auto-generated method stub
		return matHangDAO.getMatHangInfo(ten_mat_hang);
	}
	
	

}
