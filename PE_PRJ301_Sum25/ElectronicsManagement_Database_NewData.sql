USE [master]
GO
DROP DATABASE [ElectronicsManagement]
GO
-- Tạo database
CREATE DATABASE ElectronicsManagement;
GO

USE ElectronicsManagement;
GO

-- Tạo bảng tblUsers
CREATE TABLE tblUsers (
    userID VARCHAR(50) PRIMARY KEY NOT NULL,
    fullName NVARCHAR(500) NOT NULL,
    roleID CHAR(2) NOT NULL DEFAULT 'MB',
    password VARCHAR(50) NOT NULL
);
GO

-- Thêm dữ liệu mẫu vào tblUsers
INSERT INTO tblUsers (userID, fullName, roleID, password)
VALUES
('admin02', N'Pham Quoc D', 'AD', 'securepass'),
('user01', N'Do Thi E', 'MB', 'userpass1'),
('user02', N'Hoang Gia F', 'MB', 'mypassword');
GO

-- Tạo bảng tblElectronics
CREATE TABLE tblElectronics (
    id CHAR(5) PRIMARY KEY CHECK (id LIKE 'E-[0-9][0-9][0-9]'),
    name NVARCHAR(100) NOT NULL,
    description NVARCHAR(500) NOT NULL,
    price FLOAT NOT NULL,
    quantity INT NOT NULL,
    status BIT DEFAULT 1
);
GO

-- Thêm dữ liệu mẫu vào tblElectronics
INSERT INTO tblElectronics (id, name, description, price, quantity, status)
VALUES
('E-004', N'Smartwatch A1', N'Smartwatch with fitness tracker and GPS', 3200.0, 15, 1),
('E-005', N'Bluetooth Speaker B2', N'Portable speaker with high bass output', 1800.0, 8, 1),
('E-006', N'Gaming Keyboard C3', N'Mechanical keyboard with RGB lighting', 2400.0, 12, 0);
GO
