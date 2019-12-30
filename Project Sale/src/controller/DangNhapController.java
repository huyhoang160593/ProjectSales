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

//Controller việc đăng nhập của phần mềm
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
		
		//gọi service để chuẩn bị dùng đến csdl
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
							dialog.dispose();
							MainJFrame frame = new MainJFrame(false);
							frame.setVisible(true);
						} else {
							dialog.dispose();
							MainJFrame frame = new MainJFrame(true);
							frame.setVisible(true);
						}
					}
				} catch (NullPointerException e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,"Tài khoản hoặc mật khẩu của bạn không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
