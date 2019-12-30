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
		Document document = new Document();	//Biến tài liệu được khỏi tạo
		try {
			//Câu lệnh đăng kí font chữ dùng cho việc đánh tiếng Việt
			FontFactory.register("C:\\Windows\\Fonts\\arial.ttf","Arial Unicode MS");
			//Câu lệnh lấy font ra để dùng cho đoạn văn bản
			FontFactory.getFont("Arial Unicode MS",BaseFont.IDENTITY_H,BaseFont.EMBEDDED);

			//Khởi tạo một hoá đơn mới còn trống
			PdfWriter.getInstance(document, new FileOutputStream("orders pdf/MauHoaDon"+hoaDonInfo.getMaHoaDon()+".pdf"));
			//Để bắt đầu chỉnh sửa, mở tệp tài liệu ra
			document.open();
			
			//Tài liệu pdf là tiếng việt, mà kiểu chữ của thư viện IText5 lại không hỗ trợ unicode, nên đây là cách thay thế
			
			Font font1 = new Font(FontFactory.getFont("Arial Unicode MS",BaseFont.IDENTITY_H,BaseFont.EMBEDDED));
			font1.setSize(7f);	//Font lấy từ ngoài vào không thể tự do chỉnh font chữ ngay khi lấy về nên đây là cách thay thé
			
			Font font2 = new Font(font1);	//Vẫn dùng font cũ chỉ thay đổi cỡ chữ, nên có thể lấy luôn từ font1 rồi thay đổi, không cần viết lại câu lệnh dài ngoằng
			font2.setSize(20f);
			
			Font font3 = new Font(font1);
			font3.setSize(12f);
			
			Font font4 = new Font(font1);
			font4.setSize(11f);
			
			//Các paragraph được tạo ra tương ứng để biểu thị cho các phần của một văn bản, mỗi phần sẽ có cỡ chữ khác nhau
			Paragraph paragraph1 = new Paragraph(new Phrase("Một sản phẩm từ Managedsily", font1));
			
			Paragraph paragraph2 = new Paragraph(new Phrase("HOÁ ĐƠN THANH TOÁN ",font2));
			
			//Các thông tin từ hoaDonInfo đã lưu sẽ được đưa vào đây để hoàn thiện hoá đơn
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
			
			//Paragraph này để ngăn cách một vài đoạn ngăn nó không bị dính vào nhau
			Paragraph paragraphEmpty = new Paragraph("\n");
			
			//Table trong pdf với 4 cột, với dòng đầu tiên là tên các cột(Không thể dùng chữ đậm vì font ngoài không hỗ trợ(IText5))
            PdfPTable table = new PdfPTable(4); // 4 columns.
            //Tạo các biến và add các tên cột vào
            PdfPCell collum1 = new PdfPCell(new Paragraph("Tên mặt hàng",font3));
            PdfPCell collum2 = new PdfPCell(new Paragraph("Đơn giá(vnđ)",font3));
            PdfPCell collum3 = new PdfPCell(new Paragraph("Số lượng",font3));
            PdfPCell collum4 = new PdfPCell(new Paragraph("Thành tiền(vnđ)",font3));          
            //Tạo xong thì ta đưa nó vào bảng
            table.addCell(collum1);
            table.addCell(collum2);
            table.addCell(collum3);
            table.addCell(collum4);
            
            //với mỗi cthd có được trong list, ta sẽ có một dòng tương ứng trong table
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
            
            //Đoạn văn bản cuối cùng để thể hiện thành tiền
            Paragraph paragraph4 = new Paragraph(new Phrase("Thành tiền: "+hoaDonInfo.getThanhTien()+" vnđ",font3));
            
            //Câu lệnh này để set dòng nào sẽ là dòng tên cột(cơ mà chưa biết để làm gì)
            table.setHeaderRows(0);
            
            //Sau khi các thuộc tính đã được cài đặt thì giờ là lúc sắp xếp thành một văn bản hoàn chỉnh, dưới đây tương tự sẽ là trình tự thấy khi file pdf được mở lên
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraphEmpty);
            document.add(paragraph3);
            document.add(paragraphEmpty);
            document.add(table);
            document.add(paragraphEmpty);
            document.add(paragraph4);          

            //Sau khi pdf được chỉnh sửa thành công thì ta phải đóng document lại, nếu không cả file tài liệu sẽ không được lưu và ta không thể mở nó(một lỗi đã được fix)
            document.close();

            //Câu lệnh dưới gồm 3 phần chính
            // "cmd": Dùng lệnh cmd của window
            // "/c" : Lệnh sẽ được thực thi một lần duy nhất và kết thúc luôn
            // "MauHoaDon.pdf" : Đường link dẫn tới file đích - trong trường hợp này file đích nằm gọn trong file project hiện hành nên có thể gọi luôn
			String cmds[] = new String[] {"cmd", "/c","orders pdf/MauHoaDon"+hoaDonInfo.getMaHoaDon()+".pdf"};
			Runtime.getRuntime().exec(cmds);
			//Trên đây là câu lệnh dùng để mở ngay file pdf bằng phần mềm đọc pdf trong máy đã cài, từ đây có thể đọc, in tuỳ ý :>
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		new HoaDonPDF(new HoaDonInfoBean());
	}
}
