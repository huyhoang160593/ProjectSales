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
		textAreaDiaChi.setText(khachHang.getDia_chi());
		setEvent();
	}
	
	
	public void setEvent() {
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (!checkNotNull()) {	//phương thức kiểm tra dữ liệu bắt buộc
						lblMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
					} else {
						khachHang.setHo_ten(textFieldHoTen.getText().trim());
						khachHang.setSo_dien_thoai(textFieldSoDienThoai.getText());
						Integer.parseInt(textFieldSoDienThoai.getText());	//bắt lỗi khi người dùng cố tình đánh chữ vào ô SDT
//						if(!numberOnly(khachHang.getSo_dien_thoai())) { 
//							throw new NumberFormatException("Số điện thoại của bạn phải là số nhen");
//						}
						khachHang.setDia_chi(textAreaDiaChi.getText());
						if(showDialog()) {
							int lastId = khachHangService.createOrUpdate(khachHang);
							System.out.println(lastId);
							if (lastId != 0) {		//lastID quyết định xem dữ liệu đã được cập nhật vô csdl hay chưa					
								khachHang.setMa_khach_hang(lastId);
								textFieldMaKhachHang.setText("#" + khachHang.getMa_khach_hang());
								lblMsg.setForeground(new Color(0, 255, 0));
								lblMsg.setText("Xử lý cập nhật dữ liệu thành công! Bấm X để cập nhật dữ liệu...");	
							} else {
								lblMsg.setForeground(new Color(255, 0, 0));
								lblMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
							}
						}
					}
				} catch (NumberFormatException e2) {
					lblMsg.setForeground(new Color(255, 0, 0));
					lblMsg.setText("Số điện thoại của bạn phải là số nhen");
					e2.printStackTrace();
					// TODO: handle exception
				} catch (Exception e2) {
					// TODO: handle exception
					lblMsg.setForeground(new Color(255, 0, 0));
					lblMsg.setText(e2.toString());
					e2.printStackTrace();
				}
			}
			
			//Trang trí nút lưu
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
	
	//Kiểm tra xem người dùng có nhập đủ các thông tin, nếu không sẽ thông báo(ở trên)
	private boolean checkNotNull(){
		return textFieldHoTen.getText() != null && !textFieldHoTen.getText().equalsIgnoreCase("") && textFieldSoDienThoai.getText() != null && !textFieldSoDienThoai.getText().equalsIgnoreCase("");
	}
	
	private boolean showDialog() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật dữ liệu hay không", "Thông báo", JOptionPane.YES_NO_OPTION);
		return dialogResult == JOptionPane.YES_OPTION;
	}
	
//	private boolean numberOnly(String sodienthoai) {
//		String regex = "\\d";
//		return sodienthoai.matches(regex);
//	}
}
