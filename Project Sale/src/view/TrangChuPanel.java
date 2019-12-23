package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.TrangChuController;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

public class TrangChuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNhanVienThang;
	private JTextField textFieldBestSellerItem;
	private JTextField textFieldBestLoyalCustomer;
	private JTextField textFieldSumThanhTien;
	private JTextField textFieldThang;

	/**
	 * Create the panel.
	 */
	public TrangChuPanel() {
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelEmpty = new JPanel();
		panelEmpty.setBackground(new Color(244, 163, 97));


		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelEmpty, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
						.addComponent(panelInfo, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
					.addGap(15))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelEmpty, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
					.addGap(7))
		);
		panelEmpty.setLayout(new MigLayout("", "[][grow][][][grow]", "[][][][][]"));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TrangChuPanel.class.getResource("/images/LogoMakr_0YGHvD.png")));
		panelEmpty.add(label, "cell 2 0");
		
		JLabel lblThang = new JLabel("Tháng");
		lblThang.setForeground(new Color(38, 70, 83));
		lblThang.setFont(new Font("Consolas", Font.BOLD, 17));
		panelEmpty.add(lblThang, "flowx,cell 2 1,alignx center");
		
		textFieldThang = new JTextField();
		textFieldThang.setFont(new Font("Consolas", Font.PLAIN, 17));
		panelEmpty.add(textFieldThang, "cell 2 1");
		textFieldThang.setEditable(false);
		
		JLabel lblNhanVienThang = new JLabel("Nhân viên của tháng:");
		lblNhanVienThang.setForeground(new Color(38, 70, 83));
		lblNhanVienThang.setFont(new Font("Consolas", Font.PLAIN, 17));
		panelEmpty.add(lblNhanVienThang, "cell 0 2,alignx trailing");
		
		textFieldNhanVienThang = new JTextField();
		textFieldNhanVienThang.setFont(new Font("Consolas", Font.PLAIN, 21));
		panelEmpty.add(textFieldNhanVienThang, "cell 1 2,growx");
		textFieldNhanVienThang.setColumns(10);
		textFieldNhanVienThang.setEditable(false);
		
		JLabel lblBestSellerItem = new JLabel("Mặt hàng bán chạy:");
		lblBestSellerItem.setForeground(new Color(38, 70, 83));
		lblBestSellerItem.setFont(new Font("Consolas", Font.PLAIN, 17));
		panelEmpty.add(lblBestSellerItem, "cell 3 2,alignx trailing");
		
		textFieldBestSellerItem = new JTextField();
		textFieldBestSellerItem.setFont(new Font("Consolas", Font.PLAIN, 21));
		panelEmpty.add(textFieldBestSellerItem, "cell 4 2,growx");
		textFieldBestSellerItem.setColumns(10);
		textFieldBestSellerItem.setEditable(false);
		
		JLabel lblBestLoyalCus = new JLabel("Khách hàng trung thành:");
		lblBestLoyalCus.setForeground(new Color(38, 70, 83));
		lblBestLoyalCus.setFont(new Font("Consolas", Font.PLAIN, 17));
		panelEmpty.add(lblBestLoyalCus, "cell 0 3,alignx trailing");
		
		textFieldBestLoyalCustomer = new JTextField();
		textFieldBestLoyalCustomer.setFont(new Font("Consolas", Font.PLAIN, 21));
		panelEmpty.add(textFieldBestLoyalCustomer, "cell 1 3,growx");
		textFieldBestLoyalCustomer.setColumns(10);
		textFieldBestLoyalCustomer.setEditable(false);
		
		JLabel lblSumThanhTien = new JLabel("Tổng doanh thu của tháng:");
		lblSumThanhTien.setForeground(new Color(38, 70, 83));
		lblSumThanhTien.setFont(new Font("Consolas", Font.PLAIN, 17));
		panelEmpty.add(lblSumThanhTien, "cell 3 3,alignx trailing");
		
		textFieldSumThanhTien = new JTextField();
		textFieldSumThanhTien.setFont(new Font("Consolas", Font.PLAIN, 21));
		panelEmpty.add(textFieldSumThanhTien, "cell 4 3,growx");
		textFieldSumThanhTien.setColumns(10);
		textFieldSumThanhTien.setEditable(false);
		
				
		JPanel panelKhachHang = new JPanel();
		panelInfo.add(panelKhachHang);
		panelKhachHang.setBackground(new Color(231, 111, 81));
		panelKhachHang.setLayout(new BorderLayout(0, 0));
				
		JLabel IconKhachHang = new JLabel("|");
		IconKhachHang.setForeground(Color.WHITE);
		IconKhachHang.setFont(new Font("Calibri Light", Font.PLAIN, 80));
		IconKhachHang.setIcon(new ImageIcon(TrangChuPanel.class.getResource("/images/KhachHangTrangChu.png")));
		panelKhachHang.add(IconKhachHang, BorderLayout.WEST);
				
		JLabel numberKhachHang = new JLabel("?");
		numberKhachHang.setForeground(new Color(255, 255, 255));
		numberKhachHang.setFont(new Font("Cambria Math", Font.BOLD, 50));
		panelKhachHang.add(numberKhachHang);
				
		JLabel lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhachHang.setForeground(new Color(255, 255, 255));
		lblKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
		panelKhachHang.add(lblKhachHang, BorderLayout.SOUTH);
				
				
		JPanel panelMatHang = new JPanel();
		panelInfo.add(panelMatHang);
		panelMatHang.setBackground(new Color(233, 197, 106));
		panelMatHang.setLayout(new BorderLayout(0, 0));
		
		JLabel IconMathang = new JLabel("|");
		IconMathang.setIcon(new ImageIcon(TrangChuPanel.class.getResource("/images/MatHangTrangChu.png")));
		IconMathang.setForeground(Color.WHITE);
		IconMathang.setFont(new Font("Calibri Light", Font.PLAIN, 80));
		panelMatHang.add(IconMathang, BorderLayout.WEST);
		
		JLabel numberMatHang = new JLabel("?");
		numberMatHang.setForeground(Color.WHITE);
		numberMatHang.setFont(new Font("Cambria Math", Font.BOLD, 50));
		panelMatHang.add(numberMatHang, BorderLayout.CENTER);
		
		JLabel lblMatHang = new JLabel("Mặt Hàng");
		lblMatHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatHang.setForeground(Color.WHITE);
		lblMatHang.setFont(new Font("Arial", Font.PLAIN, 20));
		panelMatHang.add(lblMatHang, BorderLayout.SOUTH);
		
		
		JPanel panelDonHang = new JPanel();
		panelInfo.add(panelDonHang);
		panelDonHang.setBackground(new Color(42, 157, 143));
		panelDonHang.setLayout(new BorderLayout(0, 0));
		
		JLabel IconDonHang = new JLabel("|");
		IconDonHang.setIcon(new ImageIcon(TrangChuPanel.class.getResource("/images/DonHangTrangChu.png")));
		IconDonHang.setForeground(Color.WHITE);
		IconDonHang.setFont(new Font("Calibri Light", Font.PLAIN, 80));
		panelDonHang.add(IconDonHang, BorderLayout.WEST);
		
		JLabel numberDonHang = new JLabel("?");
		numberDonHang.setForeground(Color.WHITE);
		numberDonHang.setFont(new Font("Cambria Math", Font.BOLD, 50));
		panelDonHang.add(numberDonHang, BorderLayout.CENTER);
		
		JLabel lblDonHang = new JLabel("Đơn Hàng");
		lblDonHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonHang.setForeground(Color.WHITE);
		lblDonHang.setFont(new Font("Arial", Font.PLAIN, 20));
		panelDonHang.add(lblDonHang, BorderLayout.SOUTH);
		
		setLayout(groupLayout);
		
		TrangChuController controller = new TrangChuController(numberKhachHang, numberMatHang, numberDonHang, textFieldThang);
		controller.setData();
		
	}
}
