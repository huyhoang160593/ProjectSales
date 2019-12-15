package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JButton;
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

import service.MatHangService;
import service.MatHangServiceImpl;
import ultility.ClassTableModel;
import view.MatHangJFrame;
import model.MatHang;

public class QuanLyMatHangController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JButton btnNhapKho;
    private JTextField jtfSearch;
 
    private ClassTableModel classTableModel = null;
    
    private final String[] COLUMNS = {"Mã mặt hàng","Tên mặt hàng","Loại hàng", "Đơn giá",
            "Tồn kho", "Có sẵn", "Thời gian nhập"};
     
    private MatHangService matHangService = null;
    
    private TableRowSorter<TableModel> rowSorter = null;

	public QuanLyMatHangController(JPanel jpnView, JButton btnAdd, JButton btnNhapKho, JTextField jtfSearch) {
		this.jpnView = jpnView;
		this.btnAdd = btnAdd;
		this.btnNhapKho = btnNhapKho;
		this.jtfSearch = jtfSearch;
		
		this.classTableModel = new ClassTableModel();
		
		this.matHangService = new MatHangServiceImpl();
	}
	
	public void setDataToTable() {
		List<MatHang> listItem = matHangService.getList();
		DefaultTableModel model = classTableModel.setTableMatHang(listItem, COLUMNS);
		JTable table = new JTable(model);
		 
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
 
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
 
            @Override
            public void removeUpdate(DocumentEvent e) {
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
        
        //addMouseListener ở đây
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		// TODO Auto-generated method stub
        		if(e.getClickCount() == 2 && table.getSelectedRow() != -1) {
        			DefaultTableModel model = (DefaultTableModel) table.getModel();
        			int selectedRowIndex = table.getSelectedRow();
        			
        			selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
        			
        			MatHang matHang = new MatHang();
        			matHang.setMa_mat_hang((int)model.getValueAt(selectedRowIndex, 0));
        			matHang.setTen_mat_hang(model.getValueAt(selectedRowIndex, 1).toString());
        			matHang.setLoai_hang(model.getValueAt(selectedRowIndex, 2).toString());
        			matHang.setDon_gia((int)model.getValueAt(selectedRowIndex, 3));
        			matHang.setTon_kho((int)model.getValueAt(selectedRowIndex, 4));
        			matHang.setCo_san((boolean)model.getValueAt(selectedRowIndex, 5));
        			matHang.setThoi_gian_nhap(LocalDateTime.now());
        			
        			MatHangJFrame frame = new MatHangJFrame(matHang);
        			frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setTitle("Thông tin khách hàng");
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
    
	//setEvent() ở đây
	public void setEvent() {
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MatHangJFrame(new MatHang()).setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(0,200,83));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(new Color(100,221,23));
			}
		});
		
		btnNhapKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//phần này còn thiếu
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNhapKho.setBackground(new Color(0,200,83));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNhapKho.setBackground(new Color(100,221,23));
			}
		});
	}
	
}