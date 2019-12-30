package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import bean.DanhMucBean;
import view.DonHangPanel;
import view.KhachHangPanel;
import view.MatHangPanel;
import view.NhanVienPanel;
import view.ThongKePanel;
import view.TrangChuPanel;

public class ChuyenManHinhController {
	private JPanel root;
	private String kindSelected = "";
	
	List<DanhMucBean> listItem = null;
	
	//Phương thức khởi tạo của class
	public ChuyenManHinhController(JPanel jpnRoot) {
		this.root = jpnRoot;
	}	
	
	//Tạo sự kiện cho danh mục mỗi khi click vào sẽ khởi tạo inner class Lable Event
	public void setEvent(List<DanhMucBean> listItem) {
		this.listItem = listItem;
		for (DanhMucBean item : listItem) {
			item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
		}
	}
	
	public void setDashboard(JPanel jpnItem, JLabel jlbItem) {
		// TODO Auto-generated method stub
		kindSelected = "TrangChinh";
	       jpnItem.setBackground(new Color(233, 197, 106));
	       jlbItem.setBackground(new Color(233, 197, 106));
	       root.removeAll();
	       root.setLayout(new BorderLayout());
	       root.add(new TrangChuPanel());
	       root.validate();
	       root.repaint();
	}
	
	//Inner class dùng cho sự kiện được đặt ở trên
	class LabelEvent implements MouseListener {
		
		private JPanel node;
		private String kind;		
		private JPanel jpnItem;
		private JLabel jlbItem;
		
		
		public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
			this.kind = kind;
			this.jpnItem = jpnItem;
			this.jlbItem = jlbItem;
		}

		//Mỗi khi click vào một nhãn thì phần panel bên phải sẽ được gán vào tương ứng
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			 switch (kind) {
             case "TrangChinh":
                 node = new TrangChuPanel();
                 break;
             case "KhachHang":
                 node = new KhachHangPanel();
                 break;
             // more
             case "NhanVien":
                 node = new NhanVienPanel();
                 break;
             case "MatHang":
                 node = new MatHangPanel();
                 break;
             case "DonHang":
                 node = new DonHangPanel();
                 break; 
             case "ThongKe":
            	 node = new ThongKePanel();
            	 break;
             default:
            	 node = new TrangChuPanel();
                 break;
        }
		
		//sửa lỗi không còn bị dính component ảo mỗi khi nhảy panel
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(node);
        root.validate();
        root.repaint();
        setChangeBackgroud(kind);
		}

		//các phương thức trang trí mỗi khi di chuột vào, di chuột ra, hoặc khi click chuột, nhả chuột sau khi click
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			jpnItem.setBackground(new Color(233, 197, 106));
	        jlbItem.setBackground(new Color(233, 197, 106));
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(42, 157, 143));
                jlbItem.setBackground(new Color(42, 157, 143));
			}
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			kindSelected = kind;
	        jpnItem.setBackground(new Color(244, 163, 97));
	        jlbItem.setBackground(new Color(244, 163, 97));
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			jpnItem.setBackground(new Color(42, 157, 143));
            jlbItem.setBackground(new Color(42, 157, 143));
		}
		
	}
	
	//Sau khi ấn xong thì sẽ đổi lại hết màu của các phím còn lại khác phím được chọn(làm cho màu chuyển toàn list reset)
	private void setChangeBackgroud(String kind) {
		for (DanhMucBean item : listItem) {
			if(item.getKind().equalsIgnoreCase(kind)) {
					item.getJpn().setBackground(new Color(233, 197, 106));
					item.getJlb().setBackground(new Color(233, 197, 106));
				}else {
					item.getJpn().setBackground(new Color(42, 157, 143));
					item.getJlb().setBackground(new Color(42, 157, 143));
				}
		}
	}
}
