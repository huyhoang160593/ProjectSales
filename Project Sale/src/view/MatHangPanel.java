package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.QuanLyMatHangController;

public class MatHangPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField jtfSearch;

	/**
	 * Create the panel.
	 */
	public MatHangPanel() {
		jtfSearch = new JTextField();
		jtfSearch.setFont(new Font("Arial", Font.PLAIN, 20));
		jtfSearch.setColumns(10);
		
		JButton btnAdd = new JButton("+ Thêm mới");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(new Color(42, 157, 143));
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JPanel jpnView = new JPanel();
		jpnView.setBackground(Color.WHITE);
		
		JButton btnNhapKho = new JButton("+ Nhập kho");
		btnNhapKho.setForeground(Color.WHITE);
		btnNhapKho.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNhapKho.setBackground(new Color(42, 157, 143));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
							.addComponent(btnNhapKho, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd))
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE))
					.addGap(8))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNhapKho, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addComponent(jtfSearch))
					.addGap(18)
					.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
					.addGap(6))
		);
		setLayout(groupLayout);
		
		QuanLyMatHangController controller = new QuanLyMatHangController(jpnView, btnAdd, btnNhapKho, jtfSearch);
		controller.setDataToTable();
		controller.setEvent();
	}
}
