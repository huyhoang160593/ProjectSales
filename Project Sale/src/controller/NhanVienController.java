package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.Date;
import com.toedter.calendar.JDateChooser;

import model.NhanVien;
import service.NhanVienService;
import service.NhanVienServiceImpl;

public class NhanVienController {
	
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
	
	private NhanVien nhanVien = null;
	
	private NhanVienService nhanVienService = null;

	public NhanVienController(JButton btnSubmit, JTextField textFieldSoDienThoai, JTextField textFieldMaNhanVien,
			JTextField textFieldHoTen, JTextArea textAreaDiaChi, JRadioButton rdbtnNam, JRadioButton rdbtnNu,
			JDateChooser jdcNgaySinh, JCheckBox chkbxTinhTrang, JLabel lblMsg) {
		this.btnSubmit = btnSubmit;
		this.textFieldSoDienThoai = textFieldSoDienThoai;
		this.textFieldMaNhanVien = textFieldMaNhanVien;
		this.textFieldHoTen = textFieldHoTen;
		this.textAreaDiaChi = textAreaDiaChi;
		this.rdbtnNam = rdbtnNam;
		this.rdbtnNu = rdbtnNu;
		this.jdcNgaySinh = jdcNgaySinh;
		this.chkbxTinhTrang = chkbxTinhTrang;
		this.lblMsg = lblMsg;
		
		this.nhanVienService = new NhanVienServiceImpl();
	}
	
	public void setView(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		//set data
		textFieldMaNhanVien.setText("#" + nhanVien.getMa_nhan_vien());
		textFieldHoTen.setText(nhanVien.getTen_nhan_vien());
		jdcNgaySinh.setDate(nhanVien.getNgay_sinh());
		if(nhanVien.isGioi_tinh()) {
			rdbtnNam.setSelected(true);
		} else {
			rdbtnNu.setSelected(true);
		}
		textFieldSoDienThoai.setText(nhanVien.getSo_dien_thoai());
		textAreaDiaChi.setText(nhanVien.getDia_chi());
		chkbxTinhTrang.setSelected(nhanVien.isTinh_trang());
		//set event
		setEvent();
	}
	
	public void setEvent() {
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					if(!checkNotNull()) {
						lblMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
					} else {
						nhanVien.setTen_nhan_vien(textFieldHoTen.getText().trim());
						nhanVien.setNgay_sinh(covertDateToDateSql(jdcNgaySinh.getDate()));
						nhanVien.setSo_dien_thoai(textFieldSoDienThoai.getText());
						Integer.parseInt(textFieldSoDienThoai.getText());
//						if(!numberOnly(nhanVien.getSo_dien_thoai().trim())) {
//							throw new NumberFormatException("Số điện thoại của bạn phải là số nhen");
//							}
						nhanVien.setGioi_tinh(rdbtnNam.isSelected());
						nhanVien.setDia_chi(textAreaDiaChi.getText());
						nhanVien.setTinh_trang(chkbxTinhTrang.isSelected());
						if(showDialog()) {
							int lastID = nhanVienService.createOrUpdate(nhanVien);
							if (lastID != 0) {
								nhanVien.setMa_nhan_vien(lastID);
								textFieldMaNhanVien.setText("#" + nhanVien.getMa_nhan_vien());
								lblMsg.setForeground(new Color(0, 255, 0));
								lblMsg.setText("Xử lý cập nhật dữ liệu thành công! Bấm X để cập nhật dữ liệu...");	
							} else {
								lblMsg.setForeground(new Color(255, 0, 0));
								lblMsg.setText("Có lỗi xảy ra. Vui lòng thử lại");
							}
						}
					}
				} catch (Exception ex) {
					lblMsg.setText(ex.toString());
					ex.printStackTrace();
					// TODO: handle exception
				}
			}
			@Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
		});
	}
	
	private boolean checkNotNull() {
		return textFieldHoTen.getText() != null && !textFieldHoTen.getText().equalsIgnoreCase("") && textFieldSoDienThoai.getText() != null && !textFieldSoDienThoai.getText().equalsIgnoreCase("")&& jdcNgaySinh.getDate() != null ;
	}
	
	private boolean showDialog() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn muốn cập nhật dữ liệu hay không", "Thông báo", JOptionPane.YES_NO_OPTION);
		return dialogResult == JOptionPane.YES_OPTION;
	}
	
	public java.sql.Date covertDateToDateSql(Date d){
		return new java.sql.Date(d.getTime());
	}
}
