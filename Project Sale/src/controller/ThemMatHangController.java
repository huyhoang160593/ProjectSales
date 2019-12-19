package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.ChiTietHoaDon;
import model.MatHang;
import service.MatHangService;
import service.MatHangServiceImpl;
import ultility.AutoCompletion;

public class ThemMatHangController {
	private JTextField textFieldMaMatHang;
	private JTextField textFieldSoLuong;
	private JTextField textFieldDonGia;
	private JTextField textFieldThanhTien;
	private JTextField textFieldLoaiHang;
	private JButton btnThemMatHang;
	private JComboBox<String> comboBox;
	
	//flag
	boolean flag = false;
	
	private MatHangService matHangService = null;
	
	ChiTietHoaDon chiTietHoaDon = null;
	
	public ThemMatHangController(JTextField textFieldMaMatHang, JTextField textFieldSoLuong, JTextField textFieldDonGia,
			JTextField textFieldThanhTien, JTextField textFieldLoaiHang, JButton btnThemMatHang,
			JComboBox<String> comboBox) {
		super();
		this.textFieldMaMatHang = textFieldMaMatHang;
		this.textFieldSoLuong = textFieldSoLuong;
		this.textFieldDonGia = textFieldDonGia;
		this.textFieldThanhTien = textFieldThanhTien;
		this.textFieldLoaiHang = textFieldLoaiHang;
		this.btnThemMatHang = btnThemMatHang;
		this.comboBox = comboBox;
		
		this.matHangService = new MatHangServiceImpl();
	}
	
	public void setData(ChiTietHoaDon chiTietHoaDon,JFrame frame) {
		
		this.chiTietHoaDon = chiTietHoaDon;
		
		textFieldMaMatHang.setEditable(false);
		textFieldLoaiHang.setEditable(false);
		textFieldDonGia.setEditable(false);
		textFieldThanhTien.setEditable(false);
		AutoCompletion.enable(comboBox);
		
		List<MatHang> listItem = matHangService.getList();
		for (MatHang mh : listItem) {
			comboBox.addItem(mh.getTen_mat_hang());
		}
		MatHang matHang = matHangService.getMatHangInfo(comboBox.getItemAt(0));
		System.out.println(comboBox.getName());
		textFieldMaMatHang.setText("#"+Integer.toString(matHang.getMa_mat_hang()));
		textFieldLoaiHang.setText(matHang.getLoai_hang());
		textFieldDonGia.setText(Integer.toString(matHang.getDon_gia()));
				
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				MatHang matHang = matHangService.getMatHangInfo(e.getItem().toString());
				textFieldMaMatHang.setText("#"+Integer.toString(matHang.getMa_mat_hang()));
				textFieldLoaiHang.setText(matHang.getLoai_hang());
				textFieldDonGia.setText(Integer.toString(matHang.getDon_gia()));				
			}
		});		
		
		textFieldSoLuong.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				try {
					if(!textFieldSoLuong.getText().equalsIgnoreCase("")) {
						int thanhtien = 0;
						int soluong = Integer.parseInt(textFieldSoLuong.getText());
						int dongia = Integer.parseInt(textFieldDonGia.getText());
						thanhtien = soluong * dongia;
						textFieldThanhTien.setText(Integer.toString(thanhtien));
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					if(!textFieldSoLuong.getText().equalsIgnoreCase("")) {
						int thanhtien = 0;
						int soluong = Integer.parseInt(textFieldSoLuong.getText());
						int dongia = Integer.parseInt(textFieldDonGia.getText());
						thanhtien = soluong * dongia;
						textFieldThanhTien.setText(Integer.toString(thanhtien));
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub	
				try {
					if(!textFieldSoLuong.getText().equalsIgnoreCase("")) {
						int thanhtien = 0;
						int soluong = Integer.parseInt(textFieldSoLuong.getText());
						int dongia = Integer.parseInt(textFieldDonGia.getText());
						thanhtien = soluong * dongia;
						textFieldThanhTien.setText(Integer.toString(thanhtien));
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		//set Event
		setEvent(frame);
		
	}
	
	public void setEvent(JFrame frame) {
		btnThemMatHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MatHang matHang = matHangService.getMatHangInfoByMaMatHang(Integer.parseInt((textFieldMaMatHang.getText().substring(1))));
				int ton_kho = matHang.getTon_kho();
				int so_luong = Integer.parseInt(textFieldSoLuong.getText());
				ton_kho -= so_luong;
				if(ton_kho < 0 ) {
					JOptionPane.showMessageDialog(null, "Số lượng tồn kho của bạn không đủ", "Lỗi mua quá tồn kho", JOptionPane.ERROR_MESSAGE);
					throw new ArithmeticException("Số lượng tồn kho của bạn không đủ");
				}
				// TODO Auto-generated method stub				
				chiTietHoaDon.setMa_mat_hang(Integer.parseInt((textFieldMaMatHang.getText().substring(1))));
				chiTietHoaDon.setDon_gia(Integer.parseInt(textFieldDonGia.getText()));
				chiTietHoaDon.setSo_luong(Integer.parseInt(textFieldSoLuong.getText()));
				chiTietHoaDon.setTen_mat_hang(comboBox.getSelectedItem().toString());
				chiTietHoaDon.setThanh_tien(Integer.parseInt(textFieldThanhTien.getText()));
				System.out.println(chiTietHoaDon.getMa_mat_hang()+"\t"+chiTietHoaDon.getMa_mat_hang()+"\t"+chiTietHoaDon.getSo_luong()+"\t"+chiTietHoaDon.getTen_mat_hang()+"\t"+chiTietHoaDon.getThanh_tien());
				frame.dispose();				
			}
		});
	}
}
