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
IF EXISTS systemmodule;

CREATE DATABASE systemmodule DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE systemmodule;

DROP TABLE
IF EXISTS sm_define;

CREATE TABLE sm_define (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '参数编码',
	parent_code VARCHAR (50) DEFAULT '0' COMMENT '父级编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '系统参数表';

insert into sm_define(uid,`code`,`name`,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'1000','用户相关','system',now(),'system',now());

DROP TABLE
IF EXISTS sm_menu_group;

CREATE TABLE sm_menu_group (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '菜单分组';

insert into sm_menu_group(uid,`code`,`name`,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'SMG1000','系统相关','admin',now(),'admin',now());

DROP TABLE
IF EXISTS sm_menu;

CREATE TABLE sm_menu (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '菜单编码',
	parent_code VARCHAR (50) DEFAULT '0' COMMENT '父级编码',
	group_code VARCHAR (50) DEFAULT '' COMMENT '菜单组编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	url VARCHAR (200) DEFAULT '' COMMENT '菜单链接地址',
	icon VARCHAR (50) DEFAULT '' COMMENT '菜单图标',
	flag_able INT DEFAULT 0 COMMENT '是否可用 0 可用 1 不可用',
	is_deleted INT DEFAULT 0 COMMENT '是否已删除 0 未删除 1 已删除',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '系统菜单表';

insert into sm_menu(uid,`code`,group_code,`name`,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'SM1000','SMG1000','菜单管理','system',now(),'system',now());
insert into sm_menu(uid,`code`,parent_code,group_code,`name`,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'SM1001','SM1000','SMG1000','菜单组管理','system',now(),'system',now());
insert into sm_menu(uid,`code`,parent_code,group_code,`name`,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'SM1002','SM1000','SMG1000','菜单管理','system',now(),'system',now());
insert into sm_menu(uid,`code`,group_code,`name`,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'SM2000','SMG1000','用户管理','admin',now(),'system',now());
insert into sm_menu(uid,`code`,group_code,`name`,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'SM3000','SMG1000','角色管理','admin',now(),'system',now());
insert into sm_menu(uid,`code`,parent_code,group_code,`name`,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'SM3001','SM3000','SMG1000','角色管理','system',now(),'system',now());
insert into sm_menu(uid,`code`,parent_code,group_code,`name`,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'SM3002','SM3000','SMG1000','权限管理','system',now(),'system',now());
insert into sm_menu(uid,`code`,group_code,`name`,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'SM4000','SMG1000','日志管理','system',now(),'system',now());

DROP TABLE
IF EXISTS sm_menu_permission;

CREATE TABLE sm_menu_permission (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	menu_code VARCHAR (50) NOT NULL COMMENT '菜单编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	permission text COMMENT '权限列表 json存储',
	description text COMMENT '权限描述',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '菜单权限表';

DROP TABLE
IF EXISTS sm_role;

CREATE TABLE sm_role (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '角色编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	intro text COMMENT '介绍',
	flag_able INT DEFAULT 0 COMMENT '是否可用 0 可用 1 不可用',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '角色表';
insert into sm_role(uid,`code`,`name`,intro,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'1000','超级管理员','最高权限','system',now(),'system',now());
insert into sm_role(uid,`code`,`name`,intro,create_user,create_time,update_user,update_time)values(REPLACE(UUID(),'-',''),'1001','管理员','二级管理员权限','system',now(),'system',now());

DROP TABLE
IF EXISTS sm_role_permission;

CREATE TABLE sm_role_permission (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	role_code VARCHAR (50) NOT NULL COMMENT '角色编码',
	menu_permission_code VARCHAR (50) NOT NULL COMMENT '菜单权限',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创;建时间',
	UNIQUE menu_role_permission (
		role_code,
		menu_permission_code
	) COMMENT '角色访问菜单权限'
) COMMENT '角色权限';




DROP TABLE
IF EXISTS sm_user;

CREATE TABLE sm_user (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	user_name VARCHAR (50) NOT NULL UNIQUE COMMENT '用户名',
	`password` VARCHAR (50) NOT NULL COMMENT '密码',
	real_name VARCHAR (50) NOT NULL COMMENT '真实姓名',
	type_code VARCHAR (50) NOT NULL COMMENT '类型编码',
	`status` VARCHAR (50) NOT NULL COMMENT '用户状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '用户表';

DROP TABLE
IF EXISTS sm_define;

CREATE TABLE sm_define (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	parent_code VARCHAR (50) DEFAULT '0' COMMENT '父级编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '系统模块参数表';

DROP TABLE
IF EXISTS sm_city;

CREATE TABLE sm_city (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	parent_code VARCHAR (50) NOT NULL COMMENT '父级编码',
	`name` VARCHAR (100) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '城市维护表';
