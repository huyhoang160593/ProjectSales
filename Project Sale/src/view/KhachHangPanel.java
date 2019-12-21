package view;

import javax.swing.JPanel;

import controller.QuanLyKhachHangController;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;

public class KhachHangPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtfSearch;

	/**
	 * Create the panel.
	 */
	public KhachHangPanel() {
		
		jtfSearch = new JTextField();
		jtfSearch.setFont(new Font("Arial", Font.PLAIN, 20));
		jtfSearch.setColumns(10);
		
		JButton btnAdd = new JButton("+ Thêm mới");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(new Color(42, 157, 143));
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JPanel jpnView = new JPanel();
		jpnView.setBackground(Color.WHITE);
		
		JButton buttonThayDoi = new JButton("~ Thay đổi");
		buttonThayDoi.setForeground(Color.WHITE);
		buttonThayDoi.setFont(new Font("Arial", Font.PLAIN, 20));
		buttonThayDoi.setBackground(new Color(42, 157, 143));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
							.addComponent(buttonThayDoi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd))
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE))
					.addGap(5))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(buttonThayDoi, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addComponent(jtfSearch))
					.addGap(20)
					.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
					.addGap(5))
		);
		setLayout(groupLayout);
		
		JLabel lblSecret = new JLabel();
		lblSecret.setVisible(false);
		
		QuanLyKhachHangController controller = new QuanLyKhachHangController(jpnView, lblSecret, btnAdd, buttonThayDoi, jtfSearch);
		controller.setDataToTable();
		controller.setEvent();
	}
}
