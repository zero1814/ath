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
IF EXISTS usermodule;

CREATE DATABASE usermodule DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE usermodule;


DROP TABLE
IF EXISTS um_define;

create table um_define (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	parent_code VARCHAR (50) DEFAULT '0' COMMENT '父级编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '参数表';

insert into um_define(uid,`code`,`name`,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'1000','状态','system',now(),'system',now());
insert into um_define(uid,`code`,`name`,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'1001','职位','system',now(),'system',now());

DROP TABLE
IF EXISTS um_company;

CREATE TABLE um_company (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	address VARCHAR (500) NOT NULL COMMENT '地址',
	principal varchar(50) not null comment '责任人',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '公司表';

DROP TABLE
IF EXISTS um_department;

CREATE TABLE um_department (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	company_code VARCHAR (50) NOT NULL COMMENT '公司编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	principal varchar(50) not null comment '责任人',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '部门表';


DROP TABLE
IF EXISTS um_user;

CREATE TABLE um_user (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	department_code VARCHAR (50) NOT NULL COMMENT '部门编码',
	user_name VARCHAR (50) NOT NULL UNIQUE COMMENT '用户名',
	`password` VARCHAR (50) NOT NULL COMMENT '密码',
	real_name VARCHAR (50) NOT NULL COMMENT '真实姓名',
	`status` VARCHAR (50) NOT NULL COMMENT '用户状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '用户表';