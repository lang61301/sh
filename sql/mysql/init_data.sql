/***user***/
insert into `tb_user`(`user_name`, `login_name`, `password`) values('管理员', 'admin', UPPER(MD5('admin')));
commit;