/*
id int primary key AUTO_INCREMENT COMMENT '主键',
uid varchar(20) not null UNIQUE COMMENT 'uuid',
`code` varchar(50) not null UNIQUE COMMENT '编码',
create_user varchar(50) not null COMMENT '创建人',
create_date datetime not null COMMENT '创建时间',
update_user varchar(50) not null COMMENT '最后修改人',
update_date datetime datetime not null COMMENT '最后修改时间'
*/
DROP DATABASE
IF EXISTS flowmodule;

CREATE DATABASE flowmodule;

USE flowmodule;

DROP TABLE
IF EXISTS fm_flow_info;

CREATE TABLE fm_flow_info (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	parent_code VARCHAR (50) DEFAULT '' COMMENT '父级节点',
	`name` VARCHAR (50) NOT NULL COMMENT '流程名称',
	intro text COMMENT '流程介绍',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '业务流程';

DROP TABLE
IF EXISTS fm_flow_node;

CREATE TABLE fm_flow_node (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	flow_code VARCHAR (50) NOT NULL COMMENT '流程编码',
	`name` VARCHAR (50) NOT NULL COMMENT '流程节点名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '流程节点';

DROP TABLE
IF EXISTS fm_flow_main;

CREATE TABLE fm_flow_main (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	flow_type VARCHAR (50) NOT NULL COMMENT '审批类型',
	outer_code VARCHAR (50) NOT NULL COMMENT '审批外部编码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '审批流程';

DROP TABLE
IF EXISTS fm_flow_product;

CREATE TABLE fm_flow_product (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`flow_code` VARCHAR (50) NOT NULL COMMENT '审批流程编码',
	product_code VARCHAR (50) NOT NULL COMMENT '商品编码',
	type VARCHAR (50) NOT NULL COMMENT '审批类型 如增删改 上下架',
	previous_status VARCHAR (50) NOT NULL COMMENT '上一个状态',
	current_status VARCHAR (50) NOT NULL COMMENT '当前状态',
	last_status VARCHAR (50) NOT NULL COMMENT '下一个状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商品审批';

DROP TABLE
IF EXISTS fm_flow_event;

CREATE TABLE fm_flow_event (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`flow_code` VARCHAR (50) NOT NULL COMMENT '审批流程编码',
	`event_code` VARCHAR (50) NOT NULL COMMENT '活动编码',
	type VARCHAR (50) NOT NULL COMMENT '审批类型 如增删改 取消',
	previous_status VARCHAR (50) NOT NULL COMMENT '上一个状态',
	current_status VARCHAR (50) NOT NULL COMMENT '当前状态',
	last_status VARCHAR (50) NOT NULL COMMENT '下一个状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '活动审批';

DROP TABLE
IF EXISTS fm_flow_sku;

CREATE TABLE fm_flow_sku (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`flow_code` VARCHAR (50) NOT NULL COMMENT '审批流程编码',
	`sku_code` VARCHAR (50) NOT NULL COMMENT 'sku编码',
	type VARCHAR (50) NOT NULL COMMENT '审批类型 修改成本价，销售价，同时修改',
	previous_status VARCHAR (50) NOT NULL COMMENT '上一个状态',
	current_status VARCHAR (50) NOT NULL COMMENT '当前状态',
	last_status VARCHAR (50) NOT NULL COMMENT '下一个状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT 'sku审批';

DROP TABLE
IF EXISTS fm_flow_order;

CREATE TABLE fm_flow_order (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`flow_code` VARCHAR (50) NOT NULL COMMENT '审批流程编码',
	`sku_code` VARCHAR (50) NOT NULL COMMENT 'order_code',
	type VARCHAR (50) NOT NULL COMMENT '审批类型 退货换货',
	previous_status VARCHAR (50) NOT NULL COMMENT '上一个状态',
	current_status VARCHAR (50) NOT NULL COMMENT '当前状态',
	last_status VARCHAR (50) NOT NULL COMMENT '下一个状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '订单审批';

