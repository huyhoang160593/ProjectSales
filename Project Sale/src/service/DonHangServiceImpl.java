package service;

import java.util.List;

import dao.DonHangDAO;
import dao.DonHangDAOImpl;
import model.DonHang;

public class DonHangServiceImpl implements DonHangService {
	private DonHangDAO donHangDAO = null;
	
	
	public DonHangServiceImpl() {
		this.donHangDAO = new DonHangDAOImpl();
	}


	@Override
	public List<DonHang> getList() {
		// TODO Auto-generated method stub
		return donHangDAO.getList();
	}

}
