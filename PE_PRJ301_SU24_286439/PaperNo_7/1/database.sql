use master
go



print('Creating the AppointmentManagement database ...')

create database AppointmentManagement
go

use AppointmentManagement
go

create table Account(
	account varchar(25) not null primary key,
	pass    varchar(50) not null,					-- Password of this account
	roleDB varchar(8) not null default 'member',
	fullName nvarchar(35) not null,					
	gender bit default 0 not null,
	birthDay date not null,
	phone varchar(15) default '',
	addr nvarchar(255) default ''					-- Address of the owner
);
go

create table Appointments(
	idApp int identity primary key,
	account varchar(25) not null foreign key references Account(account) on update cascade,
	partnerPhone varchar(15) not null,
	partnerName nvarchar(35) not null,
	timeToMeet datetime not null,
	place nvarchar(100) not null,
	expense float default 100,
	note ntext default ''
);
go

print('Add data to the tables ...')

insert into Account values
('admin','11111','super',N'Nguyen Quang Hung',1,'2006/10/28','0750101028','95 Thanh Thai, P14, Q10, TP.HCM'),
('mem'  ,'22222','member',N'Tran Thi My Linh' ,0,'2003/08/30','0350112233','192 Nguyen Thien Thuat, P02, Q3, TP.HCM');

go

insert into Appointments values
('mem','0917123456',N'Minh Nguyen','2024/05/23 10:29:35', N'1 Nguyen Hue, Q1, TP.HCM',200,''),
('mem','0902357246',N'Tuan Tran','2024/05/25 19:30:35', N'213 Vo Van Ngan, Thu Duc, TP.HCM',150,''),
('mem','0967556677',N'Minh Nguyen','2024/05/27 15:10:40', N'eTown, Cong Haa, Q.Tan Binh, TP.HCM',75,''),
('admin','0918771155',N'Hoang Pham','2024/05/17 09:30:40', N'1024 CMT8, P11, Q.3, TP.HCM',35,''),
('admin','0772101072',N'Huy Nguyen','2024/05/26 17:30:40', N'1 Binh Gia, P.6, Q.Tan Binh, TP.HCM',105,''),
('admin','0735112255',N'Quang Vo','2024/05/30 20:00:00', N'Ten Lua, P.An Lac A, Q.Binh Tan, TP.HCM',200,''),
('admin','0918771155',N'Hung Ngo','2024/06/01 05:45:00', N'DH Quoc Te, P.Linh Trung, Thu Duc, TP.HCM',175,'');

go
print('Done, Ready to use !.')