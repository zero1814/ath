/*
id int primary key AUTO_INCREMENT COMMENT '主键',
uid varchar(20) not null UNIQUE COMMENT 'uuid',
`code` varchar(50) not null UNIQUE COMMENT '编码',
create_user varchar(50) not null COMMENT '创建人',
create_date datetime not null COMMENT '创建时间',
update_user varchar(50) not null COMMENT '最后修改人',
update_date datetime datetime not null COMMENT '最后修改时间'
*/
DROP DATA
IF EXISTS usermodule;

CREATE DATABASE usermodule;

USE usermodule;

DROP TABLE
IF EXISTS um_seller_info;

CREATE TABLE um_seller_info (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '用户编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	short_name VARCHAR (50) DEFAULT '' COMMENT '简称',
	icon VARCHAR (100) NOT NULL COMMENT '商标',
	legal_person VARCHAR (50) NOT NULL COMMENT '法人姓名',
	principal_name VARCHAR (50) NOT NULL COMMENT '负责人姓名',
	principal_phone VARCHAR (20) NOT NULL COMMENT '负责人电话',
	valid_documentation_type VARCHAR (50) NOT NULL COMMENT '有效证件类型编码',
	documentation_number VARCHAR (50) NOT NULL COMMENT '证件号码',
	valid_documentation_pic VARCHAR (200) NOT NULL COMMENT '证件照，正反面',
	telephone VARCHAR (20) NOT NULL COMMENT '座机',
	mobile_phone VARCHAR (20) NOT NULL COMMENT '联系电话',
	`status` VARCHAR (50) NOT NULL COMMENT '商户状态',
	brokerage DECIMAL (2, 2) COMMENT '佣金比例',
	type VARCHAR (50) NOT NULL COMMENT '商户类型',
	bank_code VARCHAR (50) NOT NULL COMMENT '开户行银行编码',
	bank_branch_name VARCHAR (100) NOT NULL COMMENT '开户行支行名称',
	bank_branch_address VARCHAR (200) NOT NULL COMMENT '开户行支行地址',
	intro text COMMENT '店面介绍',
	out_date datetime NOT NULL COMMENT '有效期至',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商户表';

DROP TABLE
IF EXISTS um_seller_info_extends;

CREATE TABLE um_seller_info_extends (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '用户编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	short_name VARCHAR (50) DEFAULT '' COMMENT '简称',
	icon VARCHAR (100) NOT NULL COMMENT '商标',
	legal_person VARCHAR (50) NOT NULL COMMENT '法人姓名',
	principal_name VARCHAR (50) NOT NULL COMMENT '负责人姓名',
	principal_phone VARCHAR (20) NOT NULL COMMENT '负责人电话',
	valid_documentation_type VARCHAR (50) NOT NULL COMMENT '有效证件类型编码',
	documentation_number VARCHAR (50) NOT NULL COMMENT '证件号码',
	valid_documentation_pic VARCHAR (200) NOT NULL COMMENT '证件照，正反面',
	telephone VARCHAR (20) NOT NULL COMMENT '座机',
	mobile_phone VARCHAR (20) NOT NULL COMMENT '联系电话',
	`status` VARCHAR (50) NOT NULL COMMENT '商户状态',
	brokerage DECIMAL (2, 2) COMMENT '佣金比例',
	type VARCHAR (50) NOT NULL COMMENT '商户类型',
	bank_code VARCHAR (50) NOT NULL COMMENT '开户行银行编码',
	bank_branch_name VARCHAR (100) NOT NULL COMMENT '开户行支行名称',
	bank_branch_address VARCHAR (200) NOT NULL COMMENT '开户行支行地址',
	intro text COMMENT '店面介绍',
	out_date datetime NOT NULL COMMENT '有效期至',
	area_code VARCHAR (50) NOT NULL COMMENT '地区编码',
	register_address VARCHAR (200) NOT NULL COMMENT '注册地址',
	current_address VARCHAR (200) NOT NULL COMMENT '现公司地址',
	contact_address VARCHAR (200) NOT NULL COMMENT '联系地址',
	registered_capital INT NOT NULL COMMENT '注册资金',
	registered_capital_currency_type VARCHAR (50) NOT NULL COMMENT '注册资金币种',
	business_scope text NOT NULL COMMENT '经营范围',
	business_license_pic VARCHAR (100) NOT NULL COMMENT '营业执照图片',
	business_license VARCHAR (50) NOT NULL COMMENT '营业执照号',
	return_address VARCHAR (200) NOT NULL COMMENT '退货地址',
	return_postcode VARCHAR (10) NOT NULL COMMENT '退货邮编',
	return_contact_user VARCHAR (20) NOT NULL COMMENT '退货联系人电话',
	return_contact_telephone VARCHAR (200) NOT NULL COMMENT '退货联系人地址',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商户扩展表';

DROP TABLE
IF EXISTS um_seller_info_draft CREATE TABLE um_seller_info_draft (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`seller_code` VARCHAR (50) NOT NULL UNIQUE COMMENT '商户编码',
	seller_data text COMMENT '商户信息json存储',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '商户草稿箱';

DROP TABLE
IF EXISTS um_bank_info;

CREATE TABLE um_bank_info (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (20) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_date datetime datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '银行';

