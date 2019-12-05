package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
				khachHang.setDia_chỉ(rs.getNString("dia_chi"));
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
			ps.setNString(4, khachHang.getDia_chỉ());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			int generatedKey = 0;
			if(rs.next()) {
				generatedKey = rs.getInt(1);
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

}
