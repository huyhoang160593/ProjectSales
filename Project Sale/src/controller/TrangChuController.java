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

public class TrangChuController {
	private JLabel numberKhachHang;
	private JLabel numberMatHang;
	private JLabel numberDonHang;
	private JTextField textFieldThang;
	
	private KhachHangService khachHangService = null;
	private MatHangService matHangService = null;
	private DonHangService donHangService = null;
	public TrangChuController(JLabel numberKhachHang, JLabel numberMatHang, JLabel numberDonHang,JTextField textFieldThang) {
		this.numberKhachHang = numberKhachHang;
		this.numberMatHang = numberMatHang;
		this.numberDonHang = numberDonHang;
		this.textFieldThang = textFieldThang;
		
		this.khachHangService = new KhachHangServiceImpl();
		this.matHangService = new MatHangServiceImpl();
		this.donHangService = new DonHangServiceImpl();
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
	}
	
	
	
	
}
