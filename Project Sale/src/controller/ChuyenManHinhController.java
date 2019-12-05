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
import view.TrangChuPanel;

public class ChuyenManHinhController {
	private JPanel root;
	private String kindSelected = "";
	
	List<DanhMucBean> listItem = null;
	
	public ChuyenManHinhController(JPanel jpnRoot) {
		this.root = jpnRoot;
	}	
	
	public void setEvent(List<DanhMucBean> listItem) {
		this.listItem = listItem;
		for (DanhMucBean item : listItem) {
			item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
		}
	}
	
	public void setDashboard(JPanel jpnItem, JLabel jlbItem) {
		// TODO Auto-generated method stub
		kindSelected = "TrangChinh";
	       jpnItem.setBackground(new Color(96, 100, 191));
	       jlbItem.setBackground(new Color(96, 100, 191));
	       root.removeAll();
	       root.setLayout(new BorderLayout());
	       root.add(new TrangChuPanel());
	       root.validate();
	       root.repaint();
	}
	
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
             default:
            	 node = new TrangChuPanel();
                 break;
        }
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(node);
        root.validate();
        root.repaint();
        setChangeBackgroud(kind);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			jpnItem.setBackground(new Color(96, 100, 191));
	        jlbItem.setBackground(new Color(96, 100, 191));
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(50,205,50));
                jlbItem.setBackground(new Color(50,205,50));
			}
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			kindSelected = kind;
	        jpnItem.setBackground(new Color(96, 100, 191));
	        jlbItem.setBackground(new Color(96, 100, 191));
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private void setChangeBackgroud(String kind) {
		for (DanhMucBean item : listItem) {
			if(item.getKind().equalsIgnoreCase(kind)) {
					item.getJpn().setBackground(new Color(96, 100, 191));
					item.getJlb().setBackground(new Color(96, 100, 191));
				}else {
					item.getJpn().setBackground(new Color(50,205,50));
					item.getJlb().setBackground(new Color(50,205,50));
				}
		}
	}
}
