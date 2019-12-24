package controller;

import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JTextField;


import service.DonHangService;
import service.DonHangServiceImpl;
import service.KhachHangService;
import service.KhachHangServiceImpl;
import service.MatHangService;
import service.MatHangServiceImpl;
import service.ThongKeService;
import service.ThongKeServiceImpl;

public class TrangChuController {
	private JLabel numberKhachHang;
	private JLabel numberMatHang;
	private JLabel numberDonHang;
	private JTextField textFieldThang;
	private JTextField textFieldNhanVienThang;
	private JTextField textFieldBestLoyalCustomer;
	private JTextField textFieldBestSellerItem;
	private JTextField textFieldSumThanhTien;
	
	private KhachHangService khachHangService = null;
	private MatHangService matHangService = null;
	private DonHangService donHangService = null;
	private ThongKeService thongKeService = null;
	public TrangChuController(JLabel numberKhachHang, JLabel numberMatHang, JLabel numberDonHang,JTextField textFieldThang,JTextField textFieldNhanVienThang,JTextField textFieldBestLoyalCustomer,JTextField textFieldBestSellerItem,JTextField textFieldSumThanhTien) {
		this.numberKhachHang = numberKhachHang;
		this.numberMatHang = numberMatHang;
		this.numberDonHang = numberDonHang;
		this.textFieldThang = textFieldThang;
		this.textFieldNhanVienThang = textFieldNhanVienThang;
		this.textFieldBestLoyalCustomer = textFieldBestLoyalCustomer;
		this.textFieldBestSellerItem = textFieldBestSellerItem;
		this.textFieldSumThanhTien = textFieldSumThanhTien;
		
		this.khachHangService = new KhachHangServiceImpl();
		this.matHangService = new MatHangServiceImpl();
		this.donHangService = new DonHangServiceImpl();
		this.thongKeService = new ThongKeServiceImpl();
	}
	
	public void setData() {
		int countKhachHang = khachHangService.count();
		numberKhachHang.setText(Integer.toString(countKhachHang));
		int countMatHang = matHangService.count();
		numberMatHang.setText(Integer.toString(countMatHang));
		int countDonHang = donHangService.count();
		numberDonHang.setText(Integer.toString(countDonHang));
		String nowMonth = LocalDate.now().toString().substring(0, 7);
		textFieldThang.setText(nowMonth);
		
		textFieldNhanVienThang.setText(thongKeService.getBestEmployee());
		
		textFieldBestLoyalCustomer.setText(thongKeService.getBestCustomer());
		
		textFieldBestSellerItem.setText(thongKeService.getBestSeller());
		
		textFieldSumThanhTien.setText(Integer.toString(thongKeService.getDoanhThu()));
	}
	
	
	
	
}
