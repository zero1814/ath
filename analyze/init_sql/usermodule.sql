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

CREATE TABLE um_define (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	parent_code VARCHAR (50) DEFAULT '0' COMMENT '父级编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '用户模块参数表';

DROP TABLE
IF EXISTS um_store_info;

CREATE TABLE um_store_info (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL UNIQUE COMMENT '名称',
	store_url VARCHAR (200) NOT NULL COMMENT '店铺首页链接地址',
	store_pic_url VARCHAR (200) NOT NULL COMMENT '店铺图片链接地址',
	`status` VARCHAR (50) NOT NULL COMMENT '状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '店铺表';

DROP TABLE
IF EXISTS um_user_collect;

CREATE TABLE um_user_collect (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	user_code VARCHAR (50) NOT NULL COMMENT '用户编码',
	collect_type VARCHAR (50) NOT NULL COMMENT '收藏类型',
	collect_code VARCHAR (50) NOT NULL COMMENT '收藏编码：商品编码 店铺编码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	UNIQUE user_collect (
		user_code,
		collect_type,
		collect_code
	) COMMENT '用户收藏唯一键'
) COMMENT '用户收藏';

DROP TABLE
IF EXISTS um_user_address;

CREATE TABLE um_user_address (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	user_code VARCHAR (50) NOT NULL COMMENT '用户编码',
	province_city VARCHAR (50) NOT NULL COMMENT '省市',
	area VARCHAR (50) NOT NULL COMMENT '地区',
	address VARCHAR (500) NOT NULL COMMENT '详细地址',
	`status` VARCHAR (50) NOT NULL COMMENT '状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '用户地址管理';