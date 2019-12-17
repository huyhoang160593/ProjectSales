package controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.ChiTietHoaDon;
import model.DonHang;
import service.DonHangService;
import service.DonHangServiceImpl;
import ultility.ClassTableModel;

public class DonHangController {
	private JButton btnSubmit;
	private JTextField textFieldMaHoaDon;
	private JComboBox<String> comboNhanVien;
	private JComboBox<String> comboKhachHang;
	private JTextField textFieldNgayBan;
	private JLabel lblMgs;
	private JButton btnThemMatHang;
	private JButton btnXoaMatHang;
	private JPanel panelTable;
	
	private DonHang donHang = null;
	
	private DonHangService donHangService = null;
	
	private List<ChiTietHoaDon> listOrder = null;
	private String[] COLUMN = {"Tên mặt hàng","Đơn giá","Số lượng","Thành tiền"};
	private ClassTableModel classTableModel = null;

	public DonHangController(JButton btnSubmit, JTextField textFieldMaHoaDon, JComboBox<String> comboNhanVien,
			JComboBox<String> comboKhachHang, JTextField textFieldNgayBan, JLabel lblMgs, JButton btnThemMatHang,
			JButton btnXoaMatHang, JPanel panelTable) {
		this.btnSubmit = btnSubmit;
		this.textFieldMaHoaDon = textFieldMaHoaDon;
		this.comboNhanVien = comboNhanVien;
		this.comboKhachHang = comboKhachHang;
		this.textFieldNgayBan = textFieldNgayBan;
		this.lblMgs = lblMgs;
		this.btnThemMatHang = btnThemMatHang;
		this.btnXoaMatHang = btnXoaMatHang;
		
		this.donHangService = new DonHangServiceImpl();
		
		this.panelTable = panelTable;
		this.listOrder = new ArrayList<ChiTietHoaDon>();
	}
	
	public void setDataToTable() {
		DefaultTableModel model = new ClassTableModel().setTableChiTietHoaDon(listOrder, COLUMN);
				
		JTable table = new JTable(model);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 10));
        table.getTableHeader().setPreferredSize(new Dimension(50, 25));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        panelTable.removeAll();
        panelTable.setLayout(new CardLayout());
        panelTable.add(scroll);
        panelTable.validate();
        panelTable.repaint();
	}
	
	
}
