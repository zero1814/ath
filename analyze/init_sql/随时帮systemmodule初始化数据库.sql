/*
id int primary key AUTO_INCREMENT COMMENT '主键',
uid varchar(50) not null UNIQUE COMMENT 'uuid',
`code` varchar(50) not null UNIQUE COMMENT '编码',
create_user varchar(50) not null COMMENT '创建人',
create_time datetime not null COMMENT '创建时间',
update_user varchar(50) not null COMMENT '最后修改人',
update_time datetime not null COMMENT '最后修改时间'
*/
DROP DATABASE
IF EXISTS systemmodule;

CREATE DATABASE systemmodule;

USE systemmodule;

DROP TABLE
IF EXISTS sm_define;

CREATE TABLE sm_define (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '参数编码',
	parent_code VARCHAR (50) DEFAULT '' COMMENT '父级编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '系统参数表';

DROP TABLE
IF EXISTS sm_menu_group;

CREATE TABLE sm_menu_group (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '菜单分组';

DROP TABLE
IF EXISTS sm_menu;

CREATE TABLE sm_menu (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '菜单编码',
	parent_code VARCHAR (50) DEFAULT '' COMMENT '父级编码',
	group_code VARCHAR (50) DEFAULT '' COMMENT '',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	url VARCHAR (100) DEFAULT '' COMMENT '菜单链接地址',
	flag_able INT DEFAULT 0 COMMENT '是否可用 0 可用 1 不可用',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '系统菜单表';

DROP TABLE
IF EXISTS sm_menu_permission;

CREATE TABLE sm_menu_permission (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '菜单权限编码',
	menu_code VARCHAR (50) NOT NULL COMMENT '菜单编码',
	setting text COMMENT '菜单权限 json存储，例如:{add:0,end:1,del:0}',
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

DROP TABLE
IF EXISTS sm_role_permission;

CREATE TABLE sm_role_permission (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	role_code VARCHAR (50) NOT NULL COMMENT '角色编码',
	permission_code VARCHAR (50) NOT NULL COMMENT '权限编码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	UNIQUE KEY `role_permission` (
		`role_code`,
		`permission_code`
	)
) COMMENT '角色权限表';

DROP TABLE
IF EXISTS sm_server_group;

CREATE TABLE sm_server_group (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '服务器分类';

DROP TABLE
IF EXISTS sm_server;

CREATE TABLE sm_server (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '服务器名称',
	ip VARCHAR (50) NOT NULL COMMENT '服务器ip地址',
	group_code VARCHAR (50) NOT NULL COMMENT '服务器分组',
	description text COMMENT '描述',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '系统服务器';