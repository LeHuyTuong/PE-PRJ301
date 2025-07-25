DROP DATABASE [PracticalTest]
GO
/****** Object:  Database [PracticalTest]    Script Date: 02/07/2025 3:23:15 CH ******/
CREATE DATABASE [PracticalTest]
GO

USE [PracticalTest]
GO
/****** Object:  Table [dbo].[tbl_User]    Script Date: 02/07/2025 3:23:15 CH ******/

CREATE TABLE [dbo].[tbl_User](
	[username] [varchar](20) NOT NULL,
	[password] [int] NOT NULL,
	[fullName] [varchar](50) NOT NULL,
	[role] [bit] NOT NULL,
 CONSTRAINT [PK_tbl_User] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Watch]    Script Date: 02/07/2025 3:23:15 CH ******/

CREATE TABLE [dbo].[tbl_Watch](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[brandName] [nvarchar](250) NOT NULL,
	[price] [float] NOT NULL,
	[size] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[description] [nvarchar](250) NULL,
 CONSTRAINT [PK_tbl_Watch] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tbl_User] ([username], [password], [fullName], [role]) VALUES (N'doandu', 9807, N'Doan Du', 0)
INSERT [dbo].[tbl_User] ([username], [password], [fullName], [role]) VALUES (N'hutruc', 675432, N'Hu Truc', 0)
INSERT [dbo].[tbl_User] ([username], [password], [fullName], [role]) VALUES (N'khanh', 122344, N'K T K', 1)
INSERT [dbo].[tbl_User] ([username], [password], [fullName], [role]) VALUES (N'phong', 34987, N'Kieu Phong', 1)
INSERT [dbo].[tbl_User] ([username], [password], [fullName], [role]) VALUES (N'xungca', 984321, N'Lenh Ho Xung', 0)
GO
SET IDENTITY_INSERT [dbo].[tbl_Watch] ON 

INSERT [dbo].[tbl_Watch] ([id], [name], [brandName], [price], [size], [quantity], [description]) VALUES (1, N'seiko', N'Seiko', 250, 40, 15, N'Automatic Energy')
INSERT [dbo].[tbl_Watch] ([id], [name], [brandName], [price], [size], [quantity], [description]) VALUES (2, N'samsung fe 2024', N'Samsung', 500, 35, 20, N'Smart Watch, Health Monitor')
INSERT [dbo].[tbl_Watch] ([id], [name], [brandName], [price], [size], [quantity], [description]) VALUES (3, N'huawei watch 5', N'Huawei', 1000, 45, 10, N'Smart Watch, GPS, Health Monitor')
INSERT [dbo].[tbl_Watch] ([id], [name], [brandName], [price], [size], [quantity], [description]) VALUES (4, N'apple watch 6', N'Apple', 1100, 40, 5, N'Smatt Watch, Sport, GPS')
INSERT [dbo].[tbl_Watch] ([id], [name], [brandName], [price], [size], [quantity], [description]) VALUES (5, N'Amazit fit bip', N'Xiaomi', 150, 30, 35, N'Smart Watch')
SET IDENTITY_INSERT [dbo].[tbl_Watch] OFF
GO
ALTER TABLE [dbo].[tbl_User] ADD  CONSTRAINT [DF_tbl_User_role]  DEFAULT ((0)) FOR [role]
GO
