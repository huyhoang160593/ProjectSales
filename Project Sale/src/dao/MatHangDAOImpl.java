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
				matHang.setLoai_hang(rs.getNString("loai_hang"));
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
		try {
			Connection cons = DBConnect.getConnection();
			String sql = "MERGE INTO mat_hang AS t USING (SELECT ma_mat_hang=?, ten_mat_hang=?, loai_hang=?, don_gia=?, ton_kho=?,co_san=?,thoi_gian_nhap=?) AS s ON t.ma_mat_hang = s.ma_mat_hang WHEN MATCHED THEN UPDATE SET ten_mat_hang=s.ten_mat_hang,loai_hang=s.loai_hang ,don_gia=s.don_gia ,ton_kho=s.ton_kho, co_san= s.co_san, thoi_gian_nhap = s.thoi_gian_nhap WHEN NOT MATCHED THEN INSERT (ten_mat_hang, loai_hang, don_gia, ton_kho, co_san, thoi_gian_nhap) VALUES (s.ten_mat_hang, s.loai_hang, s.don_gia, s.ton_kho, s.co_san, s.thoi_gian_nhap);";
			PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, matHang.getMa_mat_hang());
			ps.setNString(2, matHang.getTen_mat_hang());
			ps.setNString(3, matHang.getLoai_hang());
			ps.setInt(4, matHang.getDon_gia());
			ps.setInt(5, matHang.getTon_kho());
			ps.setBoolean(6, matHang.isCo_san());

			String thoi_gian_nhap = matHang.getThoi_gian_nhap().toString();
			thoi_gian_nhap = thoi_gian_nhap.replace('T', ' ');
			ps.setString(7, thoi_gian_nhap);
			
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			int generatedKey = 0;
			if(rs.next()) {
				generatedKey = rs.getInt(1);
				if(generatedKey == 0) {
					generatedKey = matHang.getMa_mat_hang();
				}
			}
			ps.close();
			cons.close();
			return generatedKey;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return 0;
	}

	@Override
	public MatHang getMatHangInfo(String ten_mat_hang) {
		// TODO Auto-generated method stub
		try {
			MatHang matHang = new MatHang();
			Connection cons = DBConnect.getConnection();
			String sql = "SELECT * FROM mat_hang WHERE ten_mat_hang=?";
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setNString(1, ten_mat_hang);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				matHang.setMa_mat_hang(rs.getInt("ma_mat_hang"));
				matHang.setDon_gia(rs.getInt("don_gia"));
				matHang.setLoai_hang(rs.getNString("loai_hang"));
				matHang.setTon_kho(rs.getInt("ton_kho"));
			}
			return matHang;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
