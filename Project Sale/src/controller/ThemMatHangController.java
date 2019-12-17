package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.MatHang;
import service.MatHangService;
import service.MatHangServiceImpl;

public class ThemMatHangController {
	private JTextField textFieldMaMatHang;
	private JTextField textFieldSoLuong;
	private JTextField textFieldDonGia;
	private JTextField textFieldThanhTien;
	private JTextField textFieldLoaiHang;
	private JButton btnThemMatHang;
	private JComboBox<String> comboBox;
	
	private MatHangService matHangService = null;
	
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
	
	public void setData() {
		List<MatHang> listItem = matHangService.getList();
		for (MatHang mh : listItem) {
			comboBox.addItem(mh.getTen_mat_hang());
		}
		MatHang matHang = matHangService.getMatHangInfo(comboBox.getItemAt(0));
		System.out.println(comboBox.getName());
		textFieldMaMatHang.setText(Integer.toString(matHang.getMa_mat_hang()));
		textFieldLoaiHang.setText(matHang.getLoai_hang());
		textFieldDonGia.setText(Integer.toString(matHang.getDon_gia()));
				
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				MatHang matHang = matHangService.getMatHangInfo(e.getItem().toString());
				textFieldMaMatHang.setText(Integer.toString(matHang.getMa_mat_hang()));
				textFieldLoaiHang.setText(matHang.getLoai_hang());
				textFieldDonGia.setText(Integer.toString(matHang.getDon_gia()));				
			}
		});
		
		textFieldSoLuong.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
