package service;

import java.util.List;

import bean.DoanhThuThangBean;
import bean.HoaDonBean;
import dao.ThongKeDAO;
import dao.ThongKeDAOImpl;

public class ThongKeServiceImpl implements ThongKeService{

	private ThongKeDAO thongKeDAO = null;
		
	public ThongKeServiceImpl() {
		this.thongKeDAO = new ThongKeDAOImpl();
	}

	@Override
	public List<HoaDonBean> getListByHoaDon() {
		// TODO Auto-generated method stub
		return thongKeDAO.getListByHoaDon();
	}

	@Override
	public List<DoanhThuThangBean> getListByDoanhThu() {
		// TODO Auto-generated method stub
		return thongKeDAO.getListByDoanhThu();
	}

	@Override
	public String getBestEmployee() {
		// TODO Auto-generated method stub
		return thongKeDAO.getBestEmployee();
	}

	@Override
	public String getBestCustomer() {
		// TODO Auto-generated method stub
		return thongKeDAO.getBestCustomer();
	}

	@Override
	public String getBestSeller() {
		// TODO Auto-generated method stub
		return thongKeDAO.getBestSeller();
	}

	@Override
	public int getDoanhThu() {
		// TODO Auto-generated method stub
		return thongKeDAO.getDoanhThu();
	}
}
