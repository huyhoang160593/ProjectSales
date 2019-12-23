package controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import bean.DoanhThuThangBean;
import bean.HoaDonBean;
import service.ThongKeService;
import service.ThongKeServiceImpl;

public class QuanLyThongKeController {
	private ThongKeService thongKeService = null;
	public QuanLyThongKeController() {
		this.thongKeService = new ThongKeServiceImpl();
	}
	
	public void setDataToChart1(JPanel jpnItem) {
		List<HoaDonBean> listItem = thongKeService.getListByHoaDon();
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if (listItem!= null) {
			for (HoaDonBean hoaDonBean : listItem) {
				dataset.addValue(hoaDonBean.getSo_luong_don_hang(), "Đơn Hàng", hoaDonBean.getNgay_ban());
			}
		}
		
		JFreeChart orderChart = ChartFactory.createBarChart("Biểu đồ thống kê số lượng đơn hàng trong ngày".toUpperCase(), "Thời gian", "Số lượng", dataset,PlotOrientation.VERTICAL,false,true,false);
		
		ChartPanel chartPanel = new ChartPanel(orderChart);
		chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));
		
		jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
	}
	
	public void setDataToChart2(JPanel jpnItem) {
		List<DoanhThuThangBean> listItem = thongKeService.getListByDoanhThu();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if (listItem!= null) {
			for (DoanhThuThangBean item : listItem) {
				dataset.addValue(item.getDoanh_thu(), "Doanh Thu", item.getThang_ban());
			}
		}
		
		JFreeChart orderChart = ChartFactory.createLineChart("Biểu đồ thống kê doanh thu theo tháng".toUpperCase(), "Thời gian", "Doanh thu(vnđ)", dataset,PlotOrientation.VERTICAL,false,true,false);
		
		ChartPanel chartPanel = new ChartPanel(orderChart);
		chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));
		
		jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
	}
}
