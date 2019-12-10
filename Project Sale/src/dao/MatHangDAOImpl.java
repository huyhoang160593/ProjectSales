package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.MatHang;

public class MatHangDAOImpl implements MatHangDAO {

	@Override
	public List<MatHang> getList() {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sql = "SELECT * FROM mat_hang";
		List<MatHang> list = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MatHang matHang = new MatHang();
				matHang.setMa_mat_hang(rs.getInt("ma_mat_hang"));
				matHang.setTen_mat_hang(rs.getNString("ten_mat_hang"));
				matHang.setDon_gia(rs.getInt("don_gia"));
				matHang.setTon_kho(rs.getInt("ton_kho"));
				matHang.setCo_san(rs.getBoolean("co_san"));
				matHang.setThoi_gian_nhap(rs.getTimestamp("thoi_gian_nhap").toLocalDateTime());
				list.add(matHang);
			}
			ps.close();
			cons.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int createOrUpdate(MatHang matHang) {
		// TODO Auto-generated method stub
		return 0;
	}

}
