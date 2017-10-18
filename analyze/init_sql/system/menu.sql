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


############# 页面相关 ########################
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
) COMMENT '页面';
insert into sm_page(uid,`code`,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP1000','SPG1000','菜单管理','','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP10001000','SP1000','SPG1000','菜单组管理','system/menu/group/index.htm','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP10001001','SP1000','SPG1000','菜单管理','system/menu/index.htm','admin',now(),'admin',now());
insert into sm_page(uid,`code`,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP1001','SPG1000','页面组管理','','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP10011000','SP1001','SPG1000','页面组管理','system/page/group/index.htm','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP10011001','SP1001','SPG1000','页面管理','system/page/index.htm','admin',now(),'admin',now());
insert into sm_page(uid,`code`,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP2000','SPG1000','数据管理','','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP20001001','SP2000','SPG1000','数据库管理','system/db/database/index.htm','admin',now(),'admin',now());

############# 菜单相关 ########################
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
	sort INT DEFAULT 0 COMMENT '排序',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '系统菜单';
INSERT INTO sm_menu(uid,`code`,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM1000','SMG1000','','菜单管理','admin',now(),'admin',now());
INSERT INTO sm_menu(uid,`code`,parent_code,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM10001000','SM1000','SMG1000','SP10001000','菜单组管理','admin',now(),'admin',now());
INSERT INTO sm_menu(uid,`code`,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM1001','SMG1000','','页面管理','admin',now(),'admin',now());
INSERT INTO sm_menu(uid,`code`,parent_code,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM10011000','SM1001','SMG1000','SP10011000','页面组管理','admin',now(),'admin',now());
INSERT INTO sm_menu(uid,`code`,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM1002','SMG1000','','数据管理','admin',now(),'admin',now());
INSERT INTO sm_menu(uid,`code`,parent_code,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM10021000','SM1001','SMG1000','SP20001000','数据库管理','admin',now(),'admin',now());
