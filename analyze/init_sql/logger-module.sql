/*
id int primary key AUTO_INCREMENT COMMENT '主键',
uid varchar(50) not null COMMENT 'uuid',
`code` varchar(50) not null UNIQUE COMMENT '编码',
create_user varchar(50) not null COMMENT '创建人',
create_time datetime not null COMMENT '创建时间',
update_user varchar(50) not null COMMENT '最后修改人',
update_time datetime not null COMMENT '最后修改时间'
*/
DROP DATABASE
IF EXISTS loggermodule;

CREATE DATABASE loggermodule DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE loggermodule;

DROP TABLE
IF EXISTS lm_login;

CREATE TABLE lm_login (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	user_code VARCHAR (50) NOT NULL COMMENT '用户编码',
	ip VARCHAR (50) NOT NULL COMMENT 'ip地址',
	login_time datetime NOT NULL COMMENT '登录时间'
) COMMENT '用户登录日志表';

