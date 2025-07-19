USE [master]
GO
/****** Object:  Database [RoomManagement]    Script Date: 08/05/2024 08:42:37 ******/
CREATE DATABASE [RoomManagement]
GO
USE [RoomManagement]
GO

CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](50) NOT NULL,
	[fullName] [nvarchar](500) NOT NULL,
	[password] [varchar](50) NOT NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
))

GO
CREATE TABLE [dbo].[tblRooms](
	[id] [char](5) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](500) NOT NULL,
	[price] [float] NOT NULL,
	[area] [float] NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_tblFoods] PRIMARY KEY CLUSTERED 
(
	[id] ASC
) )
GO
USE [RoomManagement]


GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 08/05/2024 14:27:15 ******/
INSERT [dbo].[tblUsers] ([userID], [fullName], [password]) VALUES (N'user1', N'user 1',  N'us1')
INSERT [dbo].[tblUsers] ([userID], [fullName],  [password]) VALUES (N'user2', N'user 2',  N'us2')
INSERT [dbo].[tblUsers] ([userID], [fullName],  [password]) VALUES (N'user3', N'user 3',  N'us3')

/****** Object:  Table [dbo].[tblRooms]    Script Date: 08/05/2024 14:27:15 ******/
INSERT [dbo].[tblRooms] ([id], [name], [description], [price], [area], [status]) VALUES (N'R-000', N'VIP', N'VIP room', 1000, 1.5, 1)
INSERT [dbo].[tblRooms] ([id], [name], [description], [price], [area], [status]) VALUES (N'R-111', N'Standard', N'Standard room', 900, 1.2, 0)
INSERT [dbo].[tblRooms] ([id], [name], [description], [price], [area], [status]) VALUES (N'R-222', N'President', N'President room', 2000, 1.6, 0)
