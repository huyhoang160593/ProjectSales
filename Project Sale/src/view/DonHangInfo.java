package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.DonHangInfoController;
import model.DonHang;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class DonHangInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMaHoaDon;
	private JTextField textFieldNhanVien;
	private JTextField textFieldTenKhachHang;
	private JTextField textFieldSDT;
	private JTextField textFieldNgayBan;
	private JTextField textFieldThanhTien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonHangInfo frame = new DonHangInfo(new DonHang());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DonHangInfo(DonHang donHang) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(900, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Thông tin đơn hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panelInfo = new JPanel();
		contentPane.add(panelInfo);
		panelInfo.setLayout(new MigLayout("", "[][][grow][][]", "[][][][grow][]"));
		
		JLabel lblMaHoaDon = new JLabel("Mã hoá đơn");
		lblMaHoaDon.setFont(new Font("Arial", Font.BOLD, 14));
		panelInfo.add(lblMaHoaDon, "cell 0 0,alignx trailing");
		
		textFieldMaHoaDon = new JTextField();
		textFieldMaHoaDon.setFont(new Font("Arial", Font.PLAIN, 15));
		panelInfo.add(textFieldMaHoaDon, "cell 1 0,growx");
		textFieldMaHoaDon.setColumns(10);
		
		JLabel lblTenNhanVien = new JLabel("Tên nhân viên");
		lblTenNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		panelInfo.add(lblTenNhanVien, "cell 3 0,alignx trailing");
		
		textFieldNhanVien = new JTextField();
		textFieldNhanVien.setFont(new Font("Arial", Font.PLAIN, 15));
		panelInfo.add(textFieldNhanVien, "cell 4 0,growx");
		textFieldNhanVien.setColumns(10);
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng");
		lblTenKhachHang.setFont(new Font("Arial", Font.BOLD, 14));
		panelInfo.add(lblTenKhachHang, "cell 0 1,alignx trailing");
		
		textFieldTenKhachHang = new JTextField();
		textFieldTenKhachHang.setFont(new Font("Arial", Font.PLAIN, 14));
		panelInfo.add(textFieldTenKhachHang, "cell 1 1,growx");
		textFieldTenKhachHang.setColumns(10);
		
		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setFont(new Font("Arial", Font.BOLD, 14));
		panelInfo.add(lblSDT, "cell 0 2,alignx trailing");
		
		textFieldSDT = new JTextField();
		textFieldSDT.setFont(new Font("Arial", Font.PLAIN, 15));
		panelInfo.add(textFieldSDT, "cell 1 2,growx");
		textFieldSDT.setColumns(10);
		
		JLabel lblNgayBan = new JLabel("Ngày bán");
		lblNgayBan.setFont(new Font("Arial", Font.BOLD, 14));
		panelInfo.add(lblNgayBan, "cell 3 2,alignx trailing");
		
		textFieldNgayBan = new JTextField();
		textFieldNgayBan.setFont(new Font("Arial", Font.PLAIN, 15));
		panelInfo.add(textFieldNgayBan, "cell 4 2,growx");
		textFieldNgayBan.setColumns(10);
		
		JButton btnChuyenQuaPDF = new JButton("In Hoá Đơn");
		panelInfo.add(btnChuyenQuaPDF, "cell 2 4,alignx right");
		
		JLabel lblThanhTien = new JLabel("Thành tiền");
		lblThanhTien.setFont(new Font("Arial", Font.BOLD, 14));
		panelInfo.add(lblThanhTien, "cell 3 4,alignx trailing");
		
		textFieldThanhTien = new JTextField();
		textFieldThanhTien.setFont(new Font("Arial", Font.PLAIN, 15));
		panelInfo.add(textFieldThanhTien, "cell 4 4,growx");
		textFieldThanhTien.setColumns(10);
		
		JPanel panelTable = new JPanel();
		contentPane.add(panelTable);
		
		DonHangInfoController controller = new DonHangInfoController(textFieldMaHoaDon, textFieldNgayBan, textFieldThanhTien, textFieldNhanVien, textFieldTenKhachHang, textFieldSDT, btnChuyenQuaPDF, panelTable);
		controller.setDataToTable(donHang);
		controller.event(donHang);
	}

}
