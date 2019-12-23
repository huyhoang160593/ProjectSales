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

	public static void main(String[] args) {
		ThongKeService thongKeService = new ThongKeServiceImpl();
		List<DoanhThuThangBean> list = thongKeService.getListByDoanhThu();
		
		boolean isnull = list.isEmpty();
		System.out.println(isnull);
	}
}
