Được tách ra từ controller, nhận nhiệm vụ chính là tạo kết nối với cơ sở dữ liệu(SQL Server) và thao
tác với CSDL 
	-DBConnect đơn giản là tạo kết nối
	-KhachHangDAO là interface để KhachHangDAOImpl có thể kế thừa, dùng để định hình lớp được kế 
thừa bao gồm những phương thức gì
	-KhachHangDAOImpl kế thừ interface, thể hiện việc kết nối CSDL với mục đích thêm vào một người
mới, và ngăn chặn việc tạo ra bản sao, nếu như bị trùng mã khách hàng thì sẽ không thêm mới mà sửa bản
ghi có sẵn theo tên || sdt || địa chỉ mới