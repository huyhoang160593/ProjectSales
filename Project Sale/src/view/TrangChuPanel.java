package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;

public class TrangChuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TrangChuPanel() {
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelEmpty = new JPanel();
		panelEmpty.setBackground(Color.ORANGE);


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

		
		JPanel panelKhachHang = new JPanel();
		panelInfo.add(panelKhachHang);
		panelKhachHang.setBackground(new Color(255, 69, 0));
		
		JLabel IconKhachHang = new JLabel("|");
		IconKhachHang.setForeground(new Color(255, 240, 245));
		IconKhachHang.setFont(new Font("Calibri Light", Font.PLAIN, 80));
		IconKhachHang.setIcon(new ImageIcon(TrangChuPanel.class.getResource("/images/KhachHangTrangChu.png")));
		panelKhachHang.add(IconKhachHang);
		
		JLabel numberKhachHang = new JLabel("?");
		numberKhachHang.setForeground(new Color(255, 255, 255));
		numberKhachHang.setFont(new Font("Arial", Font.BOLD, 40));
		panelKhachHang.add(numberKhachHang);
		
		JLabel lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setForeground(new Color(255, 255, 255));
		lblKhachHang.setFont(new Font("Arial", Font.BOLD, 30));
		panelKhachHang.add(lblKhachHang);
		
		JPanel panelMatHang = new JPanel();
		panelInfo.add(panelMatHang);
		panelMatHang.setBackground(new Color(65, 105, 225));
		
		JLabel IconMathang = new JLabel("|");
		IconMathang.setIcon(new ImageIcon(TrangChuPanel.class.getResource("/images/MatHangTrangChu.png")));
		IconMathang.setForeground(new Color(255, 240, 245));
		IconMathang.setFont(new Font("Calibri Light", Font.PLAIN, 80));
		panelMatHang.add(IconMathang);
		
		JLabel numberMatHang = new JLabel("?");
		numberMatHang.setForeground(Color.WHITE);
		numberMatHang.setFont(new Font("Arial", Font.BOLD, 40));
		panelMatHang.add(numberMatHang);
		
		JLabel lblMatHang = new JLabel("Mặt Hàng");
		lblMatHang.setForeground(Color.WHITE);
		lblMatHang.setFont(new Font("Arial", Font.BOLD, 30));
		panelMatHang.add(lblMatHang);
		
		JPanel panelDonHang = new JPanel();
		panelInfo.add(panelDonHang);
		panelDonHang.setBackground(new Color(50, 205, 50));
		
		JLabel IconDonHang = new JLabel("|");
		IconDonHang.setIcon(new ImageIcon(TrangChuPanel.class.getResource("/images/DonHangTrangChu.png")));
		IconDonHang.setForeground(new Color(255, 240, 245));
		IconDonHang.setFont(new Font("Calibri Light", Font.PLAIN, 80));
		panelDonHang.add(IconDonHang);
		
		JLabel numberDonHang = new JLabel("?");
		numberDonHang.setForeground(Color.WHITE);
		numberDonHang.setFont(new Font("Arial", Font.BOLD, 40));
		panelDonHang.add(numberDonHang);
		
		JLabel lblDonHang = new JLabel("Đơn Hàng");
		lblDonHang.setForeground(Color.WHITE);
		lblDonHang.setFont(new Font("Arial", Font.BOLD, 30));
		panelDonHang.add(lblDonHang);
		
		setLayout(groupLayout);
		
	}

}
