create database sales
use sales --Chạy cái này đầu tiên trước khi làm bất cứ cái gì
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
	ten_mat_hang nvarchar(50) unique not null,
	loai_hang nvarchar(50),
	don_gia int not null,
	ton_kho int not null,
	co_san bit not null,
	thoi_gian_nhap smalldatetime
)

--đặc điểm bảng hoa_don
create table hoa_don(
	ma_hoa_don int IDENTITY primary key,
	ma_nhan_vien int,
	ngay_ban smalldatetime,
	ma_khach_hang int,
	thanh_tien int
	foreign key(ma_nhan_vien) references nhan_vien,
	foreign key(ma_khach_hang) references khach_hang
)

--đặc điểm bảng chi_tiet_hoa_don
create table chi_tiet_hoa_don(
	ma_hoa_don int ,
	ma_mat_hang int ,
	so_luong int,
	don_gia int,
	thanh_tien int
	constraint RB_khoa primary key(ma_hoa_don,ma_mat_hang),
	foreign key (ma_hoa_don) references hoa_don,
	foreign key (ma_mat_hang) references mat_hang
);

create table tai_khoan(
	ma_tai_khoan int not null IDENTITY(1,2) primary key,
	ten_dang_nhap varchar(100) default null,
	mat_khau varchar(100) default null,
	tinh_trang bit default null
)

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

INSERT INTO hoa_don(ma_nhan_vien,ngay_ban,ma_khach_hang,thanh_tien) VALUES(2,'2018-10-15',6,0)

MERGE INTO nhan_vien AS t USING (SELECT ma_nhan_vien=?, ten_nhan_vien=?, gioi_tinh=?, dia_chi=?, sdt=?,ngay_sinh=?,tinh_trang=?) AS s ON t.ma_nhan_vien = s.ma_nhan_vien WHEN MATCHED THEN UPDATE SET ten_nhan_vien=s.ten_nhan_vien,gioi_tinh=s.gioi_tinh ,dia_chi=s.dia_chi ,sdt=s.sdt ,ngay_sinh=s.ngay_sinh, tinh_trang= s.tinh_trang WHEN NOT MATCHED THEN INSERT (ten_nhan_vien, gioi_tinh, dia_chi,  sdt, ngay_sinh, tinh_trang) VALUES (s.ten_nhan_vien, s.gioi_tinh, s.dia_chi,  s.sdt, s.ngay_sinh, s.tinh_trang);

MERGE INTO mat_hang AS t USING (SELECT ma_mat_hang=?, ten_mat_hang=?, loai_hang=?, don_gia=?, ton_kho=?,co_san=?,thoi_gian_nhap=?) AS s ON t.ma_mat_hang = s.ma_mat_hang WHEN MATCHED THEN UPDATE SET ten_mat_hang=s.ten_mat_hang,loai_hang=s.loai_hang ,don_gia=s.don_gia ,ton_kho=s.ton_kho, co_san= s.co_san, thoi_gian_nhap = s.thoi_gian_nhap WHEN NOT MATCHED THEN INSERT (ten_mat_hang, loai_hang, don_gia, ton_kho, co_san, thoi_gian_nhap) VALUES (s.ten_mat_hang, s.loai_hang, s.don_gia, s.ton_kho, s.co_san, s.thoi_gian_nhap);

MERGE INTO hoa_don AS t USING (SELECT ma_hoa_don=?, ma_nhan_vien=?, ngay_ban=?, ma_khach_hang=?, thanh_tien=?) AS s ON t.ma_hoa_don = s.ma_hoa_don WHEN MATCHED THEN UPDATE SET ma_nhan_vien=s.ma_nhan_vien,ngay_ban=s.ngay_ban ,ma_khach_hang=s.ma_khach_hang ,thanh_tien=s.thanh_tien WHEN NOT MATCHED THEN INSERT (ma_nhan_vien, ngay_ban, ma_khach_hang, thanh_tien) VALUES (s.ma_nhan_vien, s.ngay_ban, s.ma_khach_hang, s.thanh_tien);

select * from nhan_vien
select * from khach_hang
SELECT * FROM mat_hang
SELECT * FROM hoa_don
SELECT * FROM chi_tiet_hoa_don


select hd.ma_hoa_don,hd.ma_nhan_vien,ngay_ban,hd.ma_khach_hang,thanh_tien,nv.ten_nhan_vien,kh.ho_ten from hoa_don hd,nhan_vien nv,khach_hang kh where kh.ma_khach_hang = hd.ma_khach_hang and nv.ma_nhan_vien = hd.ma_nhan_vien

SELECT * FROM mat_hang WHERE ten_mat_hang=N'Củ Chuối'

insert into chi_tiet_hoa_don(ma_hoa_don,ma_mat_hang,so_luong,don_gia,thanh_tien) values(1,2,4,2000,8000)

select hd.ma_hoa_don,ten_mat_hang, mh.don_gia, cthd.so_luong, cthd.thanh_tien from chi_tiet_hoa_don cthd, mat_hang mh, hoa_don hd where mh.ma_mat_hang = cthd.ma_mat_hang and hd.ma_hoa_don = cthd.ma_hoa_don and hd.ma_hoa_don = 1

SELECT count(ma_khach_hang) AS dem FROM khach_hang
SELECT count(ma_mat_hang) AS dem FROM mat_hang
SELECT count(ma_hoa_don) AS dem FROM hoa_don