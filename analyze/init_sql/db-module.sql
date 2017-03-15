/*
id int primary key AUTO_INCREMENT COMMENT '主键',
uid varchar(50) not null  COMMENT 'uuid',
`code` varchar(50) not null COMMENT '编码',
create_user varchar(50) not null COMMENT '创建人',
create_time datetime not null COMMENT '创建时间',
update_user varchar(50) not null COMMENT '最后修改人',
update_time datetime not null COMMENT '最后修改时间'
*/
DROP DATABASE
IF EXISTS dbmodule;

CREATE DATABASE dbmodule DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE dbmodule;

DROP TABLE
IF EXISTS dm_database;

CREATE TABLE dm_database (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	`name` VARCHAR (100) NOT NULL COMMENT '名称',
	en_name VARCHAR (100) NOT NULL COMMENT '英文名称',
	url VARCHAR (200) NOT NULL COMMENT '访问地址',
	`comment` VARCHAR (100) DEFAULT '' COMMENT '描述',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE db_uniq_key (`code`, en_name, url) COMMENT '唯一键约束'
) COMMENT '数据库维护表';

DROP TABLE
IF EXISTS dm_table;

CREATE TABLE dm_table (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	db_code VARCHAR (50) NOT NULL COMMENT '数据库编码',
	`name` VARCHAR (100) NOT NULL COMMENT '名称',
	`comment` VARCHAR (100) DEFAULT '' COMMENT '描述',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE db_table_uniq (`code`, db_code) COMMENT '唯一键约束'
) COMMENT '数据表维护表';

DROP TABLE
IF EXISTS dm_column;

CREATE TABLE dm_column (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	table_code VARCHAR (50) NOT NULL COMMENT '数据表编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	type VARCHAR (50) NOT NULL COMMENT '类型',
	default_value VARCHAR (100) DEFAULT '' COMMENT '默认值',
	`comment` VARCHAR (100) DEFAULT '' COMMENT '描述',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE table_col_uniq (`code`, table_code) COMMENT '唯一约束'
) COMMENT '数据表列维护表';

DROP TABLE
IF EXISTS dm_column_type;

CREATE TABLE dm_column_type (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (100) NOT NULL COMMENT '名称',
	en_name VARCHAR (100) NOT NULL COMMENT '英文名称',
	`comment` VARCHAR (100) DEFAULT '' COMMENT '描述',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '数据表列类型维护表';

DROP TABLE
IF EXISTS dm_table_index;

CREATE TABLE dm_table_index (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	table_code VARCHAR (50) NOT NULL COMMENT '数据表编码',
	`name` VARCHAR (100) NOT NULL COMMENT '名称',
	en_name VARCHAR (100) NOT NULL COMMENT '英文名称',
	content VARCHAR (500) NOT NULL COMMENT '关联列数组',
	`comment` VARCHAR (100) DEFAULT '' COMMENT '描述',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE table_index_uniq (`code`, table_code) COMMENT '唯一约束'
) COMMENT '数据表索引维护表';

DROP TABLE
IF EXISTS dm_table_sql;

DROP TABLE
IF EXISTS dm_table_sql;

CREATE TABLE dm_table_sql (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	table_code VARCHAR (50) NOT NULL COMMENT '关联表编码',
	`name` VARCHAR (100) NOT NULL COMMENT '名称',
	en_name VARCHAR (100) NOT NULL COMMENT '英文名称',
	`comment` VARCHAR (100) DEFAULT '' COMMENT '描述',
	content text COMMENT 'sql内容',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE table_sql_uniq (`code`, table_code) COMMENT '唯一约束'
) COMMENT '数据表操作sql维护表';

