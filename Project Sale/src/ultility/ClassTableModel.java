package ultility;

import model.KhachHang;
import java.util.List;
import javax.swing.table.DefaultTableModel;
public class ClassTableModel {
	
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
				
				@Override
				public Class<?> getColumnClass(int columnIndex){
					return columnIndex == 4 ? Boolean.class : String.class;
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
				obj[3] = khachHang.getDia_chỉ();	
				dtm.addRow(obj);
			}
			return dtm;
		} 
}
