package controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import bean.HoaDonInfoBean;
import model.ChiTietHoaDon;
import model.DonHang;
import model.KhachHang;
import service.DonHangService;
import service.DonHangServiceImpl;
import service.KhachHangService;
import service.KhachHangServiceImpl;
import ultility.ClassTableModel;
import ultility.HoaDonPDF;

public class DonHangInfoController {
	private JTextField textFieldMaHoaDon;
	private JTextField textFieldNgayBan;
	private JTextField textFieldThanhTien;
	private JTextField textFieldNhanVien;
	private JTextField textFieldTenKhachHang;
	private JTextField textFieldSDT;
	
	private JButton btnChuyenQuaPDF;
	
	private JPanel panelTable;
	
	private DonHangService donHangService = null;
	private KhachHangService khachHangService = null;
	
	private List<ChiTietHoaDon> listOrder = null;	
	
	private String[] COLUMN = {"Tên mặt hàng","Đơn giá","Số lượng","Thành tiền"};
	
	private ClassTableModel classTableModel = null;
	
	public DonHangInfoController(JTextField textFieldMaHoaDon, JTextField textFieldNgayBan,
			JTextField textFieldThanhTien, JTextField textFieldNhanVien, JTextField textFieldTenKhachHang,
			JTextField textFieldSDT,JButton btnChuyenQuaPDF, JPanel panelTable) {

		this.textFieldMaHoaDon = textFieldMaHoaDon;
		this.textFieldNgayBan = textFieldNgayBan;
		this.textFieldThanhTien = textFieldThanhTien;
		this.textFieldNhanVien = textFieldNhanVien;
		this.textFieldTenKhachHang = textFieldTenKhachHang;
		this.textFieldSDT = textFieldSDT;
		this.panelTable = panelTable;
		
		this.btnChuyenQuaPDF = btnChuyenQuaPDF;
		
		this.donHangService = new DonHangServiceImpl();
		this.khachHangService = new KhachHangServiceImpl();
		
		this.classTableModel = new ClassTableModel();
		this.listOrder = new ArrayList<ChiTietHoaDon>();
	}
	
	//lấy dữ liệu csdl để đổ vào bảng
	public void setDataToTable(DonHang donHang) {
		listOrder = donHangService.getDetailOrderList(donHang.getMa_hoa_don());
		DefaultTableModel model = classTableModel.setTableChiTietHoaDon(listOrder, COLUMN);	
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
	
	//sét các thuộc tính lấy được
	public void event(DonHang donHang) {
		textFieldMaHoaDon.setEditable(false);
		textFieldMaHoaDon.setText("#"+donHang.getMa_hoa_don());
		textFieldNgayBan.setEditable(false);
		String ngay_ban_fomat = donHang.getNgay_ban().toString();
		ngay_ban_fomat = ngay_ban_fomat.replace("T", " ");
		textFieldNgayBan.setText(ngay_ban_fomat);
		textFieldNhanVien.setEditable(false);
		textFieldNhanVien.setText(donHang.getTen_nhan_vien());
		textFieldTenKhachHang.setEditable(false);
		textFieldTenKhachHang.setText(donHang.getTen_khach_hang());
		textFieldThanhTien.setEditable(false);
		textFieldThanhTien.setText(Integer.toString(donHang.getThanh_tien()));
		KhachHang khachHang = khachHangService.getKhachHangSDT(donHang.getMa_khach_hang());
		textFieldSDT.setText(khachHang.getSo_dien_thoai());
		textFieldSDT.setEditable(false);
		
		//Phím chuyển qua pdf sẽ đảm nhận vai trò dựa vào info trong frame để tạo ra một đơn hàng hoàn chỉnh theo mẫu(trong HoaDonPDF)
		btnChuyenQuaPDF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HoaDonInfoBean hoaDonInfo = new HoaDonInfoBean();
				hoaDonInfo.setMaHoaDon(textFieldMaHoaDon.getText());
				hoaDonInfo.setNgayBan(textFieldNgayBan.getText());
				hoaDonInfo.setNhanVien(textFieldNhanVien.getText());
				hoaDonInfo.setTenKhachHang(textFieldTenKhachHang.getText());
				hoaDonInfo.setsDT(textFieldSDT.getText());
				hoaDonInfo.setThanhTien(textFieldThanhTien.getText());
				listOrder = donHangService.getDetailOrderList(donHang.getMa_hoa_don());
				hoaDonInfo.setListOrder(listOrder);
				new HoaDonPDF(hoaDonInfo);
				
			}
		});
	}
}
