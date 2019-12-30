Được tách ra từ controller, nhận nhiệm vụ chính là tạo kết nối với cơ sở dữ liệu(SQL Server) và thao
tác với CSDL 
	-DBConnect đơn giản là tạo kết nối với csdl với tài khoản và mật khẩu dùng cho csdl tương ứng
	
	-KhachHangDAO là interface để KhachHangDAOImpl có thể kế thừa, dùng để định hình lớp được kế 
thừa bao gồm những phương thức gì
	-KhachHangDAOImpl kế thừ interface, thể hiện việc kết nối CSDL với mục đích thêm vào một người
mới, và ngăn chặn việc tạo ra bản sao, nếu như bị trùng mã khách hàng thì sẽ không thêm mới mà sửa bản
ghi có sẵn theo tên || sdt || địa chỉ mới
	-Một số phương thức khác được thêm vào sẽ thực hiện một số công việc nhất định, cấu trúc khá tương tự chỉ khác là câu lệnh SQL, các biến được gán vào
	-Các phần khác tương tự