package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import bean.DanhMucBean;
import controller.ChuyenManHinhController;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class MainJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel jpnView;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public MainJFrame(boolean flag) {
		setTitle("MANAGEDSILY-Quản lý đơn hàng của bạn dễ dàng hơn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(38, 70, 83));
		setContentPane(contentPane);
		
		JPanel jpnMenu = new JPanel();
		jpnMenu.setBackground(new Color(38, 70, 83));
		
		jpnView = new JPanel();
		FlowLayout fl_jpnView = (FlowLayout) jpnView.getLayout();
		fl_jpnView.setVgap(0);
		fl_jpnView.setHgap(0);
		jpnView.setBackground(Color.DARK_GRAY);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(jpnMenu, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE))
		);
		
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(jpnView, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
						.addComponent(jpnMenu, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE))
					)
		);
		
		
		JPanel panelName = new JPanel();
		panelName.setBackground(new Color(231, 111, 81));
		
		JPanel jpnTrangChu = new JPanel(); 
		jpnTrangChu.setBorder(new LineBorder(new Color(233, 197, 106), 3, true));
		jpnTrangChu.setBackground(new Color(42, 157, 143));
		
		JPanel jpnKhachHang = new JPanel();
		jpnKhachHang.setBorder(new LineBorder(new Color(233, 197, 106), 3, true));
		jpnKhachHang.setBackground(new Color(42, 157, 143));
		jpnKhachHang.setLayout(new BorderLayout(0, 0));
		
		JPanel jpnNhanVien = new JPanel();
		jpnNhanVien.setBorder(new LineBorder(new Color(233, 197, 106), 3, true));
		jpnNhanVien.setBackground(new Color(42, 157, 143));
		jpnNhanVien.setLayout(new BorderLayout(0, 0));
		
		JPanel jpnMatHang = new JPanel();
		jpnMatHang.setBorder(new LineBorder(new Color(233, 197, 106), 3, true));
		jpnMatHang.setBackground(new Color(42, 157, 143));
		jpnMatHang.setLayout(new BorderLayout(0, 0));
		
		JPanel jpnDonHang = new JPanel();
		jpnDonHang.setBackground(new Color(42, 157, 143));
		jpnDonHang.setBorder(new LineBorder(new Color(233, 197, 106), 3, true));
		jpnDonHang.setLayout(new BorderLayout(0, 0));
		
		JPanel jpnThongKe = new JPanel();
		jpnThongKe.setBorder(new LineBorder(new Color(233, 197, 106), 3, true));
		jpnThongKe.setBackground(new Color(42, 157, 143));
		jpnThongKe.setLayout(new BorderLayout(0, 0));
		
		GroupLayout gl_jpnMenu = new GroupLayout(jpnMenu);
		gl_jpnMenu.setHorizontalGroup(
			gl_jpnMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnMenu.createSequentialGroup()
					.addGroup(gl_jpnMenu.createParallelGroup(Alignment.LEADING)
						.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_jpnMenu.createSequentialGroup()
							.addContainerGap()
							.addComponent(jpnTrangChu, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnMenu.createSequentialGroup()
							.addContainerGap()
							.addComponent(jpnKhachHang, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnMenu.createSequentialGroup()
							.addContainerGap()
							.addComponent(jpnNhanVien, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnMenu.createSequentialGroup()
							.addContainerGap()
							.addComponent(jpnMatHang, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnMenu.createSequentialGroup()
							.addContainerGap()
							.addComponent(jpnDonHang, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnMenu.createSequentialGroup()
							.addContainerGap()
							.addComponent(jpnThongKe, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		gl_jpnMenu.setVerticalGroup(
			gl_jpnMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnMenu.createSequentialGroup()
					.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jpnTrangChu, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jpnKhachHang, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jpnNhanVien, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jpnMatHang, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jpnDonHang, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jpnThongKe, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		
		JLabel jlbThongKe = new JLabel("Thống kê");
		jlbThongKe.setIcon(new ImageIcon(MainJFrame.class.getResource("/images/baseline_bar_chart_white_24dp.png")));
		jlbThongKe.setForeground(Color.WHITE);
		jlbThongKe.setFont(new Font("Arial", Font.BOLD, 14));
		jpnThongKe.add(jlbThongKe, BorderLayout.CENTER);
		
		JLabel jlbDonHang = new JLabel("Quản lý đơn hàng");
		jlbDonHang.setIcon(new ImageIcon(MainJFrame.class.getResource("/images/baseline_add_shopping_cart_white_24dp.png")));
		jlbDonHang.setForeground(new Color(255, 255, 255));
		jlbDonHang.setFont(new Font("Arial", Font.BOLD, 14));
		jpnDonHang.add(jlbDonHang, BorderLayout.CENTER);
		
		JLabel jlbMatHang = new JLabel("Quản lý mặt hàng");
		jlbMatHang.setIcon(new ImageIcon(MainJFrame.class.getResource("/images/baseline_store_mall_directory_white_24dp.png")));
		jlbMatHang.setForeground(new Color(255, 255, 255));
		jlbMatHang.setFont(new Font("Arial", Font.BOLD, 14));
		jpnMatHang.add(jlbMatHang, BorderLayout.CENTER);
		
		JLabel jlbNhanVien = new JLabel("Quản lý nhân viên");
		jlbNhanVien.setIcon(new ImageIcon(MainJFrame.class.getResource("/images/baseline_face_white_24dp.png")));
		jlbNhanVien.setForeground(new Color(255, 255, 255));
		jlbNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		jpnNhanVien.add(jlbNhanVien, BorderLayout.CENTER);
		
		JLabel jlbKhachHang = new JLabel("Quản lý khách hàng");
		jlbKhachHang.setIcon(new ImageIcon(MainJFrame.class.getResource("/images/baseline_account_circle_white_24dp.png")));
		jlbKhachHang.setFont(new Font("Arial", Font.BOLD, 14));
		jlbKhachHang.setForeground(new Color(255, 255, 255));
		jpnKhachHang.add(jlbKhachHang, BorderLayout.CENTER);
		jpnTrangChu.setLayout(new BorderLayout(0, 0));
		
		JLabel jlbTrangChu = new JLabel("Màn hình chính");
		jlbTrangChu.setIcon(new ImageIcon(MainJFrame.class.getResource("/images/baseline_devices_white_24dp.png")));
		jlbTrangChu.setFont(new Font("Arial", Font.BOLD, 14));
		jlbTrangChu.setForeground(new Color(255, 255, 255));
		jpnTrangChu.add(jlbTrangChu, BorderLayout.CENTER);
		panelName.setLayout(new BorderLayout(0, 0));
		
		JLabel lblName = new JLabel("QUẢN LÝ ĐƠN HÀNG");
		lblName.setIcon(new ImageIcon(MainJFrame.class.getResource("/images/baseline_supervisor_account_white_24dp.png")));
		lblName.setFont(new Font("Arial", Font.BOLD, 16));
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panelName.add(lblName);
		jpnMenu.setLayout(gl_jpnMenu);
		contentPane.setLayout(gl_contentPane);
		
		List<DanhMucBean> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new DanhMucBean("TrangChinh", jpnTrangChu, jlbTrangChu));
        listDanhMuc.add(new DanhMucBean("KhachHang", jpnKhachHang, jlbKhachHang));
        listDanhMuc.add(new DanhMucBean("NhanVien", jpnNhanVien, jlbNhanVien));
        listDanhMuc.add(new DanhMucBean("MatHang", jpnMatHang, jlbMatHang));
        listDanhMuc.add(new DanhMucBean("DonHang", jpnDonHang, jlbDonHang));
        listDanhMuc.add(new DanhMucBean("ThongKe", jpnThongKe, jlbThongKe));
        
        //Phần phát hiện xem liệu tài khoản đăng nhập vào frame là nhân viên hay chủ nếu là nhân viên sẽ bị mất các tính năng dưới đây
        if(!flag) {
        	jpnNhanVien.setVisible(false);
        	jpnThongKe.setVisible(false);
        }
 
        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        controller.setDashboard(jpnTrangChu, jlbTrangChu);
        controller.setEvent(listDanhMuc);
	}
}
