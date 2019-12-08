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
		setBounds(100, 100, 900, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thông tin nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
		
		lblMsg = new JLabel("Sai sot se duoc chu thich o day");
		lblMsg.setForeground(new Color(255, 0, 0));
		
		btnSubmit = new JButton("Lưu dữ liệu");
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
		panel.setLayout(new MigLayout("", "[][][grow][][][][][][][][][grow][]", "[][][grow][][][][]"));
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
		panel.add(lblMaNhanVien, "cell 1 1,alignx trailing");
		
		textFieldMaNhanVien = new JTextField();
		panel.add(textFieldMaNhanVien, "cell 2 1,growx");
		textFieldMaNhanVien.setColumns(10);
		
		JLabel label = new JLabel("(*)");
		label.setForeground(Color.RED);
		panel.add(label, "cell 3 1");
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		panel.add(lblSoDienThoai, "cell 10 1,alignx trailing");
		
		textFieldSoDienThoai = new JTextField();
		panel.add(textFieldSoDienThoai, "cell 11 1,growx");
		textFieldSoDienThoai.setColumns(10);
		
		JLabel label_4 = new JLabel("(*)");
		label_4.setForeground(Color.RED);
		panel.add(label_4, "cell 12 1");
		
		JLabel lblHoTen = new JLabel("Họ và tên:");
		panel.add(lblHoTen, "cell 1 2,alignx leading");
		
		textFieldHoTen = new JTextField();
		panel.add(textFieldHoTen, "cell 2 2,growx");
		textFieldHoTen.setColumns(10);
		
		JLabel label_1 = new JLabel("(*)");
		label_1.setForeground(Color.RED);
		panel.add(label_1, "cell 3 2");
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		panel.add(lblDiaChi, "cell 10 2,aligny top");
		
		textAreaDiaChi = new JTextArea();
		panel.add(textAreaDiaChi, "cell 11 2,grow");
		
		JLabel label_5 = new JLabel("(*)");
		label_5.setForeground(Color.RED);
		panel.add(label_5, "cell 12 2,aligny top");
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		panel.add(lblGioiTinh, "cell 1 3");
		
		//Xét Button Group để nhóm phím và chỉ chọn 1 trong 2 giá trị nam và nữ
		ButtonGroup bg = new ButtonGroup();
		rdbtnNam = new JRadioButton("Nam");
		panel.add(rdbtnNam, "cell 2 3");
		
		rdbtnNu = new JRadioButton("Nữ");
		panel.add(rdbtnNu, "cell 3 3");
		
		bg.add(rdbtnNu);
		bg.add(rdbtnNam);
		
		JLabel label_3 = new JLabel("(*)");
		label_3.setForeground(Color.RED);
		panel.add(label_3, "cell 4 3");
		
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		panel.add(lblNgaySinh, "cell 1 4");
		
		jdcNgaySinh = new JDateChooser();
		panel.add(jdcNgaySinh, "cell 2 4,grow");
		
		JLabel label_2 = new JLabel("(*)");
		label_2.setForeground(Color.RED);
		panel.add(label_2, "cell 3 4");
		
		JLabel lblTinhTrang = new JLabel("Tính trạng:");
		panel.add(lblTinhTrang, "cell 1 5");
		
		chkbxTinhTrang = new JCheckBox("Còn làm");
		panel.add(chkbxTinhTrang, "cell 2 5");
		
		JLabel lblNote = new JLabel("(*)Dữ liệu yêu cầu là bắt buộc");
		lblNote.setForeground(Color.RED);
		panel.add(lblNote, "cell 2 6");

		
		contentPane.setLayout(gl_contentPane);
		
		NhanVienController controller = new NhanVienController(btnSubmit, textFieldSoDienThoai, textFieldMaNhanVien, textFieldHoTen, textAreaDiaChi, rdbtnNam, rdbtnNu, jdcNgaySinh, chkbxTinhTrang, lblMsg);
		controller.setView(nhanVien);
		
	}
}
