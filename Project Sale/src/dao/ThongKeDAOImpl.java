package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
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

	@Override
	public String getBestEmployee() {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sqlRefresh = "EXECUTE sp_refreshview 'best_empl'";
		String sql = "select ten_nhan_vien from best_empl where so_hoa_don like (select max(so_hoa_don) from best_empl where thang_ban like ? ) and thang_ban like ?";
		try {
			Statement stmt = cons.createStatement();
			stmt.execute(sqlRefresh);
			
			String localDate = LocalDate.now().toString().substring(0, 7);
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,localDate);
			ps.setString(2,localDate);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String name = rs.getNString(1);
			return name;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getBestCustomer() {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sqlRefresh = "EXECUTE sp_refreshview 'best_customer'";
		String sql = "select ho_ten from best_customer where so_hoa_don like (select max(so_hoa_don) from best_customer where thang_ban like ? ) and thang_ban like ?";
		try {
			Statement stmt = cons.createStatement();
			stmt.execute(sqlRefresh);
			
			String localDate = LocalDate.now().toString().substring(0, 7);
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,localDate);
			ps.setString(2,localDate);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String name = rs.getNString(1);
			return name;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getBestSeller() {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sqlRefresh = "EXECUTE sp_refreshview 'best_seller_item'";
		String sql = "select ten_mat_hang from best_seller_item where so_ban_duoc like (select max(so_ban_duoc) from best_seller_item);";
		try {
			Statement stmt = cons.createStatement();
			stmt.execute(sqlRefresh);
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String name = rs.getNString(1);
			return name;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getDoanhThu() {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sql = "select sum(thanh_tien) as doanh_thu,convert(varchar(7), ngay_ban, 120) as thang_mua from hoa_don where convert(varchar(7), ngay_ban, 120) like ? group by convert(varchar(7), ngay_ban, 120)";
		try {			
			String localDate = LocalDate.now().toString().substring(0, 7);
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,localDate);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int doanhThu = rs.getInt(1);
			return doanhThu;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
}
