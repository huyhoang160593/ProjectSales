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

import controller.QuanLyMatHangController;
import javax.swing.ImageIcon;

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
		//Phím chưa được thêm chức năng nên chưa cho hiển thị, đỡ hỏi ahohi :>
		btnNhapKho.setVisible(true);
		
		JButton btnThayDoi = new JButton("~ Thay Đổi");
		btnThayDoi.setForeground(Color.WHITE);
		btnThayDoi.setFont(new Font("Arial", Font.PLAIN, 20));
		btnThayDoi.setBackground(new Color(42, 157, 143));
		
		JButton buttonDelete = new JButton("");
		buttonDelete.setIcon(new ImageIcon(MatHangPanel.class.getResource("/images/baseline_highlight_off_white_18dp.png")));
		buttonDelete.setForeground(Color.WHITE);
		buttonDelete.setFont(new Font("Arial", Font.PLAIN, 20));
		buttonDelete.setBackground(new Color(42, 157, 143));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
							.addComponent(buttonDelete, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnThayDoi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNhapKho, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd))
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE))
					.addGap(8))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThayDoi, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd)
						.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNhapKho, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonDelete, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
					.addGap(6))
		);
		setLayout(groupLayout);
		
		JLabel lblSecret = new JLabel();
		lblSecret.setVisible(false);
		
		QuanLyMatHangController controller = new QuanLyMatHangController(jpnView, lblSecret, btnThayDoi, btnAdd, btnNhapKho, buttonDelete, jtfSearch);
		controller.setDataToTable();
		controller.setEvent();
	}
}
