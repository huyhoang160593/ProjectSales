package service;

import dao.TaiKhoanDAO;
import dao.TaiKhoanDAOImpl;
import model.TaiKhoan;

public class TaiKhoanServiceImpl implements TaiKhoanService {
	
	private TaiKhoanDAO  taiKhoanDAO = null;
	
	
	public TaiKhoanServiceImpl() {
		this.taiKhoanDAO = new TaiKhoanDAOImpl();
	}


	@Override
	public TaiKhoan login(String tenDangNhap, String matKhau) {
		// TODO Auto-generated method stub
		return taiKhoanDAO.login(tenDangNhap, matKhau);
	}
}
