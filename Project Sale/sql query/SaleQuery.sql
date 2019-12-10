create database sales
use sales
go 

--đặc điểm bảng khach_hang
create table khach_hang(
	ma_khach_hang int IDENTITY primary key,
	ho_ten nvarchar(50) not null,
	sdt varchar(11) not null,
	dia_chi nvarchar(100)
)

--đặc điểm bảng nhan_vien
create table nhan_vien(
	ma_nhan_vien int IDENTITY primary key,
	ten_nhan_vien nvarchar(50) not null,
	gioi_tinh bit not null,
	dia_chi nvarchar(100) default null,
	sdt varchar(11) default null,
	ngay_sinh date check(ngay_sinh<getdate()) default null,
	tinh_trang bit not null
)

--đặc điểm bảng mat_hang
create table mat_hang(
	ma_mat_hang int IDENTITY primary key,
	ten_mat_hang nvarchar(50) not null,
	don_gia int not null,
	ton_kho int not null,
	co_san bit not null,
	thoi_gian_nhap smalldatetime
)

--đặc điểm bảng hoa_don
create table hoa_don(
	ma_hoa_don int IDENTITY primary key,
	ma_nhan_vien int not null,
	ngay_ban date check(ngay_ban<=getdate()) not null,
	ma_khach_hang int not null,
	thanh_tien int not null
	foreign key(ma_nhan_vien) references nhan_vien,
	foreign key(ma_khach_hang) references khach_hang
)

--đặc điểm bảng chi_tiet_hoa_don
create table chi_tiet_hoa_don(
	ma_hoa_don int ,
	ma_mat_hang int ,
	so_luong nvarchar(10),
	don_gia nvarchar(10),
	giam_gia int,
	thanh_tien int
	constraint RB_khoa primary key(ma_hoa_don,ma_mat_hang),
	foreign key (ma_hoa_don) references hoa_don,
	foreign key (ma_mat_hang) references mat_hang
);
drop table khach_hang
drop table nhan_vien
drop table mat_hang
drop table hoa_don
drop table chi_tiet_hoa_don

sp_help khach_hang --thông tin bảng khach_hang
sp_help nhan_vien	--thông tin bảng nhan_vien
sp_help mat_hang	--thông tin bảng mat_hang
sp_help hoa_don		--thông tin bảng hoa_don
sp_help chi_tiet_hoa_don	--thông tin bảng chi_tiet_hoa_don

MERGE INTO khach_hang AS t USING (SELECT ma_khach_hang=6, ho_ten=N'Trần Đức Bo', sdt='0333520020', dia_chi=N'Hà Nội') AS s ON t.ma_khach_hang = s.ma_khach_hang WHEN MATCHED THEN UPDATE SET ho_ten=s.ho_ten, sdt=s.sdt, dia_chi=s.dia_chi WHEN NOT MATCHED THEN INSERT (ho_ten, sdt, dia_chi) VALUES (s.ho_ten, s.sdt, s.dia_chi);
select * from khach_hang

insert into khach_hang(ho_ten,sdt,dia_chi) values (N'Trần Trung Quân','0333520020',N'Hà Nội'),
(N'Nguyễn Đức Cảnh','0326520020',N'Hải Phỏng'),
(N'Lê Bá Vành','0333585420',N'Hà Nội'),
(N'Trần Phương Thảo','0333520652',N'TP HCM')

MERGE INTO nhan_vien AS t USING (SELECT ma_nhan_vien=?, ten_nhan_vien=?, gioi_tinh=?, dia_chi=?, sdt=?,ngay_sinh=?,tinh_trang=?) AS s ON t.ma_nhan_vien = s.ma_nhan_vien WHEN MATCHED THEN UPDATE SET ten_nhan_vien=s.ten_nhan_vien,gioi_tinh=s.gioi_tinh ,dia_chi=s.dia_chi ,sdt=s.sdt ,ngay_sinh=s.ngay_sinh, tinh_trang= s.tinh_trang WHEN NOT MATCHED THEN INSERT (ten_nhan_vien, gioi_tinh, dia_chi,  sdt, ngay_sinh, tinh_trang) VALUES (s.ten_nhan_vien, s.gioi_tinh, s.dia_chi,  s.sdt, s.ngay_sinh, s.tinh_trang);



