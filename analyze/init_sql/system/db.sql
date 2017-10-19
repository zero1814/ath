############# 数据相关 ########################

DROP TABLE
IF EXISTS sm_database;

CREATE TABLE sm_database (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	db_code VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	db_name VARCHAR (20) NOT NULL UNIQUE COMMENT '名称',
	driver VARCHAR (100) NOT NULL COMMENT '驱动',
	url VARCHAR (200) NOT NULL COMMENT '链接地址',
	user_name VARCHAR (50) NOT NULL COMMENT '用户名',
	`password` VARCHAR (50) DEFAULT '' COMMENT '密码',
	remark VARCHAR (500) DEFAULT '' COMMENT '备注',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '数据库维护表';

insert into sm_database (uid,db_code,db_name,driver,url,user_name,`password`,remark,create_user,create_time,update_user,update_time)
values(REPLACE (UUID(), '-', ''),'loggermodule','loggermodule','com.mysql.jdbc.Driver',
'jdbc:mysql://localhost:3306/systemmodule?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull','root','','系统模块相关表','sys',now(),'sys',now());

DROP TABLE
IF EXISTS sm_table;

CREATE TABLE sm_table (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	db_code VARCHAR (50) NOT NULL COMMENT '数据库编码名称',
	table_code VARCHAR (50) NOT NULL COMMENT '数据表编码',
	table_name VARCHAR (50) NOT NULL COMMENT '数据表名称',
	type VARCHAR (50) DEFAULT 'table' COMMENT '数据表类型 table数据表 view视图',
	remark VARCHAR (500) DEFAULT '' COMMENT '备注',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE db_table (db_code, table_name) COMMENT '数据表唯一键约束'
) COMMENT '数据表维护表';

DROP TABLE
IF EXISTS sm_field;

CREATE TABLE sm_field (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	table_code VARCHAR (50) NOT NULL COMMENT '数据表编码',
	field_code VARCHAR (50) NOT NULL COMMENT '字段编码',
	field_name VARCHAR (45) NOT NULL COMMENT '字段名称',
	field_type VARCHAR (50) NOT NULL COMMENT '字段类型',
	field_type_note varchar(50) not null COMMENT '子弹类型数据库定义文本',
	field_length INT DEFAULT 0 COMMENT '字段长度',
	numeric_scale INT DEFAULT 0 COMMENT '字段小数点保留位数',
	is_nullable INT DEFAULT 0 COMMENT '是否可以为空 0 可以 1 不可以 ',
	field_default VARCHAR (20) DEFAULT '' COMMENT '字段默认值',
	field_key VARCHAR (10) DEFAULT '' COMMENT '字段索引类型',
	sort_add INT DEFAULT 0 COMMENT '排序添加',
	sort_edit INT DEFAULT 0 COMMENT '排序修改',
	sort_chart INT DEFAULT 0 COMMENT '排序列表',
	sort_book INT DEFAULT 0 COMMENT '排序展示',
	sort_inquery INT DEFAULT 0 COMMENT '排序查询',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE table_column (table_code, field_code) COMMENT '数据表字段唯一键'
) COMMENT '页面显示字段维护表';

DROP TABLE
IF EXISTS sm_field_type;

CREATE TABLE sm_field_type (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	short_name VARCHAR (50) NOT NULL COMMENT '英文简称',
	remark VARCHAR (50) NOT NULL COMMENT '备注',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '数据表字段前端显示类型';