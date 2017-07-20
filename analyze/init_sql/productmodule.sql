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
IF EXISTS productmodule;

CREATE DATABASE productmodule DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE productmodule;

DROP TABLE
IF EXISTS pm_define;

CREATE TABLE pm_product_type (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	parent_code VARCHAR (50) DEFAULT '' COMMENT '父级编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商品参数表，存储类型，状态，标签等';

DROP TABLE
IF EXISTS pm_product_info;

CREATE TABLE pm_product_info (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	store_code VARCHAR (50) NOT NULL COMMENT '店铺编码',
	product_type VARCHAR (50) NOT NULL COMMENT '商品类型',
	product_status VARCHAR (50) NOT NULL COMMENT '商品状态',
	cost_price DECIMAL (18, 2) DEFAULT '0.00' COMMENT '成本价',
	min_sell_price DECIMAL (18, 2) DEFAULT '0.00' COMMENT '销售价格最小',
	max_sell_price DECIMAL (18, 2) DEFAULT '0.00' COMMENT '销售价格最大',
	product_url VARCHAR (500) NOT NULL COMMENT '商品链接地址',
	product_pic VARCHAR (500) NOT NULL COMMENT '商品图片',
	product_label VARCHAR (500) DEFAULT '' COMMENT '商品标签,数组存储',
	product_specification VARCHAR (1000) DEFAULT '' COMMENT '商品规格',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商品表';

DROP TABLE
IF EXISTS pm_product_drafts;

CREATE TABLE pm_product_drafts (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	store_code VARCHAR (50) NOT NULL COMMENT '店铺编码',
	product_type VARCHAR (50) NOT NULL COMMENT '商品类型',
	product_status VARCHAR (50) NOT NULL COMMENT '商品状态',
	cost_price DECIMAL (18, 2) DEFAULT '0.00' COMMENT '成本价',
	min_sell_price DECIMAL (18, 2) DEFAULT '0.00' COMMENT '销售价格最小',
	max_sell_price DECIMAL (18, 2) DEFAULT '0.00' COMMENT '销售价格最大',
	product_url VARCHAR (500) NOT NULL COMMENT '商品链接地址',
	product_pic VARCHAR (500) NOT NULL COMMENT '商品图片',
	product_label VARCHAR (500) DEFAULT '' COMMENT '商品标签,数组存储',
	product_specification VARCHAR (1000) DEFAULT '' COMMENT '商品规格',
	product_json text COMMENT '保存商品信息',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商品草稿箱';

DROP TABLE
IF EXISTS pm_sku_info;

CREATE TABLE pm_sku_info (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	product_code VARCHAR (50) NOT NULL COMMENT '商品编码',
	cost_price DECIMAL (18, 2) DEFAULT '0.00' COMMENT '成本价',
	market_price DECIMAL (18, 2) DEFAULT '0.00' COMMENT '市场价',
	sell_price DECIMAL (18, 2) DEFAULT '0.00' COMMENT '销售价',
	stock_num INT DEFAULT 0 COMMENT '库存数',
	security_stock_num INT DEFAULT 0 COMMENT '安全库存',
	sku_pic_url VARCHAR (200) DEFAULT '' COMMENT '产品图片',
	sku_status VARCHAR (50) NOT NULL COMMENT 'sku状态',
	mini_order INT DEFAULT 1 COMMENT '起订数量',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商品sku表';

DROP TABLE
IF EXISTS pm_authority_logo;

CREATE TABLE pm_authority_logo (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	pic_url VARCHAR (500) NOT NULL COMMENT '图片链接地址',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商品权威标识';

