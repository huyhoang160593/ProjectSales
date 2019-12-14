package controller;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.KhachHang;
import service.KhachHangService;
import service.KhachHangServiceImpl;

public class KhachHangController {
	private JButton btnSubmit;
	private JTextField textFieldMaKhachHang;
	private JTextField textFieldHoTen;
	private JTextField textFieldSoDienThoai;
	private JTextArea textAreaDiaChi;
	private JLabel lblMsg;
	
	private KhachHang khachHang = null;
	
	private KhachHangService khachHangService = null;

	public KhachHangController(JButton btnSubmit, JTextField textFieldMaKhachHang, JTextField textFieldHoTen,
			JTextField textFieldSoDienThoai, JTextArea textAreaDiaChi, JLabel lblMsg) {
		this.btnSubmit = btnSubmit;
		this.textFieldMaKhachHang = textFieldMaKhachHang;
		this.textFieldHoTen = textFieldHoTen;
		this.textFieldSoDienThoai = textFieldSoDienThoai;
		this.textAreaDiaChi = textAreaDiaChi;
		this.lblMsg = lblMsg;		
		this.khachHangService = new KhachHangServiceImpl();
	}
	
	public void setView(KhachHang khachHang) {
		this.khachHang = khachHang;
		//set data
		textFieldMaKhachHang.setText("#" + khachHang.getMa_khach_hang());
		textFieldHoTen.setText(khachHang.getHo_ten());
		textFieldSoDienThoai.setText(khachHang.getSo_dien_thoai());
		textAreaDiaChi.setText(khachHang.getDia_chỉ());
		setEvent();
	}
	
	public void setEvent() {
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (!checkNotNull()) {
						lblMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
					} else {
						khachHang.setHo_ten(textFieldHoTen.getText().trim());
						khachHang.setSo_dien_thoai(textFieldSoDienThoai.getText());
						khachHang.setDia_chỉ(textAreaDiaChi.getText());
						if(showDialog()) {
							int lastId = khachHangService.createOrUpdate(khachHang);
							System.out.println(lastId);
							if (lastId != 0) {							
								khachHang.setMa_khach_hang(lastId);
								textFieldMaKhachHang.setText("#" + khachHang.getMa_khach_hang());
								lblMsg.setText("Xử lý cập nhật dữ liệu thành công");
							} else {
								lblMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
							}
						}
					}
				} catch (Exception e2) {
					lblMsg.setText(e2.toString());
					e2.printStackTrace();
					// TODO: handle exception
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSubmit.setBackground(new Color(0,200,83));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSubmit.setBackground(new Color(100,221,23));
			}
		});
	}
	
	private boolean checkNotNull(){
		return textFieldHoTen.getText() != null && !textFieldHoTen.getText().equalsIgnoreCase("");
	}
	
	private boolean showDialog() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật dữ liệu hay không", "Thông báo", JOptionPane.YES_NO_OPTION);
		return dialogResult == JOptionPane.YES_OPTION;
	}
}
