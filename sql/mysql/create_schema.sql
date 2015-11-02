/**user**/
drop table `tb_user`;

CREATE TABLE `tb_user` (
`user_id`  bigint NOT NULL AUTO_INCREMENT ,
`user_name`  varchar(60) NOT NULL ,
`login_name`  varchar(60) NOT NULL ,
`password`  varchar(32) NOT NULL ,
PRIMARY KEY (`user_id`)
);