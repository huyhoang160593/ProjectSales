package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controller.MatHangController;
import model.MatHang;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Font;

public class MatHangJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfDonGia;
	private JTextField jtfMaMatHang;
	private JTextField jtfTenMatHang;
	private JTextField jtfTonKho;
	private JTextField jtfLoaiHang;
	private JTextField jtfThoiGianNhap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatHangJFrame frame = new MatHangJFrame(new MatHang());
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
	public MatHangJFrame(MatHang matHang) {
		setTitle("Thông tin mặt hàng");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(900, 450);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelThongTin = new JPanel();
		panelThongTin.setBorder(new TitledBorder(null, "Thông tin mặt hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
		
		JLabel jlbMsg = new JLabel(""); //Sai sót được chú thích ở đây
		jlbMsg.setForeground(new Color(255, 0, 0));
		
		JButton btnSubmit = new JButton("Lưu dữ liệu");
		btnSubmit.setBackground(new Color(100,221,23));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelThongTin, GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(jlbMsg)
					.addPreferredGap(ComponentPlacement.RELATED, 595, Short.MAX_VALUE)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlbMsg)
						.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(panelThongTin, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
		);
		panelThongTin.setLayout(new MigLayout("", "[][][][grow][][]", "[][grow][][grow][][grow][]"));
		
		JLabel lblMaMatHang = new JLabel("Mã mặt hàng:");
		lblMaMatHang.setFont(new Font("Arial", Font.PLAIN, 15));
		panelThongTin.add(lblMaMatHang, "cell 1 0,alignx trailing");
		
		jtfMaMatHang = new JTextField();
		jtfMaMatHang.setFont(new Font("Arial", Font.PLAIN, 15));
		jtfMaMatHang.setEditable(false);
		panelThongTin.add(jtfMaMatHang, "cell 2 0");
		
		JLabel lblDonGia = new JLabel("Đơn giá(đ/đơn vị tính):");
		lblDonGia.setFont(new Font("Arial", Font.PLAIN, 15));
		panelThongTin.add(lblDonGia, "cell 4 0,alignx trailing");
		
		jtfDonGia = new JTextField();
		jtfDonGia.setFont(new Font("Arial", Font.PLAIN, 15));
		panelThongTin.add(jtfDonGia, "cell 5 0");
		jtfDonGia.setColumns(7);
		
		JLabel lblTenMatHang = new JLabel("Tên mặt hàng:");
		lblTenMatHang.setFont(new Font("Arial", Font.PLAIN, 15));
		panelThongTin.add(lblTenMatHang, "cell 1 2,alignx trailing");
		
		jtfTenMatHang = new JTextField();
		jtfTenMatHang.setFont(new Font("Arial", Font.PLAIN, 15));
		panelThongTin.add(jtfTenMatHang, "cell 2 2");
		jtfTenMatHang.setColumns(15);
		
		JLabel lblTonKho = new JLabel("Tồn kho:");
		lblTonKho.setFont(new Font("Arial", Font.PLAIN, 15));
		panelThongTin.add(lblTonKho, "cell 4 2,alignx trailing");
		
		jtfTonKho = new JTextField();
		jtfTonKho.setFont(new Font("Arial", Font.PLAIN, 15));
		panelThongTin.add(jtfTonKho, "cell 5 2");
		jtfTonKho.setColumns(7);
		
		JLabel lblLoaiHang = new JLabel("Loại hàng:");
		lblLoaiHang.setFont(new Font("Arial", Font.PLAIN, 15));
		panelThongTin.add(lblLoaiHang, "cell 1 4,alignx trailing");
		
		jtfLoaiHang = new JTextField();
		jtfLoaiHang.setFont(new Font("Arial", Font.PLAIN, 15));
		panelThongTin.add(jtfLoaiHang, "cell 2 4");
		jtfLoaiHang.setColumns(15);
		
		JLabel lblThoiGianNhap = new JLabel("Thời gian nhập");
		lblThoiGianNhap.setFont(new Font("Arial", Font.PLAIN, 15));
		panelThongTin.add(lblThoiGianNhap, "cell 1 6,alignx trailing");
		
		jtfThoiGianNhap = new JTextField();
		jtfThoiGianNhap.setFont(new Font("Arial", Font.PLAIN, 15));
		jtfThoiGianNhap.setEditable(false);
		panelThongTin.add(jtfThoiGianNhap, "cell 2 6");
		jtfThoiGianNhap.setColumns(10);
		
		JCheckBox jcbCoSan = new JCheckBox("Có sẵn");
		jcbCoSan.setFont(new Font("Arial", Font.BOLD, 15));
		panelThongTin.add(jcbCoSan, "cell 5 6");
		
		contentPane.setLayout(gl_contentPane);
		
		MatHangController controller = new MatHangController(btnSubmit, jtfMaMatHang, jtfTenMatHang, jtfLoaiHang, jtfDonGia, jtfTonKho, jcbCoSan, jtfThoiGianNhap, jlbMsg);
		controller.setView(matHang);
	}

}
