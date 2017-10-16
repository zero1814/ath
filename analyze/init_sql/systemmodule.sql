/*
id int primary key AUTO_INCREMENT COMMENT '主键',
uid varchar(50) not null COMMENT 'uuid',
`code` varchar(50) not null COMMENT '编码',
create_user varchar(50) not null COMMENT '创建人',
create_time datetime not null COMMENT '创建时间',
update_user varchar(50) not null COMMENT '最后修改人',
update_time datetime not null COMMENT '最后修改时间',
UNIQUE uniq_code (`code`) COMMENT '唯一键约束'
*/
DROP DATABASE
IF EXISTS systemmodule;

CREATE DATABASE systemmodule DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE systemmodule;

DROP TABLE
IF EXISTS sm_page;

CREATE TABLE sm_page (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	parent_code VARCHAR (50) NOT NULL COMMENT '父级编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	`status` VARCHAR (50) NOT NULL COMMENT '状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE uniq_code (`code`) COMMENT '唯一键约束'
) COMMENT '页面维护表';

DROP TABLE
IF EXISTS sm_page_permissions;

CREATE TABLE sm_page_permissions (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	page_code VARCHAR (50) NOT NULL COMMENT '页面编码',
	`name` VARCHAR (50) NOT NULL COMMENT '权限名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE uniq_code (`code`, page_code) COMMENT '唯一键约束'
) COMMENT '权限权限表';

DROP TABLE
IF EXISTS sm_menu;

CREATE TABLE sm_menu (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	parent_code VARCHAR (50) NOT NULL COMMENT '父级编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	page_code VARCHAR (50) NOT NULL COMMENT '页面编码',
	`status` VARCHAR (50) NOT NULL COMMENT '状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE uniq_code (`code`) COMMENT '唯一键约束'
) COMMENT '菜单维护表';

DROP TABLE
IF EXISTS sm_user;

CREATE TABLE sm_user (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	user_name VARCHAR (50) NOT NULL COMMENT '用户',
	`password` VARCHAR (50) NOT NULL COMMENT '密码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE uniq_code (`code`) COMMENT '唯一键约束'
) COMMENT '系统用户表';

DROP TABLE
IF EXISTS sm_role;

CREATE TABLE sm_role (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE uniq_code (`code`) COMMENT '唯一键约束'
) COMMENT '系统角色表';

DROP TABLE
IF EXISTS sm_role_permissions;

CREATE TABLE sm_role_permissions (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`role_code` VARCHAR (50) NOT NULL COMMENT '编码',
	`page_code` VARCHAR (50) NOT NULL COMMENT '页面编码',
	page_permissions VARCHAR (50) NOT NULL COMMENT '页面权限编码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	UNIQUE uniq_code (
		`role_code`,
		page_code,
		page_permissions
	) COMMENT '唯一键约束'
) COMMENT '角色权限表';

DROP TABLE
IF EXISTS sm_user_role;

CREATE TABLE sm_user_role (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`user_code` VARCHAR (50) NOT NULL COMMENT '用户编码',
	`role_code` VARCHAR (50) NOT NULL COMMENT '角色编码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	UNIQUE uniq_code (`user_code`, `role_code`) COMMENT '唯一键约束'
) COMMENT '用户角色关系表';