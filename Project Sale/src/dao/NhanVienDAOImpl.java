package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;

public class NhanVienDAOImpl implements NhanVienDAO{

	@Override
	public List<NhanVien> getList() {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String SQL = "SELECT * FROM nhan_vien";
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			Statement stmt = cons.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMa_nhan_vien(rs.getInt("ma_nhan_vien"));
				nhanVien.setTen_nhan_vien(rs.getNString("ten_nhan_vien"));
				nhanVien.setGioi_tinh(rs.getBoolean("gioi_tinh"));
				nhanVien.setDia_chi(rs.getNString("dia_chi"));
				nhanVien.setSo_dien_thoai(rs.getString("sdt"));
				nhanVien.setNgay_sinh(rs.getDate("ngay_sinh"));
				nhanVien.setTinh_trang(rs.getBoolean("tinh_trang"));
				list.add(nhanVien);				
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public int createOrUpdate(NhanVien nhanVien) {
		// TODO Auto-generated method stub
		try {
			Connection cons = DBConnect.getConnection();
			String sql = "MERGE INTO nhan_vien AS t "
					+ "USING (SELECT ma_nhan_vien=?, ten_nhan_vien=?, gioi_tinh=?, dia_chi=?, sdt=?,ngay_sinh=?,tinh_trang=?) AS s "
					+ "ON t.ma_nhan_vien = s.ma_nhan_vien "
					+ "WHEN MATCHED THEN UPDATE SET ten_nhan_vien=s.ten_nhan_vien,gioi_tinh=s.gioi_tinh ,dia_chi=s.dia_chi ,sdt=s.sdt ,ngay_sinh=s.ngay_sinh, tinh_trang= s.tinh_trang "
					+ "WHEN NOT MATCHED THEN INSERT (ten_nhan_vien, gioi_tinh, dia_chi,  sdt, ngay_sinh, tinh_trang) VALUES (s.ten_nhan_vien, s.gioi_tinh, s.dia_chi,  s.sdt, s.ngay_sinh, s.tinh_trang);";
			PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, nhanVien.getMa_nhan_vien());
			ps.setNString(2, nhanVien.getTen_nhan_vien());
			ps.setBoolean(3, nhanVien.isGioi_tinh());
			ps.setNString(4, nhanVien.getDia_chi());
			ps.setString(5, nhanVien.getSo_dien_thoai());
			ps.setDate(6, nhanVien.getNgay_sinh());
			ps.setBoolean(7, nhanVien.isTinh_trang());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			int generatedKey = 0;
			if(rs.next()) {
				generatedKey = rs.getInt(1);
				if(generatedKey == 0) {
					generatedKey = nhanVien.getMa_nhan_vien();
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
	public NhanVien getNhanVienInfo(String ten_nhan_vien) {
		// TODO Auto-generated method stub
		NhanVien nhanVien = new NhanVien();
		try {
			Connection cons = DBConnect.getConnection();
			String sql = "SELECT ma_nhan_vien,ten_nhan_vien FROM nhan_vien WHERE ten_nhan_vien=?";
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setNString(1, ten_nhan_vien);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				nhanVien.setMa_nhan_vien(rs.getInt("ma_nhan_vien"));
				nhanVien.setTen_nhan_vien(rs.getNString("ten_nhan_vien"));
				return nhanVien;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
		
		
}
