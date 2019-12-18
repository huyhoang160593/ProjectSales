package service;

import java.util.List;
import dao.NhanVienDAO;
import dao.NhanVienDAOImpl;
import model.NhanVien;

public class NhanVienServiceImpl implements NhanVienService {
	
	private NhanVienDAO nhanVienDAO= null;

	public NhanVienServiceImpl() {
		this.nhanVienDAO = new NhanVienDAOImpl();
	}

	@Override
	public List<NhanVien> getList() {
		// TODO Auto-generated method stub
		return nhanVienDAO.getList();
	}

	@Override
	public int createOrUpdate(NhanVien nhanVien) {
		// TODO Auto-generated method stub
		return nhanVienDAO.createOrUpdate(nhanVien);
	}

	@Override
	public NhanVien getNhanVienInfo(String ten_nhan_vien) {
		// TODO Auto-generated method stub
		return nhanVienDAO.getNhanVienInfo(ten_nhan_vien);
	}
	
}
