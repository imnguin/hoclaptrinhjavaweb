use dcdjpabasic;
 
insert into role (name, code) values (N'Quản Lí',N'ADMIN');
insert into role (name, code) values (N'Người dùng',N'USER');
--insert account
insert into Account (username, PassWord, fullname, status ) values (N'dyu','123',N'Trần Khánh Duy',1) ;
insert into Account (UserName, PassWord, fullname, status) values (N'cuong','123',N'Mai Xuân Cường',1) ;
insert into Account (UserName, PassWord, fullname, status) values (N'duong','123',N'Quàng Văn Dương',1) ;
insert into Account (UserName, PassWord, fullname, status) values (N'binh','123',N'Trương Thanh Bình',1) ;

INSERT INTO user_role(userid,roleid) VALUES (1,1);
INSERT INTO user_role(userid,roleid) VALUES (2,1);
INSERT INTO user_role(userid,roleid) VALUES (3,1);
INSERT INTO user_role(userid,roleid) VALUES (4,2);