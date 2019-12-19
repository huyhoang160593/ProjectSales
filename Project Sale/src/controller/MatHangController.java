package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.MatHang;
import service.MatHangService;
import service.MatHangServiceImpl;

public class MatHangController {
	private JButton btnSubmit;
	private JTextField jtfMaMatHang;
	private JTextField jtfTenMatHang;
	private JTextField jtfLoaiHang;
	private JTextField jtfDonGia;
	private JTextField jtfTonKho;
	private JCheckBox jcbCoSan;
	private JLabel jlbMsg;
	private JTextField jtfThoiGianNhap;
	
	private MatHang matHang = null;
	
	private MatHangService matHangService = null;

	public MatHangController(JButton btnSubmit, JTextField jtfMaMatHang, JTextField jtfTenMatHang,
			JTextField jtfLoaiHang, JTextField jtfDonGia, JTextField jtfTonKho, JCheckBox jcbCoSan,JTextField jtfThoiGianNhap, JLabel jlbMsg) {
		this.btnSubmit = btnSubmit;
		this.jtfMaMatHang = jtfMaMatHang;
		this.jtfTenMatHang = jtfTenMatHang;
		this.jtfLoaiHang = jtfLoaiHang;
		this.jtfDonGia = jtfDonGia;
		this.jtfTonKho = jtfTonKho;
		this.jcbCoSan = jcbCoSan;
		this.jtfThoiGianNhap = jtfThoiGianNhap;
		this.jlbMsg = jlbMsg;

		this.matHangService = new MatHangServiceImpl();
	}
	
	public void setView(MatHang matHang) {
		this.matHang = matHang;
		//set data
		jtfMaMatHang.setText("#" + matHang.getMa_mat_hang());
		jtfTenMatHang.setText(matHang.getTen_mat_hang());
		jtfLoaiHang.setText(matHang.getLoai_hang());
		jtfDonGia.setText(Integer.toString(matHang.getDon_gia()));
		jtfTonKho.setText(Integer.toString(matHang.getTon_kho()));
		jcbCoSan.setSelected(true);
		jtfThoiGianNhap.setText(LocalDate.now().toString());
		//setEvent
		setEvent();
	}
	
	public void setEvent() {
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (!checkNotNull()) {
						jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
					} else {
						matHang.setTen_mat_hang(jtfTenMatHang.getText().trim());
						matHang.setLoai_hang(jtfLoaiHang.getText());
						matHang.setDon_gia(Integer.parseInt(jtfDonGia.getText()));
						matHang.setTon_kho(Integer.parseInt(jtfTonKho.getText()));
						matHang.setCo_san(jcbCoSan.isSelected());
						matHang.setThoi_gian_nhap(LocalDateTime.now());
						if (showDialog()) {							
							int lastID = matHangService.createOrUpdate(matHang);
							if (lastID != 0) {
								matHang.setMa_mat_hang(lastID);
								jtfMaMatHang.setText("#" + matHang.getMa_mat_hang());
								jlbMsg.setForeground(new Color(0, 255, 0));
								jlbMsg.setText("Xử lý cập nhật dữ liệu thành công! Bấm X để cập nhật dữ liệu...");	
							}else {
								jlbMsg.setForeground(new Color(255, 0, 0));
								jlbMsg.setText("Có lỗi xảy ra vui lòng thử lại");
							}
						}		
					}
				} catch (Exception e2) {
					// TODO: handle exception
					jlbMsg.setText(e2.toString());
					e2.printStackTrace();
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnSubmit.setBackground(new Color(0,200,83));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnSubmit.setBackground(new Color(100,221,23));
			}
		});
	}
	
	private boolean checkNotNull() {
        return jtfTenMatHang.getText() != null && !jtfTenMatHang.getText().equalsIgnoreCase("");
    }
	
	private boolean showDialog() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật dữ liệu hay không", "Thông báo", JOptionPane.YES_NO_OPTION);
		return dialogResult == JOptionPane.YES_OPTION;
	}
}
