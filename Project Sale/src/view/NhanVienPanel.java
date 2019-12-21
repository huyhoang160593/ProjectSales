package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.QuanLyNhanVienController;

public class NhanVienPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtfSreach;

	/**
	 * Create the panel.
	 */
	public NhanVienPanel() {
		jtfSreach = new JTextField();
		jtfSreach.setFont(new Font("Arial", Font.PLAIN, 20));
		jtfSreach.setColumns(10);
		
		JButton btnAdd = new JButton("+ Thêm mới");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(new Color(42, 157, 143));
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JPanel jpnView = new JPanel();
		jpnView.setBackground(Color.WHITE);
		
		JButton btnThayDoi = new JButton("~ Thay đổi");
		btnThayDoi.setForeground(Color.WHITE);
		btnThayDoi.setFont(new Font("Arial", Font.PLAIN, 20));
		btnThayDoi.setBackground(new Color(42, 157, 143));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jtfSreach, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
							.addComponent(btnThayDoi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd))
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE))
					.addGap(8))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnThayDoi, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addComponent(jtfSreach))
					.addGap(18)
					.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
					.addGap(6))
		);
		setLayout(groupLayout);
		
		JLabel lblSecret = new JLabel();
		lblSecret.setVisible(false);
		
		QuanLyNhanVienController controller = new QuanLyNhanVienController(jpnView, lblSecret, btnThayDoi, btnAdd, jtfSreach);
		controller.setDataToTable();
		controller.setEvent();
		
	}

}
