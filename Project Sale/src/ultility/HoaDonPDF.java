package ultility;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import bean.HoaDonInfoBean;
import model.ChiTietHoaDon;
public class HoaDonPDF {
	
	public HoaDonPDF(HoaDonInfoBean hoaDonInfo) {
		Document document = new Document();
		try {
			//Câu lệnh đăng kí font chữ dùng cho việc đánh tiếng Việt
			FontFactory.register("C:\\Windows\\Fonts\\arial.ttf","Arial Unicode MS");
			//Câu lệnh lấy font ra để dùng cho đoạn văn bản
			FontFactory.getFont("Arial Unicode MS",BaseFont.IDENTITY_H,BaseFont.EMBEDDED);

			
			PdfWriter.getInstance(document, new FileOutputStream("orders pdf/MauHoaDon"+hoaDonInfo.getMaHoaDon()+".pdf"));
			document.open();
			
			Font font1 = new Font(FontFactory.getFont("Arial Unicode MS",BaseFont.IDENTITY_H,BaseFont.EMBEDDED));
			font1.setSize(7f);
			
			Font font2 = new Font(font1);
			font2.setSize(20f);
			
			Font font3 = new Font(font1);
			font3.setSize(12f);
			
			Font font4 = new Font(font1);
			font4.setSize(11f);
			
			Paragraph paragraph1 = new Paragraph(new Phrase("Một sản phẩm từ Managedsily", font1));
			
			Paragraph paragraph2 = new Paragraph(new Phrase("HOÁ ĐƠN THANH TOÁN ",font2));
			
			Paragraph paragraph3 = new Paragraph();
			String info = "Mã hoá đơn: "+hoaDonInfo.getMaHoaDon()+"\n"
						+"Họ tên khách hàng: "+hoaDonInfo.getTenKhachHang()+"\n"
						+"Số điện thoại: "+hoaDonInfo.getsDT()+"\n"
						+"Nhân viên viết đơn hàng: "+hoaDonInfo.getNhanVien()+"\n"
						+"Ngày bán: "+hoaDonInfo.getNgayBan()+"\n";
//			String info = "Mã hoá đơn: "+""+"\n"
//					+"Họ tên khách hàng: "+""+"\n"
//					+"Số điện thoại: "+""+"\n"
//					+"Nhân viên viết đơn hàng: "+""+"\n"
//					+"Ngày bán: "+""+"\n";
			paragraph3.setFont(font3);
			paragraph3.add(info);
			
			Paragraph paragraphEmpty = new Paragraph("\n");
            PdfPTable table = new PdfPTable(4); // 4 columns.

            PdfPCell collum1 = new PdfPCell(new Paragraph("Tên mặt hàng",font3));
            PdfPCell collum2 = new PdfPCell(new Paragraph("Đơn giá(vnđ)",font3));
            PdfPCell collum3 = new PdfPCell(new Paragraph("Số lượng",font3));
            PdfPCell collum4 = new PdfPCell(new Paragraph("Thành tiền(vnđ)",font3));          

            table.addCell(collum1);
            table.addCell(collum2);
            table.addCell(collum3);
            table.addCell(collum4);
            
            for(ChiTietHoaDon cthd: hoaDonInfo.getListOrder()) {
            	PdfPCell cell1 = new PdfPCell(new Paragraph(cthd.getTen_mat_hang(),font4));
                PdfPCell cell2 = new PdfPCell(new Paragraph(Integer.toString(cthd.getDon_gia()),font4));
                PdfPCell cell3 = new PdfPCell(new Paragraph(Integer.toString(cthd.getSo_luong()),font4));
                PdfPCell cell4 = new PdfPCell(new Paragraph(Integer.toString(cthd.getThanh_tien()),font4));          

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
            }
            
            Paragraph paragraph4 = new Paragraph(new Phrase("Thành tiền: "+hoaDonInfo.getThanhTien()+" vnđ",font3));
            
            table.setHeaderRows(0);
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraphEmpty);
            document.add(paragraph3);
            document.add(paragraphEmpty);
            document.add(table);
            document.add(paragraphEmpty);
            document.add(paragraph4);          

            document.close();

            //Câu lệnh dưới gồm 3 phần chính
            // "cmd": Dùng lệnh cmd của window
            // "/c" : Lệnh sẽ được thực thi một lần duy nhất và kết thúc luôn
            // "MauHoaDon.pdf" : Đường link dẫn tới file đích - trong trường hợp này file đích nằm gọn trong file project hiện hành nên có thể gọi luôn
			String cmds[] = new String[] {"cmd", "/c","orders pdf/MauHoaDon"+hoaDonInfo.getMaHoaDon()+".pdf"};
			Runtime.getRuntime().exec(cmds);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		new HoaDonPDF(new HoaDonInfoBean());
	}
}
