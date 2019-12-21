package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import controller.DonHangController;
import model.DonHang;

import javax.swing.border.LineBorder;

public class DonHangJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMaHoaDon;
	private JTextField textFieldNgayBan;
	private JTextField textFieldThanhTien;
	private JTextField textFieldTenKhachHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonHangJFrame frame = new DonHangJFrame(new DonHang());
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
	public DonHangJFrame(DonHang donHang) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setResizable(false);
		setSize(900, 450);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelController = new JPanel();
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64), 1, true), "Thông tin đơn hàng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelInfo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelController, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE))
					.addGap(871))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelController, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
		);
		
		JButton btnSubmit = new JButton("Lưu dữ liệu");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBackground(new Color(100,221,23));
		
		JLabel lblMgs = new JLabel("");
		lblMgs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		GroupLayout gl_panelController = new GroupLayout(panelController);
		gl_panelController.setHorizontalGroup(
			gl_panelController.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelController.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMgs)
					.addPreferredGap(ComponentPlacement.RELATED, 725, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addContainerGap())
		);
		gl_panelController.setVerticalGroup(
			gl_panelController.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelController.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panelController.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(lblMgs))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		panelController.setLayout(gl_panelController);
		
		//phần thông tin
		panelInfo.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelDetail = new JPanel();
		panelInfo.add(panelDetail);
		panelDetail.setLayout(new MigLayout("", "[][grow][][][][grow]", "[grow][][][grow]"));
		
		JLabel lblMaHoaDon = new JLabel("Mã hoá đơn:");
		lblMaHoaDon.setFont(new Font("Arial", Font.PLAIN, 15));
		panelDetail.add(lblMaHoaDon, "cell 0 0,alignx trailing");
		
		textFieldMaHoaDon = new JTextField();
		textFieldMaHoaDon.setFont(new Font("Arial", Font.PLAIN, 15));
		panelDetail.add(textFieldMaHoaDon, "cell 1 0");
		textFieldMaHoaDon.setEditable(false);
		
		JLabel lblTenNhanVien = new JLabel("Tên nhân viên:");
		lblTenNhanVien.setFont(new Font("Arial", Font.PLAIN, 15));
		panelDetail.add(lblTenNhanVien, "cell 4 0,alignx trailing");
		
		JComboBox<String> comboNhanVien = new JComboBox<String>();
		comboNhanVien.setFont(new Font("Arial", Font.PLAIN, 15));
		panelDetail.add(comboNhanVien, "cell 5 0,growx");
		
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Arial", Font.PLAIN, 15));
		panelDetail.add(lblTenKhachHang, "cell 0 1,alignx trailing");
		
		textFieldTenKhachHang = new JTextField();
		panelDetail.add(textFieldTenKhachHang, "cell 1 1,growx");
		textFieldTenKhachHang.setColumns(10);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Arial", Font.PLAIN, 15));
		panelDetail.add(lblSDT, "cell 0 2,alignx trailing");
		
		JComboBox<String> comboBoxSDTKhachHang = new JComboBox<String>();
		comboBoxSDTKhachHang.setFont(new Font("Arial", Font.PLAIN, 15));
		panelDetail.add(comboBoxSDTKhachHang, "cell 1 2,growx");
		
		JLabel lblNgayBan = new JLabel("Ngày bán:");
		lblNgayBan.setFont(new Font("Arial", Font.PLAIN, 15));
		panelDetail.add(lblNgayBan, "cell 4 2,alignx trailing");		
		
		textFieldNgayBan = new JTextField();
		textFieldNgayBan.setFont(new Font("Arial", Font.PLAIN, 15));
		panelDetail.add(textFieldNgayBan, "cell 5 2");
		textFieldNgayBan.setEditable(false);
		textFieldNgayBan.setColumns(10);
		
		//phần table(các nút để trong panelInfo ^^)
		JButton btnThemMatHang = new JButton("Thêm mặt hàng");
		panelDetail.add(btnThemMatHang, "flowx,cell 3 3");
		
		
		JButton btnXoaMatHang = new JButton("Xoá mặt hàng");
		panelDetail.add(btnXoaMatHang, "cell 3 3");
		
		JLabel lblThanhTien = new JLabel("Thành Tiền:");
		lblThanhTien.setFont(new Font("Arial", Font.BOLD, 15));
		panelDetail.add(lblThanhTien, "cell 4 3,alignx trailing");
		
		//controller
		
		textFieldThanhTien = new JTextField();
		textFieldThanhTien.setFont(new Font("Arial", Font.PLAIN, 15));
		panelDetail.add(textFieldThanhTien, "cell 5 3,growx");
		textFieldThanhTien.setEditable(false);
		textFieldThanhTien.setColumns(10);
		
		JPanel panelTable = new JPanel();
		panelInfo.add(panelTable);
		contentPane.setLayout(gl_contentPane);
		
		JLabel lblSecret = new JLabel();
		lblSecret.setVisible(false);
		
		DonHangController controller = new DonHangController(btnSubmit, textFieldMaHoaDon, comboNhanVien, textFieldTenKhachHang, comboBoxSDTKhachHang, textFieldNgayBan, textFieldThanhTien, lblMgs, lblSecret, btnThemMatHang, btnXoaMatHang, panelTable);
		controller.setDataToTable();
		controller.event(this);
	}
}
