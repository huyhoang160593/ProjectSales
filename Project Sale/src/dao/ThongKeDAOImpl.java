package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import bean.DoanhThuThangBean;
import bean.HoaDonBean;

public class ThongKeDAOImpl implements ThongKeDAO {

	@Override
	public List<HoaDonBean> getListByHoaDon() {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sql = "SELECT CONVERT(date,ngay_ban) as Ngay_mua, COUNT(*) as so_luong FROM hoa_don GROUP BY CONVERT(date,ngay_ban);";
		List<HoaDonBean> list = new ArrayList<HoaDonBean>();
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				HoaDonBean hoaDonBean = new HoaDonBean();
				hoaDonBean.setNgay_ban(rSet.getString("Ngay_mua"));
				hoaDonBean.setSo_luong_don_hang(rSet.getInt("so_luong"));
				list.add(hoaDonBean);
			}
			ps.close();
			cons.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DoanhThuThangBean> getListByDoanhThu() {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sql = "select convert(varchar(7), ngay_ban, 120) as thang_mua, sum(thanh_tien) as doanh_thu from hoa_don group by convert(varchar(7), ngay_ban, 120);";
		List<DoanhThuThangBean> list = new ArrayList<DoanhThuThangBean>();
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				DoanhThuThangBean doanhThuThangBean = new DoanhThuThangBean();
				doanhThuThangBean.setThang_ban(rSet.getString("thang_mua"));
				doanhThuThangBean.setDoanh_thu(rSet.getInt("doanh_thu"));
				list.add(doanhThuThangBean);
			}
			ps.close();
			cons.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
