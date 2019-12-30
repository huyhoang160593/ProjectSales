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

	@Override
	public KhachHang getKhachHangInfo(String ho_ten) {
		// TODO Auto-generated method stub
		return khachHangDAO.getKhachHangInfo(ho_ten);
	}

	@Override
	public KhachHang getKhachHangInfoBySDT(String sdt) {
		// TODO Auto-generated method stub
		return khachHangDAO.getKhachHangInfoBySDT(sdt);
	}

	@Override
	public KhachHang getKhachHangSDT(int ma_khach_hang) {
		// TODO Auto-generated method stub
		return khachHangDAO.getKhachHangSDT(ma_khach_hang);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return khachHangDAO.count();
	}

	@Override
	public int delete(int ma_khach_hang) {
		// TODO Auto-generated method stub
		return khachHangDAO.delete(ma_khach_hang);
	}

}
