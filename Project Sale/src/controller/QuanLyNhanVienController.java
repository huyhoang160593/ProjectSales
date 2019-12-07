package controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.nio.channels.NonReadableChannelException;
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

import model.NhanVien;
import service.NhanVienService;
import service.NhanVienServiceImpl;
import ultility.ClassTableModel;

public class QuanLyNhanVienController {
	private JPanel jpnView;
	private JButton btnAdd;
	private JTextField jtfSreach;
	
	private ClassTableModel classTableModel = null;
	
	private final String[] COLUMN = {"Mã nhân viên","Tên nhân viên","Giới tính","Địa chỉ","Số điện thoại","Ngày sinh","Tình trạng"};
	
	private NhanVienService nhanVienService = null;
	private TableRowSorter<TableModel> rowSorter = null;
	public QuanLyNhanVienController(JPanel jpnView, JButton btnAdd, JTextField jtfSreach) {
		this.jpnView = jpnView;
		this.btnAdd = btnAdd;
		this.jtfSreach = jtfSreach;
		this.classTableModel = new ClassTableModel();
		this.nhanVienService = new NhanVienServiceImpl();
	}
	
	public void setDataToTable() {
		List<NhanVien> listItem = nhanVienService.getList();
		DefaultTableModel model = classTableModel.setTableNhanVien(listItem, COLUMN);
		JTable table = new JTable(model);
		
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		
		jtfSreach.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text = jtfSreach.getText();
				if(text.trim().length()==0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text = jtfSreach.getText();
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
	
	//setEvent() ở đây
}
