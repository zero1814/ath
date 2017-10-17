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
IF EXISTS ordermodule;

CREATE DATABASE ordermodule DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE ordermodule;

DROP TABLE
IF EXISTS om_define;

CREATE TABLE om_define (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	parent_code VARCHAR (50) DEFAULT 0 COMMENT '父级编码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '订单模块参数表';

DROP TABLE
IF EXISTS om_order_info;

CREATE TABLE om_order_info (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	type VARCHAR (50) NOT NULL COMMENT '订单类型',
	pay_type VARCHAR (50) NOT NULL COMMENT '支付类型',
	`status` VARCHAR (50) NOT NULL COMMENT '订单状态',
	buyer_code VARCHAR (50) NOT NULL COMMENT '买家编码',
	order_source VARCHAR (50) NOT NULL COMMENT '订单来源',
	order_money DECIMAL (18, 2) DEFAULT '0.00' COMMENT '订单金额',
	payed_money DECIMAL (18, 2) DEFAULT '0.00' COMMENT '实际支付金额',
	outer_code VARCHAR (50) DEFAULT '' COMMENT '外部订单编码',
	store_code VARCHAR (50) NOT NULL COMMENT '店铺编码',
	asale_code VARCHAR (45) DEFAULT '' COMMENT '退货单号',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '订单维护表';



DROP TABLE
IF EXISTS om_order_detail;

CREATE TABLE om_order_detail (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	order_code VARCHAR (50) NOT NULL UNIQUE COMMENT '订单编码',
	sku_code VARCHAR (50) NOT NULL COMMENT '商品sku编码',
	product_code VARCHAR (50) NOT NULL COMMENT '商品编码',
	store_code VARCHAR (50) NOT NULL COMMENT '店铺编码',
	cost_price DECIMAL (18, 2) NOT NULL COMMENT '成本价',
	sell_price DECIMAL (18, 2) NOT NULL COMMENT '销售价',
	sku_num INT NOT NULL COMMENT 'sku销售数量',
	coupon_price DECIMAL (18, 2) NOT NULL COMMENT '优惠券优惠金额',
	show_price DECIMAL (18, 2) NOT NULL COMMENT '显示金额',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '订单详情表';


DROP TABLE
IF EXISTS om_order_payment;

CREATE TABLE om_order_payment (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	gateway VARCHAR (200) NOT NULL COMMENT '支付网关',
	`status` VARCHAR (50) NOT NULL COMMENT '状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '支付方式管理';

DROP TABLE
IF EXISTS om_order_returns;

CREATE TABLE om_order_returns (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	order_code VARCHAR (50) NOT NULL COMMENT '订单编码',
	return_type VARCHAR (50) NOT NULL COMMENT '退货类型',
	return_reason VARCHAR (500) NOT NULL COMMENT '退货原因',
	return_status VARCHAR (50) NOT NULL COMMENT '退货状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '订单退换货';

DROP TABLE
IF EXISTS om_order_evaluation;

CREATE TABLE om_order_evaluation (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	order_code VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	product_code VARCHAR (50) NOT NULL COMMENT '商品编码',
	sku_code VARCHAR (50) NOT NULL COMMENT '商品SKU编码',
	store_code VARCHAR (50) NOT NULL COMMENT '店铺编码',
	evaluate_type VARCHAR (50) NOT NULL COMMENT '评价类型',
	evaluate_score INT COMMENT '评价分数',
	evaluate_content VARCHAR (1000) NOT NULL COMMENT '评价内容',
	evaluate_pic text COMMENT '评价上传图片数组',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	UNIQUE order_product_sku (
		order_code,
		product_code,
		sku_code
	) COMMENT '评价唯一键约束'
) COMMENT '订单评价';

DROP TABLE
IF EXISTS om_event_info;

CREATE TABLE om_event_info (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '活动标题',
	event_type VARCHAR (50) NOT NULL COMMENT '活动类型',
	description VARCHAR (500) NOT NULL COMMENT '活动描述',
	start_time datetime NOT NULL COMMENT '开始时间',
	end_time datetime NOT NULL COMMENT '结束时间',
	event_status VARCHAR (50) NOT NULL COMMENT '活动状态',
	event_pic_url VARCHAR (200) NOT NULL COMMENT '活动图片链接地址',
	event_url VARCHAR (200) NOT NULL COMMENT '活动链接地址',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '活动';

DROP TABLE
IF EXISTS om_event_store;

CREATE TABLE om_event_store (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	event_code VARCHAR (50) NOT NULL COMMENT '活动编码',
	store_code VARCHAR (50) NOT NULL COMMENT '店铺编码',
	is_all INT DEFAULT 0 COMMENT '是否店铺商品全部参与活动，0 否 1 是',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE event_seller (event_code, store_code) COMMENT '参加活动的商户唯一键'
) COMMENT '活动商户';

DROP TABLE
IF EXISTS om_event_product;

CREATE TABLE om_event_product (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	event_code VARCHAR (50) NOT NULL COMMENT '活动编码',
	store_code VARCHAR (50) NOT NULL COMMENT '店铺编码',
	product_code VARCHAR (50) NOT NULL COMMENT '商品编码',
	product_url VARCHAR (200) NOT NULL COMMENT '活动商品链接地址',
	sku_code VARCHAR (50) NOT NULL COMMENT '商品sku编码',
	sku_pic_url VARCHAR (200) NOT NULL COMMENT '活动商品sku图片链接地址',
	event_price DECIMAL (18, 2) NOT NULL COMMENT '活动价格',
	event_sku_num INT DEFAULT 0 COMMENT '活动库存',
	sort INT DEFAULT 0 COMMENT '显示排序',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE event_seller (
		event_code,
		store_code,
		product_code,
		sku_code
	) COMMENT '参加活动的商户唯一键'
) COMMENT '活动商品';

