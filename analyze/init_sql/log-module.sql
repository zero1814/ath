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
IF EXISTS logmodule;

CREATE DATABASE logmodule DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE logmodule;

DROP TABLE
IF EXISTS lm_login;

CREATE TABLE lm_login (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	user_code VARCHAR (50) NOT NULL COMMENT '用户编码',
	session_id VARCHAR (50) NOT NULL COMMENT 'Session ID',
	`host` VARCHAR (20) NOT NULL COMMENT 'Session host地址',
	start_time datetime NOT NULL COMMENT 'Session创建时间',
	last_access_time datetime COMMENT 'Session最后交互时间',
	time_out INT DEFAULT 0 COMMENT 'Session timeout时长',
	session_status INT DEFAULT 1 COMMENT 'session 是否踢出 0 是 1 否'
) COMMENT '用户登录日志表';

