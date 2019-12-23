package dao;

import java.util.List;

import bean.DoanhThuThangBean;
import bean.HoaDonBean;

public interface ThongKeDAO {
	
	public List<HoaDonBean> getListByHoaDon();
	
	public List<DoanhThuThangBean> getListByDoanhThu();
	
	
}
