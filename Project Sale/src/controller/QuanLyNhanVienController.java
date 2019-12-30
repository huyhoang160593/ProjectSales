package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.NhanVien;
import service.NhanVienService;
import service.NhanVienServiceImpl;
import ultility.ClassTableModel;
import view.NhanVienJFrame;

public class QuanLyNhanVienController {
	private JPanel jpnView;
	private JLabel lblSecret;
	private JButton btnThayDoi;
	private JButton btnAdd;
	private JTextField jtfSearch;
	private JButton buttonDelete;
	
	private ClassTableModel classTableModel = null;
	
	private final String[] COLUMN = {"Mã nhân viên","Tên nhân viên","Giới tính","Địa chỉ","Số điện thoại","Ngày sinh","Tình trạng"};
	
	private NhanVienService nhanVienService = null;
	private TableRowSorter<TableModel> rowSorter = null;
	public QuanLyNhanVienController(JPanel jpnView,JLabel lblSecret,JButton btnThayDoi, JButton btnAdd,JButton buttonDelete, JTextField jtfSreach) {
		this.jpnView = jpnView;
		this.lblSecret = lblSecret;
		this.btnThayDoi = btnThayDoi;
		this.btnAdd = btnAdd;
		this.jtfSearch = jtfSreach;
		this.buttonDelete = buttonDelete;
		this.classTableModel = new ClassTableModel();
		this.nhanVienService = new NhanVienServiceImpl();
	}
	
	public void setDataToTable() {
		List<NhanVien> listItem = nhanVienService.getList();
		DefaultTableModel model = classTableModel.setTableNhanVien(listItem, COLUMN);
		JTable table = new JTable(model);
		
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		
		jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text = jtfSearch.getText();
				if(text.trim().length()==0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text = jtfSearch.getText();
				if(text.trim().length()==0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//addMouseListener ở đây
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() ==1 && table.getSelectedRow() != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					
					selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
					
					NhanVien nhanVien = new NhanVien();
					nhanVien.setMa_nhan_vien((int) model.getValueAt(selectedRowIndex, 0));
					nhanVien.setTen_nhan_vien(model.getValueAt(selectedRowIndex, 1).toString());
					nhanVien.setGioi_tinh(model.getValueAt(selectedRowIndex, 2).toString().equalsIgnoreCase("Nam"));
					nhanVien.setDia_chi(model.getValueAt(selectedRowIndex, 3).toString());
					nhanVien.setSo_dien_thoai(model.getValueAt(selectedRowIndex, 4).toString());
					nhanVien.setNgay_sinh((Date) model.getValueAt(selectedRowIndex, 5));
					nhanVien.setTinh_trang((boolean) model.getValueAt(selectedRowIndex, 6));
					lblSecret.setText(nhanVien.getMa_nhan_vien()+"$"+nhanVien.getTen_nhan_vien()+"$"+nhanVien.isGioi_tinh()+"$"+nhanVien.getDia_chi()+"$"+nhanVien.getSo_dien_thoai()+"$"+nhanVien.getNgay_sinh()+"$"+nhanVien.isTinh_trang());
				}
				
//				if(e.getClickCount() == 2 && table.getSelectedRow() != -1) {
//					DefaultTableModel model = (DefaultTableModel) table.getModel();
//					int selectedRowIndex = table.getSelectedRow();
//					
//					selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
//					
//					NhanVien nhanVien = new NhanVien();
//					nhanVien.setMa_nhan_vien((int) model.getValueAt(selectedRowIndex, 0));
//					nhanVien.setTen_nhan_vien(model.getValueAt(selectedRowIndex, 1).toString());
//					nhanVien.setGioi_tinh(model.getValueAt(selectedRowIndex, 2).toString().equalsIgnoreCase("Nam"));
//					nhanVien.setDia_chi(model.getValueAt(selectedRowIndex, 3).toString());
//					nhanVien.setSo_dien_thoai(model.getValueAt(selectedRowIndex, 4).toString());
//					nhanVien.setNgay_sinh((Date) model.getValueAt(selectedRowIndex, 5));
//					nhanVien.setTinh_trang((boolean) model.getValueAt(selectedRowIndex, 6));
//					
//					NhanVienJFrame frame = new NhanVienJFrame(nhanVien);
//					frame.setLocationRelativeTo(null);
//					frame.setResizable(false);
//					frame.setTitle("Thông tin nhân viên thay đổi");
//					frame.setVisible(true);
//					frame.addWindowListener(new WindowAdapter() {
//						public void windowDeactivated(java.awt.event.WindowEvent e) {
//							setDataToTable();
//						};
//					});
//				}
			}
		});
		
		//design
		table.getColumnModel().getColumn(0).setMaxWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		table.getTableHeader().setPreferredSize(new Dimension(100,50));
		table.setRowHeight(50);
		table.validate();
		table.repaint();
		
		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(table);
		scroll.setPreferredSize(new Dimension(1350, 400));
		jpnView.removeAll();
		jpnView.setLayout(new CardLayout());
		jpnView.add(scroll);
		jpnView.validate();
		jpnView.repaint();
	}
	
	//setEvent() ở đây
	public void setEvent() {
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new NhanVienJFrame(new NhanVien());
				frame.setVisible(true);
				frame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub
						setDataToTable();
					}
				});
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(38, 70, 83));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(new Color(42, 157, 143));
			}
		});
		
		btnThayDoi.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			String[] nvInfo= lblSecret.getText().split("\\$");
			NhanVien nhanVien = new NhanVien();
			nhanVien.setMa_nhan_vien(Integer.parseInt(nvInfo[0]));
			nhanVien.setTen_nhan_vien(nvInfo[1]);
			nhanVien.setGioi_tinh(Boolean.parseBoolean(nvInfo[2]));
			nhanVien.setDia_chi(nvInfo[3]);
			nhanVien.setSo_dien_thoai(nvInfo[4]);
			nhanVien.setTinh_trang(Boolean.parseBoolean(nvInfo[6]));
			
		
			NhanVienJFrame frame = new NhanVienJFrame(nhanVien);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setTitle("Thông tin khách hàng thay đổi");
			frame.setVisible(true);
			frame.addWindowListener(new WindowAdapter() {
				public void windowDeactivated(java.awt.event.WindowEvent e) {
					setDataToTable();
				};
			});
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			btnThayDoi.setBackground(new Color(38, 70, 83));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			btnThayDoi.setBackground(new Color(42, 157, 143));
		}
		});
		
		buttonDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String[] nvInfo= lblSecret.getText().split("\\$");
				nhanVienService.delete(Integer.parseInt(nvInfo[0]));
				setDataToTable();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonDelete.setBackground(new Color(38, 70, 83));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonDelete.setBackground(new Color(42, 157, 143));
			}
		});
	}
}
