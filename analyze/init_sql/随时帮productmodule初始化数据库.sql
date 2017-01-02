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
IF EXISTS productmodule;

CREATE DATABASE productmodule;

USE productmodule;

DROP TABLE
IF EXISTS pm_product_type;

CREATE TABLE pm_product_type (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '类型名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商品类型';

DROP TABLE
IF EXISTS pm_product_brand;

CREATE TABLE pm_product_brand (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`parent_code` VARCHAR (50) DEFAULT '' COMMENT '父级编码',
	`name_zh` VARCHAR (50) NOT NULL COMMENT '中文名称',
	name_ch VARCHAR (50) NOT NULL COMMENT '英文名称',
	icon VARCHAR (50) NOT NULL COMMENT '品牌图标',
	intro text COMMENT '品牌介绍',
	flag_enable INT DEFAULT 0 COMMENT '是否可用 0 是 1 否',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商品品牌';

DROP TABLE
IF EXISTS pm_product_info;

CREATE TABLE pm_product_info (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	short_name VARCHAR (50) DEFAULT '' COMMENT '简称',
	alias_name VARCHAR (50) DEFAULT '' COMMENT '别名',
	brand_code VARCHAR (50) NOT NULL COMMENT '品牌编码',
	type_code VARCHAR (50) NOT NULL COMMENT '类型编码',
	seller_code VARCHAR (50) NOT NULL COMMENT '商户编码',
	cost_price DECIMAL (10, 2) NOT NULL COMMENT '成品价',
	market_price DECIMAL (10, 2) NOT NULL COMMENT '市场价',
	min_sell_price DECIMAL (10, 2) NOT NULL COMMENT '最小销售价格',
	max_sell_price DECIMAL (10, 2) NOT NULL COMMENT '最大销售价格',
	tax_rate DECIMAL (10, 2) NOT NULL COMMENT '税率',
	main_picture VARCHAR (100) NOT NULL COMMENT '主图url',
	pictures VARCHAR (2000) DEFAULT '' COMMENT '组图 url数组存储',
	ad_picture VARCHAR (100) NOT NULL COMMENT '广告图片',
	ad_content text COMMENT '广告语',
	outer_code VARCHAR (100) DEFAULT '' COMMENT '外部商品编码',
	`status` VARCHAR (50) NOT NULL COMMENT '商品状态',
	validate_flag VARCHAR (50) NOT NULL COMMENT '是否为虚拟差评',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商品表';

DROP TABLE
IF EXISTS pm_product_info_extend;

CREATE TABLE pm_product_info_extend (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`product_code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	flag_payway INT DEFAULT 1 COMMENT '是否支持货到付款 0 是 1 否',
	product_volume_item VARCHAR (100) DEFAULT '' COMMENT '长宽高 json存储',
	labels VARCHAR (20) DEFAULT '' COMMENT '商品标签',
	expiry_date INT DEFAULT 0 COMMENT '保质期',
	expiry_unit VARCHAR (10) DEFAULT '' COMMENT '保质期单位',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商品扩展';

DROP TABLE
IF EXISTS pm_product_info_draft;

CREATE TABLE pm_product_info_draft (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`product_code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	product_data text COMMENT '商品信息',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商品草稿箱';

DROP TABLE
IF EXISTS pm_sku_info;

CREATE TABLE pm_sku_info (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	product_code VARCHAR (50) NOT NULL COMMENT '商品编码',
	`name` VARCHAR (50) NOT NULL COMMENT 'sku名称',
	property VARCHAR (100) NOT NULL COMMENT 'sku属性:颜色，大小等等 json存储',
	main_picture VARCHAR (100) NOT NULL COMMENT '主图url',
	pictures VARCHAR (2000) DEFAULT '' COMMENT '组图 url数组存储',
	cost_price DECIMAL (10, 2) NOT NULL COMMENT '成品价',
	market_price DECIMAL (10, 2) NOT NULL COMMENT '市场价',
	sell_price DECIMAL (10, 2) NOT NULL COMMENT '销售价',
	flag_enable INT DEFAULT 0 COMMENT '是否可用 0 是 1 否',
	stock_num INT DEFAULT 0 COMMENT '库存总数量',
	security_stock_num INT DEFAULT 0 COMMENT '安全库存',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商品sku';

DROP TABLE
IF EXISTS pm_sku_stock;

CREATE TABLE pm_sku_stock (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`sku_code` VARCHAR (50) NOT NULL UNIQUE COMMENT 'sku编码',
	store_code VARCHAR (100) NOT NULL COMMENT '库房编码集合',
	CREATE_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT 'sku库存';

DROP TABLE
IF EXISTS pm_sku_storeroom;

CREATE TABLE pm_sku_storeroom (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT 'sku编码',
	`name` VARCHAR (50) NOT NULL COMMENT '库房名称',
	area_code VARCHAR (50) NOT NULL COMMENT '地区编码',
	address VARCHAR (500) NOT NULL COMMENT '详细地址',
	stock_num INT DEFAULT 0 COMMENT '库存',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT 'sku库房';

DROP TABLE
IF EXISTS pm_event_info;

CREATE TABLE pm_event_info (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '活动名称',
	start_time datetime NOT NULL COMMENT '',
	end_time datetime NOT NULL COMMENT '结束时间',
	event_scorpe text COMMENT '活动范围',
	even_scope_code COMMENT '活动范围编码',
	type VARCHAR (50) NOT NULL COMMENT '活动类型',
	`status` VARCHAR (50) NOT NULL COMMENT '状态',
	main_picture VARCHAR (50) NOT NULL COMMENT '活动主图',
	intro text COMMENT '获取介绍',
	url VARCHAR (50) NOT NULL COMMENT '活动链接url',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '活动信息';

DROP TABLE
IF EXISTS pm_event_product_item;

CREATE TABLE pm_event_product_item (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`event_code` VARCHAR (50) NOT NULL UNIQUE COMMENT '活动编码',
	product_code VARCHAR (50) NOT NULL COMMENT 'sku编码',
	seller_price DECIMAL (10, 2) NOT NULL COMMENT '活动销售价格',
	favorable_price DECIMAL (10, 2) NOT NULL COMMENT '优惠价',
	event_stock INT NOT NULL COMMENT '活动库存',
	purchase_num INT NOT NULL COMMENT '限购数量',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '活动产品关系';