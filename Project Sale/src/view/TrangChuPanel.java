package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TrangChuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TrangChuPanel() {
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 69, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(65, 105, 225));
		
		JLabel label_1 = new JLabel("|");
		label_1.setIcon(new ImageIcon(TrangChuPanel.class.getResource("/images/baseline_store_mall_directory_white_24dp.png")));
		label_1.setForeground(new Color(255, 240, 245));
		label_1.setFont(new Font("Arial", Font.BOLD, 30));
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("?");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(label_2);
		
		JLabel lblMtHng = new JLabel("Mặt Hàng");
		lblMtHng.setForeground(Color.WHITE);
		lblMtHng.setFont(new Font("Arial", Font.BOLD, 45));
		panel_1.add(lblMtHng);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(50, 205, 50));
		
		JLabel label_4 = new JLabel("|");
		label_4.setIcon(new ImageIcon(TrangChuPanel.class.getResource("/images/baseline_add_shopping_cart_white_24dp.png")));
		label_4.setForeground(new Color(255, 240, 245));
		label_4.setFont(new Font("Arial", Font.BOLD, 30));
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("?");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Arial", Font.BOLD, 20));
		panel_2.add(label_5);
		
		JLabel lblnHng = new JLabel("Đơn Hàng");
		lblnHng.setForeground(Color.WHITE);
		lblnHng.setFont(new Font("Arial", Font.BOLD, 45));
		panel_2.add(lblnHng);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 165, 0));
		
		JLabel lblNewLabel = new JLabel("|");
		lblNewLabel.setForeground(new Color(255, 240, 245));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setIcon(new ImageIcon(TrangChuPanel.class.getResource("/images/baseline_account_circle_white_24dp.png")));
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("?");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(label);
		
		JLabel lblNewLabel_3 = new JLabel("Khách Hàng");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 45));
		panel.add(lblNewLabel_3);


		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)))
					.addGap(57))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
					.addGap(9))
		);
		setLayout(groupLayout);
		
	}

}
