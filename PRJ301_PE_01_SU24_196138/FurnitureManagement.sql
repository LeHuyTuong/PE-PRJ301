
CREATE DATABASE [FurnitureManagement]
 
GO

USE [FurnitureManagement]
GO

CREATE TABLE [dbo].[tblFurniture](
	[id] [char](5) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](500) NOT NULL,
	[price] [float] NOT NULL,
	[dimensions] [nvarchar](50) NOT NULL,
	[material] [nvarchar](50) NOT NULL,
	[status] [bit] NULL,
	PRIMARY KEY ([id])
)

GO

CREATE TABLE [dbo].[tblUsers](
	[userID] [nvarchar](50) NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[roleID] [nvarchar](50) NOT NULL,
	PRIMARY KEY ([userID])
 )
GO


INSERT [dbo].[tblFurniture] ([id], [name], [description], [price], [dimensions], [material], [status]) VALUES (N'F-011', N'Sofa', N'Sofa da', 195000, N'161x181x46cm', N'Da Dai Loan', 1)
INSERT [dbo].[tblFurniture] ([id], [name], [description], [price], [dimensions], [material], [status]) VALUES (N'F-012', N'Ghe', N'Ghe go', 185000, N'61x81x46cm',N'Go xoai', 1)
INSERT [dbo].[tblFurniture] ([id], [name], [description], [price], [dimensions], [material], [status]) VALUES (N'F-013', N'Ban', N'Ban da', 165000, N'161x181x46cm', N'Da Dai Loan', 1)
INSERT [dbo].[tblFurniture] ([id], [name], [description], [price], [dimensions], [material], [status]) VALUES (N'F-014', N'Vong', N'Vong tre', 135000, N'61x81x46cm',N'Tre gia', 1)
INSERT [dbo].[tblFurniture] ([id], [name], [description], [price], [dimensions], [material], [status]) VALUES (N'F-015', N'Chay', N'Chay go', 115000, N'61x81x46cm',N'Go xoai', 1)

GO

INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID]) VALUES (N'admin', N'Administrator', N'123', N'admin')
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID]) VALUES (N'admin1', N'Administrator1', N'123', N'admin')
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID]) VALUES (N'user1', N'User1', N'123', N'user')
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID]) VALUES (N'user2', N'User2', N'123', N'user')

