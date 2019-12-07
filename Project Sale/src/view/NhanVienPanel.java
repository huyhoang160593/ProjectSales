package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
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
		btnAdd.setBackground(new Color(0, 255, 0));
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JPanel jpnView = new JPanel();
		jpnView.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jtfSreach, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
							.addComponent(btnAdd))
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE))
					.addGap(8))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdd)
						.addComponent(jtfSreach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
					.addGap(6))
		);
		setLayout(groupLayout);
		
		QuanLyNhanVienController controller = new QuanLyNhanVienController(jpnView, btnAdd, jtfSreach);
		controller.setDataToTable();
		
	}

}
