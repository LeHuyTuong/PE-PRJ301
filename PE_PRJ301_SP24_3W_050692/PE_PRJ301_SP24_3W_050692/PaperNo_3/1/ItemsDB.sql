USE master
GO
CREATE DATABASE ItemsDB
GO
USE ItemsDB
GO
CREATE TABLE [dbo].[tblItems](
	[id] [varchar](5) PRIMARY KEY NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL
)
GO

CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](50) PRIMARY KEY NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
 )
GO
INSERT [dbo].[tblItems] ([id], [name], [price], [quantity]) VALUES (N'00001', N'coffee', 100, 5)
GO
INSERT [dbo].[tblItems] ([id], [name], [price], [quantity]) VALUES (N'00002', N'cake', 200, 10)
GO
INSERT [dbo].[tblItems] ([id], [name], [price], [quantity]) VALUES (N'00003', N'cheese', 150, 2)
GO
INSERT [dbo].[tblItems] ([id], [name], [price], [quantity]) VALUES (N'00004', N'soft drink', 170, 3)
GO
INSERT [dbo].[tblItems] ([id], [name], [price], [quantity]) VALUES (N'00005', N'sour milk', 350, 2)
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [password]) VALUES (N'001', N'Nguyen Hoang Minh', N'12345')
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [password]) VALUES (N'002', N'Tran Khac Nam', N'45678')
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [password]) VALUES (N'003', N'Vu Bao Anh', N'12378')
GO
