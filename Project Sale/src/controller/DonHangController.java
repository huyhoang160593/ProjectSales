package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.ChiTietHoaDon;
import model.DonHang;
import model.KhachHang;
import model.MatHang;
import model.NhanVien;
import service.DonHangService;
import service.DonHangServiceImpl;
import service.KhachHangService;
import service.KhachHangServiceImpl;
import service.MatHangService;
import service.MatHangServiceImpl;
import service.NhanVienService;
import service.NhanVienServiceImpl;
import ultility.AutoCompletion;
import ultility.ClassTableModel;
import view.DonHangMatHangJFrame;

public class DonHangController {
	private JButton btnSubmit;
	private JTextField textFieldMaHoaDon;
	private JTextField textFieldNgayBan;
	private JTextField textFieldThanhTien;
	private JComboBox<String> comboNhanVien;
	private JTextField textFieldTenKhachHang;
	private JComboBox<String> comboBoxSDTKhachHang;

	private JLabel lblMgs;
	private JLabel lblSecret;
	private JButton btnThemMatHang;
	private JButton btnXoaMatHang;
	
	private JPanel panelTable;
	
	private DonHang donHang = null;
	
	private DonHangService donHangService = null;
	private KhachHangService khachHangService = null;
	private NhanVienService nhanVienService = null;
	private MatHangService matHangService = null;
	
	private List<ChiTietHoaDon> listOrder = null;	
	private ChiTietHoaDon chiTietHoaDon = null;
	
	private String[] COLUMN = {"Tên mặt hàng","Đơn giá","Số lượng","Thành tiền"};
	private ClassTableModel classTableModel = null;

	public DonHangController(JButton btnSubmit, JTextField textFieldMaHoaDon, JComboBox<String> comboNhanVien,
			JTextField textFieldTenKhachHang,JComboBox<String> comboBoxSDTKhachHang, JTextField textFieldNgayBan,JTextField textFieldThanhTien, JLabel lblMgs,JLabel lblSecret, JButton btnThemMatHang,
			JButton btnXoaMatHang, JPanel panelTable) {
		this.btnSubmit = btnSubmit;
		this.textFieldMaHoaDon = textFieldMaHoaDon;
		this.comboNhanVien = comboNhanVien;
		this.textFieldTenKhachHang = textFieldTenKhachHang;
		this.comboBoxSDTKhachHang = comboBoxSDTKhachHang;
		this.textFieldNgayBan = textFieldNgayBan;
		this.textFieldThanhTien = textFieldThanhTien;
		this.lblMgs = lblMgs;
		this.lblSecret = lblSecret;
		this.btnThemMatHang = btnThemMatHang;
		this.btnXoaMatHang = btnXoaMatHang;
		
		this.donHangService = new DonHangServiceImpl();
		this.khachHangService = new KhachHangServiceImpl();
		this.nhanVienService = new NhanVienServiceImpl();
		this.matHangService = new MatHangServiceImpl();
		
		this.panelTable = panelTable;
		this.classTableModel = new ClassTableModel();
		this.listOrder = new ArrayList<ChiTietHoaDon>();
		this.chiTietHoaDon = new ChiTietHoaDon();
	}
	
	
	public void setDataToTable() {
		int thanhTien = 0;
		DefaultTableModel model = classTableModel.setTableChiTietHoaDon(listOrder, COLUMN);	
		JTable table = new JTable(model);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 10));
        table.getTableHeader().setPreferredSize(new Dimension(50, 25));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        panelTable.removeAll();
        panelTable.setLayout(new CardLayout());
        panelTable.add(scroll);
        panelTable.validate();
        panelTable.repaint();
        //tableEvent
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		// TODO Auto-generated method stub
        		if(e.getClickCount() == 1 && table.getSelectedRow() != -1)
        		lblSecret.setText(Integer.toString(table.getSelectedRow()));
        	}
		});
        
        if(table.getRowCount()!=0) {
        	for (int i = 0; i < table.getRowCount(); i++) {
				thanhTien += (int)table.getValueAt(i, 3);
				textFieldThanhTien.setText(Integer.toString(thanhTien));
			}
        } else {
        	textFieldThanhTien.setText("0");
        }
        		
	}
	
	
	public void event(JFrame frame) {
		//frame details
		donHang = new DonHang();
		textFieldMaHoaDon.setText("#"+donHang.getMa_hoa_don());
		textFieldNgayBan.setText(LocalDate.now().toString());	
		AutoCompletion.enable(comboBoxSDTKhachHang);
		textFieldTenKhachHang.setEditable(false);
		AutoCompletion.enable(comboNhanVien);	
		
		List<NhanVien> listNhanViens = nhanVienService.getList();
		for(NhanVien nhanVien : listNhanViens) {
			comboNhanVien.addItem(nhanVien.getTen_nhan_vien());
		}
		
		List<KhachHang> listKhachHangs = khachHangService.getList();
		for(KhachHang khachHang : listKhachHangs) {
			comboBoxSDTKhachHang.addItem(khachHang.getSo_dien_thoai());
		}
		textFieldTenKhachHang.setText(listKhachHangs.get(0).getHo_ten());
		//Chọn khách hàng theo số điện thoại sẽ thấy tên
		
		comboBoxSDTKhachHang.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				KhachHang khachHang = khachHangService.getKhachHangInfoBySDT(comboBoxSDTKhachHang.getSelectedItem().toString());
				textFieldTenKhachHang.setText(khachHang.getHo_ten());
			}
			
		});
		//btnThemMatHang
		btnThemMatHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMgs.setText("");
				JFrame themMathangJFrame = new DonHangMatHangJFrame(chiTietHoaDon);
				themMathangJFrame.setVisible(true);
				themMathangJFrame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						int count=0;
						for(ChiTietHoaDon cthd:listOrder) {
							if(cthd.getMa_mat_hang()==chiTietHoaDon.getMa_mat_hang()) {
								int so_luong_moi = cthd.getSo_luong() + chiTietHoaDon.getSo_luong();
								cthd.setSo_luong(so_luong_moi);
								cthd.setThanh_tien(so_luong_moi*cthd.getDon_gia());
								break;
							}
							count++;
						}
						if(count<listOrder.size()) {
							for (ChiTietHoaDon chiTietHoaDon : listOrder) {
								MatHang matHang = matHangService.getMatHangInfoByMaMatHang(chiTietHoaDon.getMa_mat_hang());
								if(chiTietHoaDon.getSo_luong()>matHang.getTon_kho()) {
									lblMgs.setForeground(new Color(255, 0, 0));
									lblMgs.setText(matHang.getTen_mat_hang()+" không thể mua vì quá số lượng tồn kho");
								}
							}
							setDataToTable();
						} else {
							listOrder.add(chiTietHoaDon);
							setDataToTable();
							chiTietHoaDon = new ChiTietHoaDon();
						}					
					}
				});
				
			}
		});
		// Xoá mặt hàng
			btnXoaMatHang.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					listOrder.remove(Integer.parseInt(lblSecret.getText()));
					int count = 0;
					for (ChiTietHoaDon chiTietHoaDon : listOrder) {
						MatHang matHang = matHangService.getMatHangInfoByMaMatHang(chiTietHoaDon.getMa_mat_hang());
						if(chiTietHoaDon.getSo_luong()>matHang.getTon_kho()) {
							lblMgs.setForeground(new Color(255, 0, 0));
							lblMgs.setText(matHang.getTen_mat_hang()+" không thể mua vì quá số lượng tồn kho");
							count++;
						}
					}
					if (count == 0) lblMgs.setText("");
					
					setDataToTable();
				}
			});
			
		//Lưu đơn hàng
			btnSubmit.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					try {
						if(!lblMgs.getText().trim().equals("")) {
							throw new Exception(lblMgs.getText());
						}
						if(listOrder.size() == 0) {
							lblMgs.setForeground(new Color(255, 0, 0));
							lblMgs.setText("Đơn hàng của bạn đang bị trống");
							throw new NullPointerException(lblMgs.getText());
						}
						KhachHang khachHang = khachHangService.getKhachHangInfo(textFieldTenKhachHang.getText().toString());
						NhanVien nhanVien = nhanVienService.getNhanVienInfo(comboNhanVien.getSelectedItem().toString());
						donHang.setMa_khach_hang(khachHang.getMa_khach_hang());
						donHang.setMa_nhan_vien(nhanVien.getMa_nhan_vien());
						donHang.setNgay_ban(LocalDateTime.now());
						donHang.setThanh_tien(Integer.parseInt(textFieldThanhTien.getText()));
						if(showDialog()) {
							int lastID = donHangService.create(donHang);
							if (lastID != 0) {
								donHang.setMa_hoa_don(lastID);
								textFieldMaHoaDon.setText("#"+donHang.getMa_hoa_don());
								System.out.println("Số lượng đơn hàng: "+ listOrder.size());
								for (ChiTietHoaDon chiTietHoaDon : listOrder) {
									chiTietHoaDon.setMa_hoa_don(lastID);
									System.out.println(chiTietHoaDon.getMa_hoa_don()+"\t"+chiTietHoaDon.getMa_mat_hang()+"\t"+chiTietHoaDon.getSo_luong()+"\t"+chiTietHoaDon.getThanh_tien());
									donHangService.createDetailOrder(chiTietHoaDon);
									MatHang matHang = matHangService.getMatHangInfoByMaMatHang(chiTietHoaDon.getMa_mat_hang());
									System.out.println(matHang.getMa_mat_hang()+"\t"+matHang.getTen_mat_hang()+"\t"+matHang.getTon_kho()+"\t"+matHang.getThoi_gian_nhap());
									int ton_kho = matHang.getTon_kho();
									int so_luong_mua = chiTietHoaDon.getSo_luong();
									ton_kho -= so_luong_mua;
									matHang.setTon_kho(ton_kho);
									matHang.setThoi_gian_nhap(LocalDateTime.now());
									int done = matHangService.createOrUpdate(matHang);
									lblSecret.setText(Integer.toString(done));
									System.out.println("Mã đơn hàng thay đổi: " + matHang.getMa_mat_hang());
								}
								lblMgs.setForeground(new Color(0, 255, 0));
								lblMgs.setText("Cập nhật đơn hàng thành công...");
								frame.dispose();
							} else {
								lblMgs.setForeground(new Color(255, 0, 0));
								lblMgs.setText("Có lỗi xảy ra, vui lòng kiểm tra lại!");
							}
						}
					} catch (Exception e2) {
						// TODO: handle exception
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
	
	private boolean showDialog() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật dữ liệu hay không", "Thông báo", JOptionPane.YES_NO_OPTION);
		return dialogResult == JOptionPane.YES_OPTION;
	}
}
