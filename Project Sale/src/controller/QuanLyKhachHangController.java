package controller;
import model.KhachHang;
import service.KhachHangService;
import service.KhachHangServiceImpl;
import ultility.ClassTableModel;
import view.KhachHangJFrame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class QuanLyKhachHangController {
	private JPanel jpnView;
	private JLabel lblSecret;
	private JButton btnAdd;
	private JButton buttonThayDoi;
	private JTextField jtfSearch;
	private JButton buttonDelete;
	
	private ClassTableModel classTableModel = null;
	
	private final String[] COLUMN = {"Mã khách hàng","Tên khách hàng","Số điện thoại", "Địa chỉ"};
	
	private KhachHangService khachHangService = null;
	private TableRowSorter<TableModel> rowSorter = null;
	
	public QuanLyKhachHangController(JPanel jpnView,JLabel lblSecret, JButton btnAdd,JButton buttonThayDoi,JButton buttonDelete, JTextField jtfSearch) {
		this.jpnView = jpnView;
		this.lblSecret = lblSecret;
		this.btnAdd = btnAdd;
		this.buttonThayDoi = buttonThayDoi;
		this.jtfSearch = jtfSearch;
		this.buttonDelete = buttonDelete;
		this.classTableModel = new ClassTableModel();
		this.khachHangService = new KhachHangServiceImpl();
	}
	
	public void setDataToTable() {
		List<KhachHang> listItem = khachHangService.getList();
		DefaultTableModel model = classTableModel.setTableKhachHang(listItem, COLUMN);
		JTable table = new JTable(model);
		
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		
		jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = jtfSearch.getText();
				if(text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ text));
				}
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = jtfSearch.getText();
				if(text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ text));
				}
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//Table event
		
		//Bảng sẽ lấy thông tin trong dòng được chọn đó lưu vào một label ẩn, nhằm mục đích cho phím thay đổi	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() ==1 && table.getSelectedRow() != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					
					selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
					
					KhachHang khachHang = new KhachHang();
					khachHang.setMa_khach_hang((int)model.getValueAt(selectedRowIndex, 0));
					khachHang.setHo_ten(model.getValueAt(selectedRowIndex, 1).toString());
					khachHang.setSo_dien_thoai(model.getValueAt(selectedRowIndex, 2).toString());
					khachHang.setDia_chi(model.getValueAt(selectedRowIndex, 3) != null ? model.getValueAt(selectedRowIndex, 3).toString() : null);
					lblSecret.setText(khachHang.getMa_khach_hang()+"$"+khachHang.getHo_ten()+"$"+khachHang.getSo_dien_thoai()+"$"+khachHang.getDia_chi());
				}
//				if(e.getClickCount() == 2 && table.getSelectedRow() != -1) {
//					DefaultTableModel model = (DefaultTableModel) table.getModel();
//					int selectedRowIndex = table.getSelectedRow();
//					
//					selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
//					
//					KhachHang khachHang = new KhachHang();
//					khachHang.setMa_khach_hang((int)model.getValueAt(selectedRowIndex, 0));
//					khachHang.setHo_ten(model.getValueAt(selectedRowIndex, 1).toString());
//					khachHang.setSo_dien_thoai(model.getValueAt(selectedRowIndex, 2).toString());
//					khachHang.setDia_chi(model.getValueAt(selectedRowIndex, 3) != null ? model.getValueAt(selectedRowIndex, 3).toString() : null);
//					
//					KhachHangJFrame frame = new KhachHangJFrame(khachHang);
//					frame.setLocationRelativeTo(null);
//					frame.setResizable(false);
//					frame.setTitle("Thông tin khách hàng thay đổi");
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
	
	public void setEvent() {
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new KhachHangJFrame(new KhachHang());
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
		
		//Phím thay đổi sẽ lấy dữ liệu từ label ẩn đó, sau đó phân tách ra và gửi vào frame thay đổi, thay cho cách click đúp chuột để thay đổi như trước đây
		//Mặt hàng và nhân viên tương tự
		buttonThayDoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String[] khInfo= lblSecret.getText().split("\\$");
				KhachHang khachHang = new KhachHang();
				khachHang.setMa_khach_hang(Integer.parseInt(khInfo[0]));
				khachHang.setHo_ten(khInfo[1]);
				khachHang.setSo_dien_thoai(khInfo[2]);
				khachHang.setDia_chi(khInfo[3]);
				
				KhachHangJFrame frame = new KhachHangJFrame(khachHang);
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
				buttonThayDoi.setBackground(new Color(38, 70, 83));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonThayDoi.setBackground(new Color(42, 157, 143));
			}
		});
		
		buttonDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String[] khInfo= lblSecret.getText().split("\\$");
				System.out.println(khInfo[0]);
				khachHangService.delete(Integer.parseInt(khInfo[0]));
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
