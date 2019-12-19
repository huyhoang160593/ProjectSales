package bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DanhMucBean {

	private String kind;	//Loại danh mục
    private JPanel jpn;		//Cái panel chứa tên danh mục
    private JLabel jlb;		//tên danh mục
    
    //Đây là phần để model của danh mục.Chính là phần này
    
	public DanhMucBean() {
    }
	
	public DanhMucBean(String kind, JPanel jpn, JLabel jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
    }
	
	public String getKind() {
        return kind;
    }
 
    public void setKind(String kind) {
        this.kind = kind;
    }
 
    public JPanel getJpn() {
        return jpn;
    }
 
    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }
 
    public JLabel getJlb() {
        return jlb;
    }
 
    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
	
	
}
