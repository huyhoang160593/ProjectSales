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
import java.awt.Font;

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
		setBounds(100, 100, 500, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][][][]", "[grow][][][][][][grow][]"));
		
		JLabel lblMaMatHang = new JLabel("Mã mặt hàng:");
		lblMaMatHang.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblMaMatHang, "cell 0 1,alignx trailing");
		
		JLabel lblTenMatHang = new JLabel("Tên mặt hàng:");
		lblTenMatHang.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblTenMatHang, "cell 3 1,alignx trailing");
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(comboBox, "cell 4 1,growx");
		
		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblSoLuong, "cell 0 2,alignx trailing");
		
		JLabel lblDonGia = new JLabel("Đơn giá:");
		lblDonGia.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblDonGia, "cell 3 2,alignx trailing");
		
		
		textFieldDonGia = new JTextField();
		textFieldDonGia.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(textFieldDonGia, "cell 4 2,growx");
		textFieldDonGia.setColumns(10);
		
		JLabel lblLoaiHang = new JLabel("Loại Hàng:");
		lblLoaiHang.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblLoaiHang, "cell 0 4,alignx trailing");
		
		textFieldLoaiHang = new JTextField();
		textFieldLoaiHang.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(textFieldLoaiHang, "cell 1 4,growx");
		textFieldLoaiHang.setColumns(10);
		
		textFieldMaMatHang = new JTextField();
		textFieldMaMatHang.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(textFieldMaMatHang, "cell 1 1");
		textFieldMaMatHang.setColumns(2);
				
		
		textFieldSoLuong = new JTextField();
		textFieldSoLuong.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(textFieldSoLuong, "cell 1 2,growx");
		textFieldSoLuong.setColumns(10);
		
		JLabel lblThanhTien = new JLabel("Thành tiền:");
		lblThanhTien.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(lblThanhTien, "cell 4 4");
		
		
		textFieldThanhTien = new JTextField();
		textFieldThanhTien.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(textFieldThanhTien, "cell 4 5,growx");
		textFieldThanhTien.setColumns(10);
		
		JLabel lblCurrency = new JLabel("vnđ");
		lblCurrency.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblCurrency, "cell 5 5");
		
		JButton btnThemMatHang = new JButton("Thêm mặt hàng");
		btnThemMatHang.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(btnThemMatHang, "cell 4 7");
		
		ThemMatHangController controller = new ThemMatHangController(textFieldMaMatHang, textFieldSoLuong, textFieldDonGia, textFieldThanhTien, textFieldLoaiHang, btnThemMatHang, comboBox);
		controller.setData(chiTietHoaDon,this);
	}

}
