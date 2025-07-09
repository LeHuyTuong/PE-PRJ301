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
('admin01', N'Nguyen Van A', 'AD', 'admin123'),
('member01', N'Tran Thi B', 'MB', 'member123'),
('member02', N'Le Van C', 'MB', 'pass456');
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
('E-001', N'Smartphone X', N'High-end smartphone with OLED display', 15000.0, 10, 1),
('E-002', N'Laptop Y', N'Powerful laptop for developers', 25000.0, 5, 1),
('E-003', N'Wireless Mouse Z', N'Ergonomic design, long battery life', 500.0, 20, 0);
GO
