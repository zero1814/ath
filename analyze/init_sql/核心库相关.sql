/*
id int primary key AUTO_INCREMENT COMMENT '主键',
uid varchar(50) not null UNIQUE COMMENT 'uuid',
`code` varchar(50) not null UNIQUE COMMENT '编码',
create_user varchar(50) not null COMMENT '创建人',
create_time datetime not null COMMENT '创建时间',
update_user varchar(50) not null COMMENT '最后修改人',
update_time datetime not null COMMENT '最后修改时间'
*/
USE kernelmodule;

DROP TABLE
IF EXISTS cm_menu;

CREATE TABLE cm_menu (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	`parent_code` VARCHAR (50) NOT NULL COMMENT '父级编码',
	`name` VARCHAR (100) NOT NULL COMMENT '名称',
	href VARCHAR (500) DEFAULT '' COMMENT '链接地址',
	is_usable INT DEFAULT 0 COMMENT '是否可用 0 可用 1 不可用',
	is_deleted INT DEFAULT 0 COMMENT '是否已删除 0 未删除 1 已删除',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE menu_unique (`code`, `name`) COMMENT '菜单唯一键约束'
) COMMENT '菜单维护表';

DROP TABLE
IF EXISTS cm_page;

CREATE TABLE cm_page (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	parent_code VARCHAR (50) NOT NULL COMMENT '父级编码',
	`name` VARCHAR (100) NOT NULL COMMENT '名称',
	url VARCHAR (500) NOT NULL COMMENT '链接url',
	table_code VARCHAR (50) NOT NULL COMMENT '所属表',
	is_usable INT DEFAULT 0 COMMENT '是否可用 0 可用 1 不可用',
	is_deleted INT DEFAULT 0 COMMENT '是否已删除 0 未删除 1 已删除',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE page_unique (`code`, `name`, url) COMMENT '页面唯一键约束'
) COMMENT '页面维护表';

DROP TABLE
IF EXISTS cm_button_area;

CREATE TABLE cm_button_area (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '按钮所属区域';

DROP TABLE
IF EXISTS cm_button_type;

CREATE TABLE cm_button_type (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	style VARCHAR (500) DEFAULT '' COMMENT '按钮样式',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '按钮类型';

DROP TABLE
IF EXISTS cm_page_button;

CREATE TABLE cm_page_button (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	page_code VARCHAR (50) NOT NULL COMMENT '页面编码',
	area_code VARCHAR (50) NOT NULL COMMENT '按钮区域编码',
	type_code VARCHAR (50) NOT NULL COMMENT '按钮类型编码',
	href VARCHAR (500) DEFAULT '' COMMENT '按钮超链接地址',
	click VARCHAR (500) DEFAULT '' COMMENT '按钮点击事件',
	is_usable INT DEFAULT 0 COMMENT '是否可用 0 可用 1 不可用',
	is_deleted INT DEFAULT 0 COMMENT '是否已删除 0 未删除 1 已删除',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE page_button_unique (`code`, `name`, page_code) COMMENT '页面按钮唯一键约束'
) COMMENT '页面按钮维护表';