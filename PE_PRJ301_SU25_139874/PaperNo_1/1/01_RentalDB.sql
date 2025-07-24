use MASTER
go
-- 0. Xóa Database RentalDB nếu đã tồn tại trong DBMS --------------------
IF EXISTS (
    SELECT name 
    FROM sys.databases 
    WHERE name = N'RentalDB'
)
BEGIN
    -- Tùy chọn: đưa DB về SINGLE_USER để tránh lỗi đang có kết nối
    ALTER DATABASE [RentalDB] SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    
    -- Xóa database
    DROP DATABASE [RentalDB];
END

go
-- 1. Tạo database
CREATE DATABASE RentalDB;
go

USE RentalDB;
go

-- 2. Bảng tài khoản (Account)
CREATE TABLE Account (
    username NVARCHAR(50) PRIMARY KEY NOT NULL,        -- Tên đăng nhập không được trùng
    password NVARCHAR(100) NOT NULL,                   -- Mật khẩu đăng nhập (Nên Hashing khi dùng)
    fullName NVARCHAR(100) NOT NULL,                   -- Họ tên người được cấp tài khoản 
    phone NVARCHAR(20),                                -- Số điện thoại 
    email NVARCHAR(100),                               -- Email cá nhân
	status bit default 0,							   -- 1 active - 0 Block
	role	int										   -- 1: Administrator - 2: Member 	
);
go
-- 3. Bảng phòng trọ (RoomForRent)
CREATE TABLE RoomForRent (
    id INT PRIMARY KEY IDENTITY(1,1),          -- Mã phòng, tự tăng
    title NVARCHAR(100) NOT NULL,              -- Tiêu đề (ví dụ: "Phòng trọ 25m2, Q1")
    price DECIMAL(10,2) NOT NULL,              -- Giá thuê (đồng/tháng)
    location NVARCHAR(150) NOT NULL,           -- Địa chỉ phòng cho thuê
    description NVARCHAR(MAX),                 -- Mô tả chi tiết về phòng muốn cho thuê
    postedDate DATETIME DEFAULT GETDATE(),     -- Ngày đăng tin
	status int default 0,					   -- Trạng thái của tin: -2: Đã xóa; -1: Bị báo cáo; 0: Chờ thuê; 1: Đã thuê; 2:Tin hết hạn  
    username NVARCHAR(50) NOT NULL,            -- Chủ phòng → tham chiếu tới Account
    FOREIGN KEY (username) REFERENCES Account(username)
);
go
-- 4. Chèn thông tin cho 12 tài khoản
INSERT INTO Account (username, password, fullName, phone, email, status, role)
VALUES
('admin','1',N'Administrator','0918771155','nquanghung@gmail.com',1,1), 
('quang','1',N'Nguyễn Minh Quang','0913641576','nmquang@yahoo.com',1,1), 
('alice01', 'hashedpass1', N'Alice Nguyễn', '0909123456', 'alice01@gmail.com',1,2),
('bobtran', 'hashedpass2', N'Bob Trần', '0909234567', 'bobtran@yahoo.com',1,2),
('carol93', 'hashedpass3', N'Carol Phạm', '0909345678', 'carol93@hotmail.com',0,2),
('danlee', 'hashedpass4', N'Dan Lê', '0909456789', 'danlee@gmail.com',0,2),
('emily12', 'hashedpass5', N'Emily Trịnh', '0909567890', 'emily12@outlook.com',1,2),
('frankh', 'hashedpass6', N'Frank Hoàng', '0909678901', 'frankh@zmail.com',1,2),
('giangvo', 'hashedpass7', N'Giang Võ', '0909789012', 'giangvo@abc.com',1,2),
('hieuvt', 'hashedpass8', N'Hiếu Vũ', '0909890123', 'hieuvt@xyz.com',0,2),
('ivyphan', 'hashedpass9', N'Ivy Phan', '0909901234', 'ivyphan@gmail.com',1,2),
('jack99', 'hashedpass10', N'Jack Nguyễn', '0909012345', 'jack99@mail.com',0,2),
('kimanh', 'hashedpass11', N'Kim Anh', '0909123987', 'kimanh@edu.vn',0,2),
('longpt', 'hashedpass12', N'Long Phan', '0909234876', 'longpt@org.vn',1,2);
go
-- 5. Chèn thông tin về phòng cho thuê []
INSERT [dbo].[RoomForRent] ( [title], [price], [location], [description], [postedDate], [status], [username]) VALUES 
 ( N'Phòng giá rẻ 15m2', CAST(4700000.00 AS Decimal(10, 2)), N'27 Điện Biên Phủ, Quận 10, TP. Hồ Chí Minh', N'Phòng mới xây 25m2', CAST(N'2025-06-23T10:08:12.120' AS DateTime), 0, N'alice01'),
 ( N'Phòng giá rẻ 15m2', CAST(3300000.00 AS Decimal(10, 2)), N'194 Nguyễn Thị Minh Khai, Quận Bình Thạnh, TP. Hồ Chí Minh', N'Phòng giá rẻ 15m2', CAST(N'2025-06-23T10:08:12.120' AS DateTime), 2, N'alice01'),
 ( N'Phòng trọ 20m2 - Gần trung tâm', CAST(6800000.00 AS Decimal(10, 2)), N'151 Nguyễn Huệ, Quận 1, TP. Hồ Chí Minh', N'Phòng giá rẻ 15m2', CAST(N'2025-05-23T10:08:12.120' AS DateTime), 1, N'bobtran'),
 ( N'Phòng cao cấp 35m2', CAST(6600000.00 AS Decimal(10, 2)), N'86 Lý Tự Trọng, Quận 1, TP. Hồ Chí Minh', N'Phòng giá rẻ 15m2', CAST(N'2025-06-13T10:08:12.120' AS DateTime), 1, N'bobtran'),
 ( N'Phòng đẹp 30m2 full nội thất', CAST(4000000.00 AS Decimal(10, 2)), N'30 Phan Xích Long, Quận Phú Nhuận, TP. Hồ Chí Minh', N'Phòng mới xây 25m2', CAST(N'2025-05-21T10:08:12.120' AS DateTime), 0, N'bobtran'),
 ( N'Phòng giá rẻ 15m2', CAST(6400000.00 AS Decimal(10, 2)), N'163 Phan Xích Long, Quận Phú Nhuận, TP. Hồ Chí Minh', N'Phòng cao cấp 35m2', CAST(N'2025-04-09T10:08:12.120' AS DateTime), -2, N'bobtran'),
 ( N'Phòng cao cấp 35m2', CAST(7600000.00 AS Decimal(10, 2)), N'189 Trường Chinh, Quận Tân Phú, TP. Hồ Chí Minh', N'Phòng đẹp 30m2 full nội thất', CAST(N'2025-06-12T17:08:12.120' AS DateTime), 0, N'bobtran'),
 ( N'Phòng giá rẻ 15m2', CAST(7900000.00 AS Decimal(10, 2)), N'144 Lý Tự Trọng, Quận 1, TP. Hồ Chí Minh', N'Phòng cao cấp 35m2', CAST(N'2025-05-03T12:08:12.120' AS DateTime), 1, N'bobtran'),
 ( N'Phòng cao cấp 35m2', CAST(5700000.00 AS Decimal(10, 2)), N'42 Nguyễn Huệ, Quận 1, TP. Hồ Chí Minh', N'Phòng trọ 20m2 - Gần trung tâm', CAST(N'2025-05-17T15:08:12.120' AS DateTime), 1, N'carol93'),
 ( N'Phòng đẹp 30m2 full nội thất', CAST(3800000.00 AS Decimal(10, 2)), N'63 Phan Xích Long, Quận Phú Nhuận, TP. Hồ Chí Minh', N'Phòng mới xây 25m2', CAST(N'2025-04-26T16:08:12.120' AS DateTime), 0, N'carol93'),
 ( N'Phòng cao cấp 35m2', CAST(4200000.00 AS Decimal(10, 2)), N'137 Lê Văn Sỹ, Quận Tân Bình, TP. Hồ Chí Minh', N'Phòng cao cấp 35m2', CAST(N'2025-05-03T10:08:12.120' AS DateTime), 0, N'carol93'),
 ( N'Phòng mới xây 25m2', CAST(2200000.00 AS Decimal(10, 2)), N'118 Đinh Tiên Hoàng, Quận 1, TP. Hồ Chí Minh', N'Phòng mới xây 25m2', CAST(N'2025-05-27T11:08:12.120' AS DateTime), 0, N'carol93'),
 ( N'Phòng mới xây 25m2', CAST(4300000.00 AS Decimal(10, 2)), N'147 Đinh Tiên Hoàng, Quận 1, TP. Hồ Chí Minh', N'Phòng mới xây 25m2', CAST(N'2025-04-19T12:08:12.120' AS DateTime), 2, N'danlee'),
 ( N'Phòng cao cấp 35m2', CAST(4200000.00 AS Decimal(10, 2)), N'107 Nguyễn Huệ, Quận 1, TP. Hồ Chí Minh', N'Phòng giá rẻ 15m2', CAST(N'2025-04-23T17:08:12.120' AS DateTime), 0, N'danlee'),
 ( N'Phòng mới xây 25m2', CAST(5500000.00 AS Decimal(10, 2)), N'95 Cách Mạng Tháng Tám, Quận 3, TP. Hồ Chí Minh', N'Phòng đẹp 30m2 full nội thất', CAST(N'2025-05-08T16:28:12.120' AS DateTime), 1, N'danlee'),
 ( N'Phòng trọ 20m2 - Gần trung tâm', CAST(6400000.00 AS Decimal(10, 2)), N'129 Trường Chinh, Quận Tân Bình, TP. Hồ Chí Minh', N'Phòng giá rẻ 15m2', CAST(N'2025-06-11T09:08:12.120' AS DateTime), -2, N'emily12'),
 ( N'Phòng đẹp 30m2 full nội thất', CAST(2800000.00 AS Decimal(10, 2)), N'182 Trường Chinh, Quận Tân Bình, TP. Hồ Chí Minh', N'Phòng mới xây 25m2', CAST(N'2025-06-27T11:28:12.120' AS DateTime), 2, N'emily12'),
 ( N'Phòng đẹp 30m2 full nội thất', CAST(1300000.00 AS Decimal(10, 2)), N'118 Cách Mạng Tháng Tám, Quận 3, TP. Hồ Chí Minh', N'Phòng giá rẻ 15m2', CAST(N'2025-06-13T10:08:12.120' AS DateTime), 0, N'emily12'),
 ( N'Phòng trọ 20m2 - Gần trung tâm', CAST(4300000.00 AS Decimal(10, 2)), N'103 Trường Chinh, Quận Tân Bình, TP. Hồ Chí Minh', N'Phòng mới xây 25m2', CAST(N'2025-04-29T17:38:12.120' AS DateTime), 1, N'emily12'),
 ( N'Phòng cao cấp 35m2', CAST(1900000.00 AS Decimal(10, 2)), N'120 Trường Chinh, Quận 12, TP. Hồ Chí Minh', N'Phòng giá rẻ 15m2', CAST(N'2025-06-06T08:48:12.120' AS DateTime), 0, N'emily12'),
 ( N'Phòng giá rẻ 15m2', CAST(3100000.00 AS Decimal(10, 2)), N'105 Lý Tự Trọng, Quận 1, TP. Hồ Chí Minh', N'Phòng đẹp 30m2 full nội thất', CAST(N'2025-05-29T21:08:12.120' AS DateTime), 0, N'emily12'),
 ( N'Phòng đẹp 30m2 full nội thất', CAST(6100000.00 AS Decimal(10, 2)), N'83 Nguyễn Thị Minh Khai, Quận 3, TP. Hồ Chí Minh', N'Phòng trọ 20m2 - Gần trung tâm', CAST(N'2025-03-27T11:18:12.120' AS DateTime), -1, N'frankh'),
 ( N'Phòng cao cấp 35m2', CAST(4500000.00 AS Decimal(10, 2)), N'32 Nguyễn Huệ, Quận 1, TP. Hồ Chí Minh', N'Phòng đẹp 30m2 full nội thất', CAST(N'2025-03-25T19:18:12.120' AS DateTime), -2, N'frankh'),
 ( N'Phòng đẹp 30m2 full nội thất', CAST(5100000.00 AS Decimal(10, 2)), N'146 Phan Xích Long, Quận Phú Nhuận, TP. Hồ Chí Minh', N'Phòng giá rẻ 15m2', CAST(N'2025-03-23T15:28:12.120' AS DateTime), 2, N'frankh'),
 ( N'Phòng cao cấp 35m2', CAST(2700000.00 AS Decimal(10, 2)), N'132 Đinh Tiên Hoàng, Quận 1, TP. Hồ Chí Minh', N'Phòng cao cấp 35m2', CAST(N'2025-04-21T13:33:12.120' AS DateTime), 1, N'frankh'),
 ( N'Phòng trọ 20m2 - Gần trung tâm', CAST(5400000.00 AS Decimal(10, 2)), N'80 Nguyễn Huệ, Quận 1, TP. Hồ Chí Minh', N'Phòng trọ 20m2 - Gần trung tâm', CAST(N'2025-06-25T21:08:12.120' AS DateTime), 0, N'giangvo'),
 ( N'Phòng đẹp 30m2 full nội thất', CAST(2500000.00 AS Decimal(10, 2)), N'123 Lê Văn Sỹ, Quận 3, TP. Hồ Chí Minh', N'Phòng đẹp 30m2 full nội thất', CAST(N'2025-07-27T22:48:12.120' AS DateTime), 0, N'giangvo'),
 ( N'Phòng trọ 20m2 - Gần trung tâm', CAST(2000000.00 AS Decimal(10, 2)), N'124 Lê Văn Sỹ, Quận 3, TP. Hồ Chí Minh', N'Phòng đẹp 30m2 full nội thất', CAST(N'2025-02-13T23:08:12.120' AS DateTime), 2, N'giangvo'),
 ( N'Phòng đẹp 30m2 full nội thất', CAST(5700000.00 AS Decimal(10, 2)), N'25 Lê Văn Sỹ, Quận Phú Nhuận, TP. Hồ Chí Minh', N'Phòng cao cấp 35m2', CAST(N'2025-04-27T18:18:12.120' AS DateTime), 1, N'hieuvt'),
 ( N'Phòng đẹp 30m2 full nội thất', CAST(5200000.00 AS Decimal(10, 2)), N'183 Điện Biên Phủ, Quận 3, TP. Hồ Chí Minh', N'Phòng giá rẻ 15m2', CAST(N'2025-02-03T21:15:12.120' AS DateTime), 2, N'hieuvt'),
 ( N'Phòng trọ 20m2 - Gần trung tâm', CAST(7900000.00 AS Decimal(10, 2)), N'27 Trường Chinh, Quận Tân Bình, TP. Hồ Chí Minh', N'Phòng cao cấp 35m2', CAST(N'2025-02-17T09:38:12.120' AS DateTime), 2, N'hieuvt'),
 ( N'Phòng cao cấp 35m2', CAST(1500000.00 AS Decimal(10, 2)), N'106 Trường Chinh, Quận 12, TP. Hồ Chí Minh', N'Phòng cao cấp 35m2', CAST(N'2025-03-26T10:08:12.120' AS DateTime), 2, N'hieuvt'),
 ( N'Phòng đẹp 30m2 full nội thất', CAST(3400000.00 AS Decimal(10, 2)), N'36 Lê Văn Sỹ, Quận Phú Nhuận, TP. Hồ Chí Minh', N'Phòng mới xây 25m2', CAST(N'2025-02-24T14:25:12.120' AS DateTime), -1, N'ivyphan'),
 ( N'Phòng mới xây 25m2', CAST(2300000.00 AS Decimal(10, 2)), N'16 Nguyễn Thị Minh Khai, Quận 1, TP. Hồ Chí Minh', N'Phòng giá rẻ 15m2', CAST(N'2025-06-30T10:17:12.120' AS DateTime), 0, N'ivyphan'),
 ( N'Phòng giá rẻ 15m2', CAST(3200000.00 AS Decimal(10, 2)), N'33 Đinh Tiên Hoàng, Quận 1, TP. Hồ Chí Minh', N'Phòng cao cấp 35m2', CAST(N'2025-06-27T21:08:12.120' AS DateTime), 1, N'ivyphan'),
 ( N'Phòng giá rẻ 15m2', CAST(4000000.00 AS Decimal(10, 2)), N'153 Đinh Tiên Hoàng, Quận 1, TP. Hồ Chí Minh', N'Phòng mới xây 25m2', CAST(N'2025-03-25T22:18:12.120' AS DateTime), -1, N'ivyphan'),
 ( N'Phòng trọ 20m2 - Gần trung tâm', CAST(6200000.00 AS Decimal(10, 2)), N'169 Nguyễn Thị Minh Khai, Quận 3, TP. Hồ Chí Minh', N'Phòng mới xây 25m2', CAST(N'2025-02-12T09:35:12.137' AS DateTime), -2, N'ivyphan'),
 ( N'Phòng cao cấp 35m2', CAST(4900000.00 AS Decimal(10, 2)), N'99 Lý Tự Trọng, Quận 1, TP. Hồ Chí Minh', N'Phòng giá rẻ 15m2', CAST(N'2025-06-29T20:28:12.137' AS DateTime), 0, N'ivyphan'),
 ( N'Phòng đẹp 30m2 full nội thất', CAST(1600000.00 AS Decimal(10, 2)), N'140 Nguyễn Huệ, Quận 1, TP. Hồ Chí Minh', N'Phòng mới xây 25m2', CAST(N'2025-03-20T07:08:12.137' AS DateTime), 2, N'ivyphan'),
 ( N'Phòng giá rẻ 15m2', CAST(1700000.00 AS Decimal(10, 2)), N'170 Lê Văn Sỹ, Quận 3, TP. Hồ Chí Minh', N'Phòng trọ 20m2 - Gần trung tâm', CAST(N'2025-02-26T21:05:12.137' AS DateTime), -1, N'jack99'),
 ( N'Phòng giá rẻ 15m2', CAST(5300000.00 AS Decimal(10, 2)), N'82 Điện Biên Phủ, Quận 1, TP. Hồ Chí Minh', N'Phòng cao cấp 35m2', CAST(N'2025-04-23T17:08:12.137' AS DateTime), -1, N'jack99'),
 ( N'Phòng cao cấp 35m2', CAST(5800000.00 AS Decimal(10, 2)), N'17 Trường Chinh, Quận Tân Bình, TP. Hồ Chí Minh', N'Phòng giá rẻ 15m2', CAST(N'2025-06-13T19:38:12.137' AS DateTime), -2, N'jack99'),
 ( N'Phòng trọ 20m2 - Gần trung tâm', CAST(7200000.00 AS Decimal(10, 2)), N'180 Lê Văn Sỹ, Quận Phú Nhuận, TP. Hồ Chí Minh', N'Phòng trọ 20m2 - Gần trung tâm', CAST(N'2025-06-27T10:08:12.137' AS DateTime), 0, N'kimanh'),
 ( N'Phòng mới xây 25m2', CAST(7500000.00 AS Decimal(10, 2)), N'44 Phan Xích Long, Quận Bình Thạnh, TP. Hồ Chí Minh', N'Phòng cao cấp 35m2', CAST(N'2025-06-29T15:21:12.137' AS DateTime), 0, N'kimanh'),
 ( N'Phòng cao cấp 35m2', CAST(2700000.00 AS Decimal(10, 2)), N'175 Huỳnh Mẫn Đạt, Quận 5, TP. Hồ Chí Minh', N'Phòng mới xây 25m2', CAST(N'2025-06-28T09:21:12.137' AS DateTime), 1, N'kimanh'),
 ( N'Phòng mới xây 25m2', CAST(7000000.00 AS Decimal(10, 2)), N'183 Nguyễn Huệ, Quận 1, TP. Hồ Chí Minh', N'Phòng đẹp 30m2 full nội thất', CAST(N'2025-02-23T10:17:12.137' AS DateTime), -2, N'longpt'),
 ( N'Phòng đẹp 30m2 full nội thất', CAST(3900000.00 AS Decimal(10, 2)), N'114 Lũy Bán Bích, Quận Tân Phú, TP. Hồ Chí Minh', N'Phòng giá rẻ 15m2', CAST(N'2025-05-03T11:08:12.137' AS DateTime), 2, N'longpt'),
 ( N'Phòng đẹp 30m2 full nội thất', CAST(5000000.00 AS Decimal(10, 2)), N'24 Trường Chinh, Quận Tân Phú, TP. Hồ Chí Minh', N'Phòng trọ 20m2 - Gần trung tâm', CAST(N'2025-06-14T10:08:12.137' AS DateTime), -1, N'longpt')
go