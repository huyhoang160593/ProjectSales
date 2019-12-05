package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.TitledBorder;

import controller.KhachHangController;
import model.KhachHang;

import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;



public class KhachHangJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMaKhachHang;
	private JTextField textFieldSoDienThoai;
	private JTextField textFieldHoTen;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHangJFrame frame = new KhachHangJFrame(new KhachHang());
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
	public KhachHangJFrame(KhachHang khachHang) {
		setTitle("Thông tin khách hàng");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
		
		JLabel lblMsg = new JLabel("Sai sot se duoc chu thich o day");
		lblMsg.setForeground(new Color(255, 0, 0));
		
		JButton btnSubmit = new JButton("Lưu dữ liệu");
		btnSubmit.setBackground(new Color(100,221,23));
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMsg)
					.addPreferredGap(ComponentPlacement.RELATED, 596, Short.MAX_VALUE)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMsg)
						.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
		);
		panel.setLayout(new MigLayout("", "[][][grow][][][][][][][][][][][][][grow][]", "[][][][][][grow][]"));
		
		JLabel lblMaKhachHang = new JLabel("Mã khách hàng:");
		panel.add(lblMaKhachHang, "cell 1 1,alignx trailing");
		
		textFieldMaKhachHang = new JTextField();
		panel.add(textFieldMaKhachHang, "cell 2 1,growx");
		textFieldMaKhachHang.setColumns(10);
		
		JLabel lblStar = new JLabel("(*)");
		lblStar.setForeground(new Color(255, 0, 0));
		panel.add(lblStar, "cell 3 1");
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		panel.add(lblSoDienThoai, "cell 14 1,alignx trailing");
		
		textFieldSoDienThoai = new JTextField();
		panel.add(textFieldSoDienThoai, "cell 15 1,growx");
		textFieldSoDienThoai.setColumns(10);
		
		JLabel label_1 = new JLabel("(*)");
		label_1.setForeground(Color.RED);
		panel.add(label_1, "cell 16 1");
		
		JLabel lblHoTen = new JLabel("Họ và tên:");
		panel.add(lblHoTen, "cell 1 3,alignx trailing");
		
		textFieldHoTen = new JTextField();
		panel.add(textFieldHoTen, "cell 2 3,growx");
		textFieldHoTen.setColumns(10);
		
		JLabel label = new JLabel("(*)");
		label.setForeground(Color.RED);
		panel.add(label, "cell 3 3");
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		panel.add(lblDiaChi, "cell 1 5");
		
		JTextArea textAreaDiaChi = new JTextArea();
		panel.add(textAreaDiaChi, "cell 2 5,grow");
		
		JLabel lblTip = new JLabel("(*) Dữ liệu yêu cầu bắt buộc");
		lblTip.setForeground(new Color(255, 0, 0));
		panel.add(lblTip, "cell 2 6");
		contentPane.setLayout(gl_contentPane);
		
		KhachHangController controller = new KhachHangController(btnSubmit, textFieldMaKhachHang, textFieldHoTen, textFieldSoDienThoai, textAreaDiaChi, lblMsg);
		controller.setView(khachHang);
	}
}
