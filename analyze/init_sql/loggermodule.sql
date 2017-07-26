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
IF EXISTS loggermodule;

CREATE DATABASE loggermodule DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE loggermodule;

DROP TABLE
IF EXISTS lm_login;

CREATE TABLE lm_login (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	user_code VARCHAR (50) NOT NULL COMMENT '用户编码',
	ip VARCHAR (50) NOT NULL COMMENT 'ip地址',
	login_time datetime NOT NULL COMMENT '登录时间'
) COMMENT '用户登录日志';

DROP TABLE
IF EXISTS lm_operate;

CREATE TABLE lm_operate (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	operate_type VARCHAR (50) NOT NULL COMMENT '操作类型',
	class_path VARCHAR (100) NOT NULL COMMENT '操作类及方法路径',
	request_data VARCHAR (500) NOT NULL COMMENT '请求参数',
	response_data VARCHAR (500) NOT NULL COMMENT '响应参数',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间'
) COMMENT '用户操作日志';

DROP TABLE
IF EXISTS lm_order_status;

CREATE TABLE lm_order_status (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	order_code VARCHAR (50) NOT NULL COMMENT '订单编码',
	order_json text COMMENT '订单信息',
	current_status VARCHAR (50) NOT NULL COMMENT '订单当前状态',
	next_status VARCHAR (50) NOT NULL COMMENT '订单下一阶段状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间'
) COMMENT '订单状态更新日志';

DROP TABLE
IF EXISTS lm_order_return;

CREATE TABLE lm_order_return (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	order_code VARCHAR (50) NOT NULL COMMENT '订单编码',
	return_code VARCHAR (50) NOT NULL COMMENT '退换货编码',
	`status` VARCHAR (50) NOT NULL COMMENT '状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间'
) COMMENT '退换货日志';

DROP TABLE
IF EXISTS lm_product_flow;

CREATE TABLE lm_product_flow (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	product_code VARCHAR (50) NOT NULL COMMENT '商品编码',
	product_json text COMMENT '审批时的商品信息',
	flow_status VARCHAR (50) NOT NULL COMMENT '审批状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间'
) COMMENT '商品审核日志';

DROP TABLE
IF EXISTS lm_store_flow;

CREATE TABLE lm_store_flow (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	store_code VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	store_json text COMMENT '店铺详情',
	flow_status VARCHAR (50) NOT NULL COMMENT '审核状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间'
) COMMENT '店铺审核日志';

DROP TABLE
IF EXISTS lm_event_flow;

CREATE TABLE lm_event_flow (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	event_code VARCHAR (50) NOT NULL COMMENT '活动编码',
	event_json text COMMENT '活动详情',
	flow_status VARCHAR (50) NOT NULL COMMENT '活动状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间'
) COMMENT '活动审核日志';

DROP TABLE
IF EXISTS lm_event_status;

CREATE TABLE lm_event_status (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	event_code VARCHAR (50) NOT NULL COMMENT '活动编码',
	before_status varchar(50) not null COMMENT '活动之前状态',
	current_status VARCHAR (50) NOT NULL COMMENT '当前活动状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间'
) COMMENT '活动状态变更日志';

