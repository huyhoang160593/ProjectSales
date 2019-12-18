package ultility;

import model.ChiTietHoaDon;
import model.DonHang;
import model.KhachHang;
import model.MatHang;
import model.NhanVien;

import java.util.List;
import javax.swing.table.DefaultTableModel;
public class ClassTableModel {
		//tableKhachHang
		public DefaultTableModel setTableKhachHang(List<KhachHang> listItem, String[] listColumn) {
			int columns = listColumn.length;
			DefaultTableModel dtm = new DefaultTableModel() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int rowIndex, int colIndex) {
					return false;
				}
			};
			dtm.setColumnIdentifiers(listColumn);
			Object[] obj;
			int num = listItem.size();
			KhachHang khachHang = null;
			for (int i = 0; i < num; i++) {
				khachHang = listItem.get(i);
				obj = new Object[columns];
				obj[0] = khachHang.getMa_khach_hang();
				obj[1] = khachHang.getHo_ten();
				obj[2] = khachHang.getSo_dien_thoai();
				obj[3] = khachHang.getDia_chi();	
				dtm.addRow(obj);
			}
			return dtm;
		} 
		
		//tableNhanVien
		public DefaultTableModel setTableNhanVien(List<NhanVien> listItem, String[] listColumn) {
			int columns = listColumn.length;
			DefaultTableModel dtm = new DefaultTableModel() {
				
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
					}
				
				@Override
				public Class<?> getColumnClass(int columnIndex) {
					// TODO Auto-generated method stub
					return columnIndex == 6 ? Boolean.class : String.class;
				}
			};
			dtm.setColumnIdentifiers(listColumn);
			Object[] obj;
			int num = listItem.size();
			NhanVien nhanVien = null;
			for (int i = 0; i < num; i++) {
				nhanVien = listItem.get(i);
				obj = new Object[columns];
				obj[0] = nhanVien.getMa_nhan_vien();
				obj[1] = nhanVien.getTen_nhan_vien();
				obj[2] = nhanVien.isGioi_tinh() == true ? "Nam" : "Nữ";
				obj[3] = nhanVien.getDia_chi();
				obj[4] = nhanVien.getSo_dien_thoai();
				obj[5] = nhanVien.getNgay_sinh();
				obj[6] = nhanVien.isTinh_trang();
				dtm.addRow(obj);
			}
			return dtm;
		}
		
		//tableMatHang
		public DefaultTableModel setTableMatHang(List<MatHang> listItem, String[] listColumn) {
			int columns = listColumn.length;
			DefaultTableModel dtm = new DefaultTableModel() {
				
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
					}
				
				@Override
				public Class<?> getColumnClass(int columnIndex) {
					// TODO Auto-generated method stub
					return columnIndex == 5 ? Boolean.class : String.class;
				}
			};
			
			dtm.setColumnIdentifiers(listColumn);
			Object[] obj;
			int num = listItem.size();
			MatHang matHang = null;
			for (int i = 0; i < num; i++) {
				matHang = listItem.get(i);
				obj = new Object[columns];
				obj[0] = matHang.getMa_mat_hang();
				obj[1] = matHang.getTen_mat_hang();
				obj[2] = matHang.getLoai_hang();
				obj[3] = matHang.getDon_gia();
				obj[4] = matHang.getTon_kho();
				obj[5] = matHang.isCo_san();
				//hiển thị đúng kiểu thời gian nhập
				String thoi_gian_nhap = matHang.getThoi_gian_nhap().toString();
				thoi_gian_nhap = thoi_gian_nhap.replace('T', ' ');
				obj[6] = thoi_gian_nhap;
				dtm.addRow(obj);
			}
			
			return dtm;
		}
		
		//table đơn hàng
		public DefaultTableModel setTableDonHang(List<DonHang> listItem, String[] listColumn) {
			int columns = listColumn.length;
			
			DefaultTableModel dtm = new DefaultTableModel() {
				
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
					}
			};
			
			dtm.setColumnIdentifiers(listColumn);
			Object[] obj;
			int num = listItem.size();
			DonHang donHang = null;
			for (int i = 0; i < num; i++) {
				donHang = listItem.get(i);
				obj = new Object[columns];
				obj[0] = donHang.getMa_hoa_don();
				obj[1] = donHang.getTen_khach_hang();
				obj[2] = donHang.getTen_nhan_vien();
				String thoi_gian_nhap = donHang.getNgay_ban().toString();
				thoi_gian_nhap = thoi_gian_nhap.replace('T', ' ');
				obj[3] = thoi_gian_nhap;
				dtm.addRow(obj);
			}
			return dtm;
		}
		//table chi tiết hoá đơn
		public DefaultTableModel setTableChiTietHoaDon(List<ChiTietHoaDon> listItem, String[] listColumn) {
			int columns = listColumn.length;
			
			DefaultTableModel dtm = new DefaultTableModel() {
				
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
					}
			};
			
			dtm.setColumnIdentifiers(listColumn);
			
			Object[] obj;
			for (ChiTietHoaDon s : listItem) {
				obj = new Object[columns];
				obj[0] = s.getTen_mat_hang();
				obj[1] = s.getDon_gia();
				obj[2] = s.getSo_luong();
				obj[3] = s.getThanh_tien();
				dtm.addRow(obj);
			}
			return dtm;
		}
}
