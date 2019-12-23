package service;

import java.util.List;

import bean.DoanhThuThangBean;
import bean.HoaDonBean;

public interface ThongKeService {
	
	public List<HoaDonBean> getListByHoaDon();
	
	public List<DoanhThuThangBean> getListByDoanhThu();
}
