package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.DangNhapController;

import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class DangNhapJDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTenDangNhap;
	private JPasswordField textFieldMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapJDialog dialog = new DangNhapJDialog();
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public DangNhapJDialog(){
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Phần mềm quản lý bán hàng tối giản");
		
		//Managedsily - Manage your order easily :)))
		
		setSize(800, 435);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPicture = new JLabel("");
		lblPicture.setIcon(new ImageIcon(DangNhapJDialog.class.getResource("/images/gradientfix.png")));
		panel.add(lblPicture, BorderLayout.CENTER);
		
		JPanel panelLogin = new JPanel();
		contentPane.add(panelLogin);
		panelLogin.setBackground(Color.WHITE);
		panelLogin.setLayout(new MigLayout("", "[grow]", "[][][][][][][][grow]"));
		
		JLabel lblLabel = new JLabel("");
		lblLabel.setIcon(new ImageIcon(DangNhapJDialog.class.getResource("/images/icon.png")));
		panelLogin.add(lblLabel, "cell 0 0,alignx center");
		lblLabel.setForeground(Color.WHITE);
		lblLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTenDangNhap = new JLabel("Tên đăng nhập");
		lblTenDangNhap.setForeground(new Color(0, 236, 153));
		lblTenDangNhap.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		panelLogin.add(lblTenDangNhap, "cell 0 1");
		
		textFieldTenDangNhap = new JTextField();
		textFieldTenDangNhap.setToolTipText("Nhập tên đăng nhập vào đây");
		textFieldTenDangNhap.setForeground(Color.BLACK);
		textFieldTenDangNhap.setBackground(Color.WHITE);
		textFieldTenDangNhap.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		panelLogin.add(textFieldTenDangNhap, "cell 0 2,growx");
		textFieldTenDangNhap.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setForeground(new Color(0, 236, 153));
		lblMatKhau.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		panelLogin.add(lblMatKhau, "cell 0 3");
		
		textFieldMatKhau = new JPasswordField(10);
		textFieldMatKhau.setToolTipText("Nhập mật khẩu của bạn vào đây");
		textFieldMatKhau.setForeground(Color.BLACK);
		textFieldMatKhau.setBackground(Color.WHITE);
		textFieldMatKhau.setFont(new Font("Arial", Font.PLAIN, 20));
		panelLogin.add(textFieldMatKhau, "cell 0 4,growx");
		textFieldMatKhau.setColumns(10);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.setForeground(SystemColor.text);
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 20));
		panelLogin.add(btnLogin, "cell 0 5, growx");
		
		JLabel lblCaution = new JLabel("Thành công là bán được hàng, không bán được thì thôi");
		lblCaution.setForeground(Color.BLACK);
		panelLogin.add(lblCaution, "cell 0 6");
		
		DangNhapController controller = new DangNhapController(this, btnLogin, textFieldTenDangNhap, textFieldMatKhau, lblCaution);
		controller.setEvent();
	}

}
