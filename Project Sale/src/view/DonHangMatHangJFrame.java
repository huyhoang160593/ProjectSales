package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ThemMatHangController;
import model.ChiTietHoaDon;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class DonHangMatHangJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMaMatHang;
	private JTextField textFieldSoLuong;
	private JTextField textFieldDonGia;
	private JTextField textFieldThanhTien;
	private JTextField textFieldLoaiHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonHangMatHangJFrame frame = new DonHangMatHangJFrame(new ChiTietHoaDon());
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
	public DonHangMatHangJFrame(ChiTietHoaDon chiTietHoaDon) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Thêm mặt hàng");
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][][][][grow][]", "[][][][][][][grow][]"));
		
		JLabel lblMaMatHang = new JLabel("Mã mặt hàng");
		contentPane.add(lblMaMatHang, "cell 0 1,alignx trailing");
		
		JLabel lblTenMatHang = new JLabel("Tên mặt hàng");
		contentPane.add(lblTenMatHang, "cell 5 1,alignx trailing");
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		contentPane.add(lblSoLuong, "cell 0 2,alignx trailing");
		
		JLabel lblDonGia = new JLabel("Đơn giá");
		contentPane.add(lblDonGia, "cell 5 2,alignx trailing");
		
		JLabel lblLoaiHang = new JLabel("Loại Hàng");
		contentPane.add(lblLoaiHang, "cell 0 4,alignx trailing");
		
		textFieldLoaiHang = new JTextField();
		contentPane.add(textFieldLoaiHang, "cell 1 4,growx");
		textFieldLoaiHang.setColumns(10);
		
		JLabel lblThanhTien = new JLabel("Thành tiền");
		contentPane.add(lblThanhTien, "cell 6 4");
		
		textFieldMaMatHang = new JTextField();
		contentPane.add(textFieldMaMatHang, "cell 1 1");
		textFieldMaMatHang.setColumns(2);
			
		
		JComboBox<String> comboBox = new JComboBox<String>();
		contentPane.add(comboBox, "cell 6 1,growx");
				
		
		textFieldSoLuong = new JTextField();
		contentPane.add(textFieldSoLuong, "cell 1 2,growx");
		textFieldSoLuong.setColumns(10);
				
		
		textFieldDonGia = new JTextField();
		contentPane.add(textFieldDonGia, "cell 6 2,growx");
		textFieldDonGia.setColumns(10);
				
		
		textFieldThanhTien = new JTextField();
		contentPane.add(textFieldThanhTien, "cell 6 5,growx");
		textFieldThanhTien.setColumns(10);
		
		JLabel lblCurrency = new JLabel("vnđ");
		contentPane.add(lblCurrency, "cell 7 5");
		
		JButton btnThemMatHang = new JButton("Thêm mặt hàng");
		contentPane.add(btnThemMatHang, "cell 6 7");
		
		ThemMatHangController controller = new ThemMatHangController(textFieldMaMatHang, textFieldSoLuong, textFieldDonGia, textFieldThanhTien, textFieldLoaiHang, btnThemMatHang, comboBox);
		controller.setData(chiTietHoaDon,this);
	}

}
