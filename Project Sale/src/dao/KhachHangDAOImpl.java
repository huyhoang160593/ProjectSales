package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.KhachHang;

public class KhachHangDAOImpl implements KhachHangDAO{
	
	@Override
	public List<KhachHang> getList() {
		Connection cons = DBConnect.getConnection();
		String SQL = "SELECT * FROM khach_hang";
		List<KhachHang> list = new ArrayList<KhachHang>();
		try {
			Statement stmt = cons.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				KhachHang khachHang = new KhachHang();
				khachHang.setMa_khach_hang(rs.getInt("ma_khach_hang"));
				khachHang.setHo_ten(rs.getNString("ho_ten"));
				khachHang.setDia_chi(rs.getNString("dia_chi"));
				khachHang.setSo_dien_thoai(rs.getString("sdt"));
				list.add(khachHang);
			}
			stmt.close();
			cons.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public int createOrUpdate(KhachHang khachHang) {
		// TODO Auto-generated method stub
		try {
			Connection cons = DBConnect.getConnection();
			String sql = "MERGE INTO khach_hang AS t USING (SELECT ma_khach_hang=?, ho_ten=?, sdt=?, dia_chi=?) AS s ON t.ma_khach_hang = s.ma_khach_hang WHEN MATCHED THEN UPDATE SET ho_ten=s.ho_ten, sdt=s.sdt, dia_chi=s.dia_chi WHEN NOT MATCHED THEN INSERT (ho_ten, sdt, dia_chi) VALUES (s.ho_ten, s.sdt, s.dia_chi);";
			PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1,khachHang.getMa_khach_hang());
			ps.setNString(2, khachHang.getHo_ten());
			ps.setString(3, khachHang.getSo_dien_thoai());
			ps.setNString(4, khachHang.getDia_chi());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			int generatedKey = 0;
			if(rs.next()) {
				generatedKey = rs.getInt(1);
				if(generatedKey == 0) {
					generatedKey = khachHang.getMa_khach_hang();
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
	public KhachHang getKhachHangInfo(String ho_ten) {
		// TODO Auto-generated method stub
		try {
			KhachHang khachHang = new KhachHang();
			Connection cons = DBConnect.getConnection();
			String SQL = "SELECT * FROM khach_hang where ho_ten=?";
			PreparedStatement ps = cons.prepareStatement(SQL);
			ps.setNString(1, ho_ten);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				khachHang.setMa_khach_hang(rs.getInt("ma_khach_hang"));
				khachHang.setHo_ten(rs.getNString("ho_ten"));
				khachHang.setSo_dien_thoai(rs.getString("sdt"));
				khachHang.setDia_chi(rs.getNString("dia_chi"));
				return khachHang;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public KhachHang getKhachHangInfoBySDT(String sdt) {
		// TODO Auto-generated method stub
		try {
			KhachHang khachHang = new KhachHang();
			Connection cons = DBConnect.getConnection();
			String SQL = "SELECT * FROM khach_hang where sdt=?";
			PreparedStatement ps = cons.prepareStatement(SQL);
			ps.setString(1, sdt);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				khachHang.setMa_khach_hang(rs.getInt("ma_khach_hang"));
				khachHang.setHo_ten(rs.getNString("ho_ten"));
				khachHang.setSo_dien_thoai(rs.getString("sdt"));
				khachHang.setDia_chi(rs.getNString("dia_chi"));
				return khachHang;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public KhachHang getKhachHangSDT(int ma_khach_hang) {
		// TODO Auto-generated method stub
		try {
			KhachHang khachHang = new KhachHang();
			Connection cons = DBConnect.getConnection();
			String SQL = "SELECT * FROM khach_hang where ma_khach_hang=?";
			PreparedStatement ps = cons.prepareStatement(SQL);
			ps.setInt(1, ma_khach_hang);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				khachHang.setMa_khach_hang(rs.getInt("ma_khach_hang"));
				khachHang.setSo_dien_thoai(rs.getString("sdt"));
				return khachHang;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		try {
			Connection cons = DBConnect.getConnection();
			String sql = "SELECT count(ma_khach_hang) AS dem FROM khach_hang";
			Statement stmt = cons.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				int count = rs.getInt("dem");
				return count;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int ma_khach_hang) {
		// TODO Auto-generated method stub
		try {
			Connection cons = DBConnect.getConnection();
			String sql = "DELETE FROM khach_hang WHERE ma_khach_hang=?;";
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setInt(1, ma_khach_hang);
			return ps.executeUpdate();	
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Khách hàng hiện tại đã có đơn hàng nên không thể xoá", "Lỗi xoá khách hàng", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	return 0;
	}

}
