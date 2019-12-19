package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.TaiKhoan;
import service.TaiKhoanService;
import service.TaiKhoanServiceImpl;
import view.MainJFrame;

public class DangNhapController {
	private JDialog dialog;
	private JButton btnLogin;
	private JTextField textFieldTenDangNhap;
	private JPasswordField textFieldMatKhau;
	private JLabel lblCaution;
	
	private TaiKhoanService taiKhoanService = null;

	public DangNhapController(JDialog dialog, JButton btnLogin, JTextField textFieldTenDangNhap,
			JPasswordField textFieldMatKhau, JLabel lblCaution) {
		this.dialog = dialog;
		this.btnLogin = btnLogin;
		this.textFieldTenDangNhap = textFieldTenDangNhap;
		this.textFieldMatKhau = textFieldMatKhau;
		this.lblCaution = lblCaution;
		
		taiKhoanService = new TaiKhoanServiceImpl();
	}
	
	public void setEvent() {
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					char[] input = textFieldMatKhau.getPassword();
					String password = new String(input);
					if(textFieldTenDangNhap.getText().length() == 0 || textFieldMatKhau.getPassword().length == 0) {
						lblCaution.setForeground(new Color(255, 0, 0));
						lblCaution.setText("Vui lòng nhập dữ liệu bắt buộc!");
					}else {
						TaiKhoan taiKhoan = taiKhoanService.login(textFieldTenDangNhap.getText().trim(), password.trim());
						if(!taiKhoan.isTinh_trang()) {
							lblCaution.setForeground(new Color(255, 0, 0));
							lblCaution.setText("Tài khoản của bạn đã bị khoá tạm thời");
						} else {
							dialog.dispose();
							MainJFrame frame = new MainJFrame();
							frame.setVisible(true);
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}
			}
		});
	}
}
