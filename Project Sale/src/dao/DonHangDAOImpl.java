package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DonHang;

public class DonHangDAOImpl implements DonHangDAO {

	@Override
	public List<DonHang> getList() {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String SQL = "select hd.ma_hoa_don,hd.ma_nhan_vien,ngay_ban,hd.ma_khach_hang,thanh_tien,nv.ten_nhan_vien,kh.ho_ten from hoa_don hd,nhan_vien nv,khach_hang kh where kh.ma_khach_hang = hd.ma_khach_hang and nv.ma_nhan_vien = hd.ma_nhan_vien";
		List<DonHang> list = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DonHang donHang = new DonHang();
				donHang.setMa_hoa_don(rs.getInt("ma_hoa_don"));
				donHang.setMa_khach_hang(rs.getInt("ma_khach_hang"));
				donHang.setNgay_ban(rs.getDate("ngay_ban"));
				donHang.setMa_nhan_vien(rs.getInt("ma_nhan_vien"));
				donHang.setThanh_tien(rs.getInt("thanh_tien"));
				donHang.setTen_khach_hang(rs.getNString("ho_ten"));
				donHang.setTen_nhan_vien(rs.getNString("ten_nhan_vien"));
				list.add(donHang);
			}
			ps.close();
			cons.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}
