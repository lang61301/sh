drop table if exists tb_sys_log;

drop table if exists tb_user;

/*==============================================================*/
/* Table: tb_sys_log                                            */
/*==============================================================*/
create table tb_sys_log
(
   log_id               int(64) not null auto_increment,
   create_time          datetime not null,
   log_message          varchar(1024),
   status               int not null default 1,
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   user_id              int(64) not null auto_increment,
   user_name            varchar(60) not null,
   login_name           varchar(60) not null,
   password             char(32) not null,
   primary key (user_id)
);