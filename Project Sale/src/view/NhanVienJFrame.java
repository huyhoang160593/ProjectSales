package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.NhanVien;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

import controller.NhanVienController;
import java.awt.Font;

public class NhanVienJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSubmit; 
	private JTextField textFieldSoDienThoai;
	private JTextField textFieldMaNhanVien;
	private JTextField textFieldHoTen;
	private JTextArea textAreaDiaChi;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private JDateChooser jdcNgaySinh;
	private JCheckBox chkbxTinhTrang;
	private JLabel lblMsg;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienJFrame frame = new NhanVienJFrame(new NhanVien());
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
	public NhanVienJFrame(NhanVien nhanVien) {
		setTitle("Thông tin nhân viên");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(900, 450);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thông tin nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
		
		lblMsg = new JLabel(""); //Sai sót được chú thích ở đây
		lblMsg.setForeground(new Color(255, 0, 0));
		
		btnSubmit = new JButton("Lưu dữ liệu");
		btnSubmit.setBackground(new Color(100,221,23));
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMsg)
							.addPreferredGap(ComponentPlacement.RELATED, 754, Short.MAX_VALUE)
							.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMsg)
						.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
		);
		panel.setLayout(new MigLayout("", "[][][grow][][grow][][grow][]", "[][][grow][][][][]"));
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
		lblMaNhanVien.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblMaNhanVien, "cell 1 0,alignx right");
		
		textFieldMaNhanVien = new JTextField();
		textFieldMaNhanVien.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldMaNhanVien.setEditable(false);
		panel.add(textFieldMaNhanVien, "cell 2 0");
		
		JLabel label = new JLabel("(*)");
		label.setForeground(Color.RED);
		panel.add(label, "cell 3 0");
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblSoDienThoai, "cell 5 0,alignx right");
		
		textFieldSoDienThoai = new JTextField();
		textFieldSoDienThoai.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(textFieldSoDienThoai, "cell 6 0,growx");
		textFieldSoDienThoai.setColumns(10);
		
		JLabel label_4 = new JLabel("(*)");
		label_4.setForeground(Color.RED);
		panel.add(label_4, "cell 7 0");
		
		JLabel lblHoTen = new JLabel("Họ và tên:");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblHoTen, "cell 1 2,alignx right");
		
		textFieldHoTen = new JTextField();
		textFieldHoTen.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(textFieldHoTen, "cell 2 2,growx");
		textFieldHoTen.setColumns(10);
		
		JLabel label_1 = new JLabel("(*)");
		label_1.setForeground(Color.RED);
		panel.add(label_1, "cell 3 2");
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblDiaChi, "cell 5 2,alignx right,aligny top");				
		
		textAreaDiaChi = new JTextArea();
		textAreaDiaChi.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(textAreaDiaChi, "cell 6 2,grow");
		
		JLabel label_5 = new JLabel("(*)");
		label_5.setForeground(Color.RED);
		panel.add(label_5, "cell 7 2,aligny top");
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblGioiTinh, "cell 1 3,alignx right");
		
		//Xét Button Group để nhóm phím và chỉ chọn 1 trong 2 giá trị nam và nữ
		ButtonGroup bg = new ButtonGroup();
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(rdbtnNam, "flowx,cell 2 3");
		bg.add(rdbtnNam);
		
		JLabel label_3 = new JLabel("(*)");
		label_3.setForeground(Color.RED);
		panel.add(label_3, "cell 3 3");
		
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNgaySinh, "cell 1 4,alignx right");
		
		jdcNgaySinh = new JDateChooser();
		panel.add(jdcNgaySinh, "cell 2 4,grow");
		
		JLabel label_2 = new JLabel("(*)");
		label_2.setForeground(Color.RED);
		panel.add(label_2, "cell 3 4");
		
		JLabel lblTinhTrang = new JLabel("Tính trạng:");
		lblTinhTrang.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblTinhTrang, "cell 1 5,alignx right");
		
		chkbxTinhTrang = new JCheckBox("Còn làm");
		chkbxTinhTrang.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(chkbxTinhTrang, "cell 2 5");
		
		JLabel lblNote = new JLabel("(*)Dữ liệu yêu cầu là bắt buộc");
		lblNote.setForeground(Color.RED);
		panel.add(lblNote, "cell 2 6");
		
		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(rdbtnNu, "cell 2 3");
		
		bg.add(rdbtnNu);
		
		contentPane.setLayout(gl_contentPane);
		
		NhanVienController controller = new NhanVienController(btnSubmit, textFieldSoDienThoai, textFieldMaNhanVien, textFieldHoTen, textAreaDiaChi, rdbtnNam, rdbtnNu, jdcNgaySinh, chkbxTinhTrang, lblMsg);
		controller.setView(nhanVien);
		
	}
}
