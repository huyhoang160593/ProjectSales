package service;

import java.util.List;
import dao.KhachHangDAO;
import dao.KhachHangDAOImpl;
import model.KhachHang;

public class KhachHangServiceImpl implements KhachHangService {
	
	private KhachHangDAO khachHangDAO = null;
	
	public KhachHangServiceImpl() {
		this.khachHangDAO = new KhachHangDAOImpl();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<KhachHang> getList() {
		return khachHangDAO.getList();
	}

	@Override
	public int createOrUpdate(KhachHang khachHang) {
		// TODO Auto-generated method stub		
		return khachHangDAO.createOrUpdate(khachHang);
	}

}
