package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.DonHang;
import service.DonHangService;
import service.DonHangServiceImpl;
import ultility.ClassTableModel;
import view.DonHangInfo;
import view.DonHangJFrame;

public class QuanLyDonHangController {
	private JPanel jpnView;
	private JButton btnAdd;
	private JTextField jtfSearch;
	
	private ClassTableModel classTableModel = null;
	
	private final String[] COLUMNS = {"Mã hoá đơn", "Tên khách hàng","Tên nhân viên","Ngày bán"};
	
	private DonHangService donHangService = null;
	
	private TableRowSorter<TableModel> rowSorter = null;

	public QuanLyDonHangController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
		this.jpnView = jpnView;
		this.btnAdd = btnAdd;
		this.jtfSearch = jtfSearch;
		
		this.classTableModel = new ClassTableModel();
		
		this.donHangService = new DonHangServiceImpl();
	}
	
	//đổ dữ liệu vào bảng 
	public void setDataToTable() { // phương thức này có thể gọi lại nhiều lần để cập nhật lại bảng
		List<DonHang> listItem = donHangService.getList();	//list item lấy ra từ csdl
		DefaultTableModel model = classTableModel.setTableDonHang(listItem, COLUMNS);	// khởi tạo model với list đã có và tên cột tương ứng
		JTable table = new JTable(model);	//add vào JTabel mới
		
		//tạo biến sắp xếp theo dòng từ dãy các dòng của bảng(lỗi phần mã sinh(mã đơn hàng))
		rowSorter = new TableRowSorter<>(table.getModel());
		
		//đưa nó ngược trở lại table
		table.setRowSorter(rowSorter);
		
		//Thanh tìm kiếm đa năng trong bảng
		jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { //thanh tìm kiếm được thêm 1 kí tự
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {	//xét nếu thanh tìm kiếm chống
                    rowSorter.setRowFilter(null);	//bảng giữ nguyên như ban đầu
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text)); //Sử dụng regex để bắt kết quả không phân biệt hoa thường ("(?i)")- cờ GMI
                }
            }
 
            @Override
            public void removeUpdate(DocumentEvent e) {	//thanh tìm kiếm bị xoá 1 kí tự
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
 
            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
		
		//Mỗi khi click đúp chuột vào đơn hàng tuỳ ý sẽ có thể xem được chi tiết đơn hàng
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() == 2 && table.getSelectedRow() != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					
					selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
					
					DonHang donHang = donHangService.getOrderInfo((int)model.getValueAt(selectedRowIndex, 0));
					donHang.setTen_khach_hang((model.getValueAt(selectedRowIndex, 1).toString()));
					donHang.setTen_nhan_vien((model.getValueAt(selectedRowIndex, 2).toString()));	
					JFrame frame = new DonHangInfo(donHang);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setTitle("Thông tin chi tiết đơn hàng");
					frame.setVisible(true);
				}
			}
		});
		//design
		table.getColumnModel().getColumn(0).setMaxWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		table.getTableHeader().setPreferredSize(new Dimension(100,50));
		table.setRowHeight(50);
		table.validate();
		table.repaint();
		
		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(table);
		scroll.setPreferredSize(new Dimension(1350, 400));
		jpnView.removeAll();
		jpnView.setLayout(new CardLayout());
		jpnView.add(scroll);
		jpnView.validate();
		jpnView.repaint();
	}
	
	public void setEvent() {	//trang trí nút thêm và mở frame thêm nếu được yêu cầu(click chuột vào)
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new DonHangJFrame(new DonHang());
				frame.setVisible(true);
				frame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						setDataToTable();
					}
				});
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(38, 70, 83));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(new Color(42, 157, 143));
			}
		});
	}
}
