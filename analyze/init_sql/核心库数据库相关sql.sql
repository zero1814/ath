/*
id int primary key AUTO_INCREMENT COMMENT '主键',
uid varchar(50) not null UNIQUE COMMENT 'uuid',
`code` varchar(50) not null UNIQUE COMMENT '编码',
create_user varchar(50) not null COMMENT '创建人',
create_time datetime not null COMMENT '创建时间',
update_user varchar(50) not null COMMENT '最后修改人',
update_time datetime not null COMMENT '最后修改时间'
*/
DROP DATABASE
IF EXISTS kernelmodule;

CREATE DATABASE kernelmodule DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE kernelmodule;

DROP TABLE
IF EXISTS cm_database;

CREATE TABLE cm_database (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '数据库名称',
	en_name VARCHAR (50) NOT NULL COMMENT '英文名称',
	url VARCHAR (500) NOT NULL COMMENT '数据库连接地址',
	username VARCHAR (50) NOT NULL COMMENT '数据库访问用户名',
	`password` VARCHAR (50) NOT NULL COMMENT '数据库访问用户名',
	initial_size INT DEFAULT 0 COMMENT '初始化时建立物理连接的个数',
	max_active INT DEFAULT 10 COMMENT '最大连接池数量',
	min_idle INT DEFAULT 0 COMMENT '最小连接池数量',
	max_wait INT DEFAULT 60000 COMMENT '获取连接时最大等待时间，单位毫秒',
	test_on_borrow INT DEFAULT 1 COMMENT '申请连接时执行validationQuery检测连接是否有效， 做了这个配置会降低性能 0是 1否',
	test_on_return INT DEFAULT 1 COMMENT '归还连接时执行validationQuery检测连接是否有效， 做了这个配置会降低性能 0是 1否',
	test_while_idle INT DEFAULT 0 COMMENT '议配置为true，不影响性能，并且保证安全性 0是 1否',
	time_between_eviction_runs_millis INT DEFAULT 60000 COMMENT '有两个含义： 1) Destroy线程会检测连接的间隔时间 2) testWhileIdle的判断依据，详细看testWhileIdle属性的说明',
	min_evictable_idle_time_millis INT DEFAULT 60000 COMMENT '配置一个连接在池中最小生存的时间，单位是毫秒',
	remove_abandoned INT DEFAULT 0 COMMENT '对于长时间不使用的连接强制关闭 0是 1否',
	remove_abandoned_timeout INT DEFAULT 1800 COMMENT '超过多长时间后开始关闭空闲连接',
	log_abandoned INT DEFAULT 0 COMMENT '将当前关闭动作记录到日志 0 是 1 否',
	filters VARCHAR (50) DEFAULT 'wall' COMMENT '属性类型是字符串，通过别名的方式配置扩展插件， 常用的插件有： 监控统计用的filter:stat 日志用的filter:log4j 防御sql注入的filter:wall',
	`comment` VARCHAR (500) DEFAULT '' COMMENT '描述',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE db_unique (en_name, url) COMMENT '数据库唯一链接地址'
) COMMENT '数据库维护表';

DROP TABLE
IF EXISTS cm_table;

CREATE TABLE cm_table (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '表名称',
	`comment` VARCHAR (500) DEFAULT '' COMMENT '描述',
	db_code VARCHAR (50) NOT NULL COMMENT '数据库编码',
	db_name VARCHAR (100) NOT NULL COMMENT '数据库名称',
	`engine` VARCHAR (50) DEFAULT 'InnoDB' COMMENT '表引擎',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE db_table (`code`, db_code) COMMENT '数据库表唯一键约束'
) COMMENT '数据表维护表';

DROP TABLE
IF EXISTS cm_column_type;

CREATE TABLE cm_column_type (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	en_name VARCHAR (50) NOT NULL COMMENT '英文简称',
	value_area VARCHAR (100) DEFAULT '' COMMENT '值范围 json存储',
	`comment` VARCHAR (500) DEFAULT '' COMMENT '描述',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '列类型维护表';

DROP TABLE
IF EXISTS cm_column;

CREATE TABLE cm_column (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '列名称',
	type_code VARCHAR (50) NOT NULL COMMENT '列类型',
	type_name VARCHAR (50) NOT NULL COMMENT '列类型名称',
	`comment` VARCHAR (100) DEFAULT '' COMMENT '列描述',
	default_value VARCHAR (100) DEFAULT '' COMMENT '列默认值',
	table_code VARCHAR (50) NOT NULL COMMENT '表编码',
	table_name VARCHAR (50) NOT NULL COMMENT '表名称',
	db_code VARCHAR (50) NOT NULL COMMENT '数据库编码',
	db_name VARCHAR (50) NOT NULL COMMENT '数据库名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE table_column (`code`, table_code) COMMENT '表列唯一键约束'
) COMMENT '数据表列维护表';

DROP TABLE
IF EXISTS cm_table_constraints_type;

CREATE TABLE cm_table_constraints_type (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	en_name VARCHAR (50) NOT NULL COMMENT '英文名称',
	`comment` VARCHAR (500) DEFAULT '' COMMENT '描述',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE index_type (`code`, en_name) COMMENT '索引类型'
) COMMENT '表约束类型维护表';

DROP TABLE
IF EXISTS cm_table_constraints;

CREATE TABLE cm_table_constraints (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	en_name VARCHAR (50) NOT NULL COMMENT '英文名称',
	type_code VARCHAR (50) NOT NULL COMMENT '索引类型',
	type_name VARCHAR (50) NOT NULL COMMENT '索引名称',
	table_code VARCHAR (50) NOT NULL COMMENT '表编码',
	table_name VARCHAR (100) NOT NULL COMMENT '表名称',
	`comment` VARCHAR (500) DEFAULT '' COMMENT '描述',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE table_index (`code`, table_code) COMMENT '表索引唯一键约束'
) COMMENT '数据表相关约束表';