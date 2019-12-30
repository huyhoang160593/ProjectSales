package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ChiTietHoaDon;
import model.DonHang;

public class DonHangDAOImpl implements DonHangDAO {		//Đây là class kế thừa, là nơi các phương thức được trình bày rõ ràng, dễ kiểm soát
														//
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
				donHang.setNgay_ban(rs.getTimestamp("ngay_ban").toLocalDateTime());	//Lấy thời gian có đủ ngày và giờ, chuyển nó về dạng thuộc tính LocalDateTime đang để(một dạng tương tự datetime)
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

	@Override
	public int create(DonHang donHang) {
		// TODO Auto-generated method stub
		try {
			Connection cons = DBConnect.getConnection();
			String sql = "MERGE INTO hoa_don AS t USING (SELECT ma_hoa_don=?, ma_nhan_vien=?, ngay_ban=?, ma_khach_hang=?, thanh_tien=?) AS s ON t.ma_hoa_don = s.ma_hoa_don WHEN MATCHED THEN UPDATE SET ma_nhan_vien=s.ma_nhan_vien,ngay_ban=s.ngay_ban ,ma_khach_hang=s.ma_khach_hang ,thanh_tien=s.thanh_tien WHEN NOT MATCHED THEN INSERT (ma_nhan_vien, ngay_ban, ma_khach_hang, thanh_tien) VALUES (s.ma_nhan_vien, s.ngay_ban, s.ma_khach_hang, s.thanh_tien);";
			PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, donHang.getMa_hoa_don());
			ps.setInt(2, donHang.getMa_nhan_vien());
			
			String thoi_gian_nhap = donHang.getNgay_ban().toString();
			thoi_gian_nhap = thoi_gian_nhap.replace('T', ' ');
			ps.setString(3, thoi_gian_nhap);
			
			ps.setInt(4, donHang.getMa_khach_hang());
			ps.setInt(5, donHang.getThanh_tien());
			
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			int generatedKey = 0;
			if(rs.next()) {
				generatedKey = rs.getInt(1);
				if(generatedKey == 0) {
					generatedKey = donHang.getMa_hoa_don();
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
	public void createDetailOrder(ChiTietHoaDon chiTietHoaDon) {
		try {
			Connection cons = DBConnect.getConnection();
			String sqlString = "INSERT INTO chi_tiet_hoa_don(ma_hoa_don,ma_mat_hang,so_luong,don_gia,thanh_tien) VALUES (?,?,?,?,?)";
			PreparedStatement ps = cons.prepareStatement(sqlString);
			ps.setInt(1, chiTietHoaDon.getMa_hoa_don());
			ps.setInt(2, chiTietHoaDon.getMa_mat_hang());
			ps.setInt(3, chiTietHoaDon.getSo_luong());
			ps.setInt(4, chiTietHoaDon.getDon_gia());
			ps.setInt(5, chiTietHoaDon.getThanh_tien());
			ps.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	@Override
	public DonHang getOrderInfo(int ma_hoa_don) {
		// TODO Auto-generated method stub
		try {
			DonHang donHang = new DonHang();
			String SQL = "SELECT * from hoa_don where ma_hoa_don=?";
			Connection cons = DBConnect.getConnection();
			PreparedStatement ps = cons.prepareStatement(SQL);
			ps.setInt(1, ma_hoa_don);
			ResultSet rSet = ps.executeQuery();
			if(rSet.next()) {
				donHang.setMa_hoa_don(rSet.getInt("ma_hoa_don"));
				donHang.setMa_khach_hang(rSet.getInt("ma_khach_hang"));
				donHang.setNgay_ban(rSet.getTimestamp("ngay_ban").toLocalDateTime());
				donHang.setThanh_tien(rSet.getInt("thanh_tien"));
			}
			return donHang;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ChiTietHoaDon> getDetailOrderList(int ma_hoa_don) {
		// TODO Auto-generated method stub
			try {
				List<ChiTietHoaDon> listOrder =new ArrayList<ChiTietHoaDon>();
				String sqlString = "select hd.ma_hoa_don,ten_mat_hang, mh.don_gia, cthd.so_luong, cthd.thanh_tien from chi_tiet_hoa_don cthd, mat_hang mh, hoa_don hd where mh.ma_mat_hang = cthd.ma_mat_hang and hd.ma_hoa_don = cthd.ma_hoa_don and hd.ma_hoa_don = ?";
				Connection cons = DBConnect.getConnection();
				PreparedStatement ps = cons.prepareStatement(sqlString);
				ps.setInt(1, ma_hoa_don);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
					chiTietHoaDon.setMa_hoa_don(ma_hoa_don);
					chiTietHoaDon.setTen_mat_hang(rs.getNString("ten_mat_hang"));
					chiTietHoaDon.setDon_gia(rs.getInt("don_gia"));
					chiTietHoaDon.setSo_luong(rs.getInt("so_luong"));
					chiTietHoaDon.setThanh_tien(rs.getInt("thanh_tien"));
					listOrder.add(chiTietHoaDon);
				}
				return listOrder;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public int Count() {
		// TODO Auto-generated method stub
				try {
					Connection cons = DBConnect.getConnection();
					String sql = "SELECT count(ma_hoa_don) AS dem FROM hoa_don";
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


}
