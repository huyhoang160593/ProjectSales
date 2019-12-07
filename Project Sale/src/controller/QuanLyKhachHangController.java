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
import java.util.List;

import javax.swing.JButton;
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
	private JButton btnAdd;
	private JTextField jtfSreach;
	
	private ClassTableModel classTableModel = null;
	
	private final String[] COLUMN = {"Mã khách hàng","Tên khách hàng","Số điện thoại", "Địa chỉ"};
	
	private KhachHangService khachHangService = null;
	private TableRowSorter<TableModel> rowSorter = null;
	
	public QuanLyKhachHangController(JPanel jpnView, JButton btnAdd, JTextField jtfSreach) {
		this.jpnView = jpnView;
		this.btnAdd = btnAdd;
		this.jtfSreach = jtfSreach;
		this.classTableModel = new ClassTableModel();
		this.khachHangService = new KhachHangServiceImpl();
	}
	
	public void setDataToTable() {
		List<KhachHang> listItem = khachHangService.getList();
		DefaultTableModel model = classTableModel.setTableKhachHang(listItem, COLUMN);
		JTable table = new JTable(model);
		
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		
		jtfSreach.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = jtfSreach.getText();
				if(text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ text));
				}
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = jtfSreach.getText();
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
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() == 2 && table.getSelectedRow() != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					
					selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
					
					KhachHang khachHang = new KhachHang();
					khachHang.setMa_khach_hang((int)model.getValueAt(selectedRowIndex, 0));//chua hieu lam
					khachHang.setHo_ten(model.getValueAt(selectedRowIndex, 1).toString());
					khachHang.setSo_dien_thoai(model.getValueAt(selectedRowIndex, 2).toString());
					khachHang.setDia_chỉ(model.getValueAt(selectedRowIndex, 3) != null ? model.getValueAt(selectedRowIndex, 3).toString() : null);
					
					KhachHangJFrame frame = new KhachHangJFrame(khachHang);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setTitle("Thông tin khách hàng");
					frame.setVisible(true);
				}
			}
		});
		
		//design
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
				new KhachHangJFrame(new KhachHang()).setVisible(true);;	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(0,200,83));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(new Color(100,221,23));
			}
		});
	}
	
	
}
