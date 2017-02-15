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

DROP TABLE
IF EXISTS sm_menu;

CREATE TABLE sm_menu (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '菜单编码',
	parent_code VARCHAR (50) DEFAULT '0' COMMENT '父级编码',
	group_code VARCHAR (50) DEFAULT '' COMMENT '菜单组编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	page_code VARCHAR (50) DEFAULT '' COMMENT '菜单链接页面编码',
	icon VARCHAR (50) DEFAULT '' COMMENT '菜单图标',
	flag_able INT DEFAULT 0 COMMENT '是否可用 0 可用 1 不可用',
	is_deleted INT DEFAULT 0 COMMENT '是否已删除 0 未删除 1 已删除',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '系统菜单表';

DROP TABLE
IF EXISTS sm_menu_permission;

CREATE TABLE sm_menu_permission (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	menu_code VARCHAR (50) NOT NULL COMMENT '菜单编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
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

DROP TABLE
IF EXISTS sm_role_permission;

CREATE TABLE sm_role_permission (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	role_code VARCHAR (50) NOT NULL COMMENT '角色编码',
	menu_permission_code VARCHAR (50) NOT NULL COMMENT '菜单权限',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	UNIQUE menu_role_permission (
		role_code,
		menu_permission_code
	) COMMENT '角色访问菜单权限'
) COMMENT '角色权限';

DROP TABLE
IF EXISTS sm_page;

CREATE TABLE sm_page (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	url VARCHAR (500) NOT NULL COMMENT '链接地址',
	description text COMMENT '说明',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '页面维护表';

DROP TABLE
IF EXISTS sm_page_button;

CREATE TABLE sm_page_button (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`page_code` VARCHAR (50) NOT NULL COMMENT '页面编码',
	style_code VARCHAR (50) DEFAULT '' COMMENT '按钮样式',
	operation VARCHAR (500) COMMENT '按钮操作',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '页面按钮表';

DROP TABLE
IF EXISTS sm_button_area;

CREATE TABLE sm_button_area (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '按钮操作区域';

DROP TABLE
IF EXISTS sm_button_operation_type;

CREATE TABLE sm_button_operation_type (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '按钮操作类型';

DROP TABLE
IF EXISTS sm_button_style;

CREATE TABLE sm_button_style (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	icon VARCHAR (100) DEFAULT '' COMMENT '图标',
	style VARCHAR (200) NOT NULL COMMENT '样式',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE style_unqiue (`code`, style) COMMENT '样式唯一键约束'
) COMMENT '按钮样式';

DROP TABLE
IF EXISTS sm_page_authority;

CREATE TABLE sm_page_authority (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	page_code VARCHAR (50) NOT NULL COMMENT '页面编码',
	authority text COMMENT '权限设置 json存储',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '页面权限表';