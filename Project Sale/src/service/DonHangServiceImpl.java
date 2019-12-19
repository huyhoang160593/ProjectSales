package service;

import java.util.List;

import dao.DonHangDAO;
import dao.DonHangDAOImpl;
import model.ChiTietHoaDon;
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


	@Override
	public int create(DonHang donHang) {
		// TODO Auto-generated method stub
		return donHangDAO.create(donHang);
	}


	@Override
	public void createDetailOrder(ChiTietHoaDon chiTietHoaDon) {
		// TODO Auto-generated method stub
		donHangDAO.createDetailOrder(chiTietHoaDon);
	}


	@Override
	public DonHang getOrderInfo(int ma_hoa_don) {
		// TODO Auto-generated method stub
		return donHangDAO.getOrderInfo(ma_hoa_don);
	}


	@Override
	public List<ChiTietHoaDon> getDetailOrderList(int ma_hoa_don) {
		// TODO Auto-generated method stub
		return donHangDAO.getDetailOrderList(ma_hoa_don);
	}


	@Override
	public int count() {
		// TODO Auto-generated method stub
		return donHangDAO.Count();
	}

}
