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
IF EXISTS sm_user;

CREATE TABLE sm_user (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	user_name VARCHAR (50) NOT NULL UNIQUE COMMENT '用户名',
	`password` VARCHAR (50) NOT NULL COMMENT '密码',
	real_name VARCHAR (50) NOT NULL COMMENT '真实姓名',
	head_pic VARCHAR (100) DEFAULT '' COMMENT '头像',
	phone VARCHAR (50) NOT NULL COMMENT '手机号',
	mail VARCHAR (50) NOT NULL COMMENT '电子邮箱',
	qq VARCHAR (50) DEFAULT '' COMMENT 'qq号码',
	weixin VARCHAR (50) DEFAULT '' COMMENT '微信号',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '用户表';

DROP TABLE
IF EXISTS sm_role;

CREATE TABLE sm_role (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '角色表';

DROP TABLE
IF EXISTS sm_user_role;

CREATE TABLE sm_user_role (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	user_code VARCHAR (50) NOT NULL COMMENT '用户编码',
	role_code VARCHAR (50) NOT NULL COMMENT '角色编码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	UNIQUE user_role (user_code, role_code) COMMENT '用户角色唯一键约束'
) COMMENT '用户角色关系表';

DROP TABLE
IF EXISTS sm_page_group;

CREATE TABLE sm_page_group (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	parent_code varchar(50) DEFAULT '0' COMMENT '父级编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '页面分组';

insert into sm_page_group(uid,`code`,`name`,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SPG1000','菜单相关','admin',now(),'admin',now());

DROP TABLE
IF EXISTS sm_page;

CREATE TABLE sm_page (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	parent_code varchar(50) DEFAULT '0' COMMENT '父级编码',
	group_code VARCHAR (50) NOT NULL COMMENT '页面分组编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	url VARCHAR (500) NOT NULL COMMENT '链接地址',
	param VARCHAR (500) DEFAULT '' COMMENT '参数',
	flag_able INT (2) DEFAULT 0 COMMENT '是否可用 0 可用 1 不可用',
	is_deleted INT (2) DEFAULT 0 COMMENT '是否已删除 0 未删除 1 已删除',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '页面表';

insert into sm_page(uid,`code`,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP1000','SPG1000','菜单管理','','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP10001000','SP1000','SPG1000','菜单组管理','system/menu/group/index.htm','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP10001001','SP1000','SPG1000','菜单管理','system/menu/index.htm','admin',now(),'admin',now());
insert into sm_page(uid,`code`,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP1001','SPG1000','页面组管理','','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP10011000','SP1001','SPG1000','页面组管理','system/page/group/index.htm','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP10011001','SP1001','SPG1000','页面管理','system/page/index.htm','admin',now(),'admin',now());


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

INSERT INTO sm_menu_group (uid,`code`,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SMG1000','后台管理','admin',now(),'admin',now());

DROP TABLE
IF EXISTS sm_menu;

CREATE TABLE sm_menu (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '菜单编码',
	parent_code VARCHAR (50) DEFAULT '0' COMMENT '父级编码',
	group_code VARCHAR (50) DEFAULT '' COMMENT '菜单组编码',
	page_code VARCHAR (50) DEFAULT '' COMMENT '页面编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	icon VARCHAR (50) DEFAULT '' COMMENT '菜单图标',
	flag_able INT DEFAULT 0 COMMENT '是否可用 0 可用 1 不可用',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '系统菜单表';
INSERT INTO sm_menu(uid,`code`,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM1000','SMG1000','SP1000','菜单管理','admin',now(),'admin',now());
INSERT INTO sm_menu(uid,`code`,parent_code,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM10001000','SM1000','SMG1000','SP10001000','菜单组管理','admin',now(),'admin',now());
INSERT INTO sm_menu(uid,`code`,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM1001','SMG1000','SP1000','页面管理','admin',now(),'admin',now());
INSERT INTO sm_menu(uid,`code`,parent_code,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM10011000','SM1001','SMG1000','SP10011001','页面组管理','admin',now(),'admin',now());