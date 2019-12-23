package view;

import javax.swing.JPanel;

import controller.QuanLyThongKeController;

import java.awt.GridLayout;

public class ThongKePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ThongKePanel() {
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel jpnChart1 = new JPanel();
		add(jpnChart1);
		
		JPanel jpnChart2 = new JPanel();
		add(jpnChart2);

		QuanLyThongKeController controller = new QuanLyThongKeController();
		controller.setDataToChart1(jpnChart1);
		controller.setDataToChart2(jpnChart2);
	}

}
