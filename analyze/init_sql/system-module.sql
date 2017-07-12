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
IF EXISTS systemmodule;

CREATE DATABASE systemmodule DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE systemmodule;


############# 页面相关 ########################
DROP TABLE
IF EXISTS sm_page_group;

CREATE TABLE sm_page_group (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	parent_code varchar(50) DEFAULT '0' COMMENT '父级编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '页面分组';

insert into sm_page_group(uid,`code`,`name`,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SPG1000','菜单相关','admin',now(),'admin',now());

DROP TABLE
IF EXISTS sm_page;

CREATE TABLE sm_page (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL UNIQUE COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	parent_code varchar(50) DEFAULT '0' COMMENT '父级编码',
	group_code VARCHAR (50) NOT NULL COMMENT '页面分组编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	url VARCHAR (500) NOT NULL COMMENT '链接地址',
	param VARCHAR (500) DEFAULT '' COMMENT '参数',
	flag_able INT (2) DEFAULT 0 COMMENT '是否可用 0 可用 1 不可用',
	is_deleted INT (2) DEFAULT 0 COMMENT '是否已删除 0 未删除 1 已删除',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '页面表';
insert into sm_page(uid,`code`,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP1000','SPG1000','菜单管理','','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP10001000','SP1000','SPG1000','菜单组管理','system/menu/group/index.htm','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP10001001','SP1000','SPG1000','菜单管理','system/menu/index.htm','admin',now(),'admin',now());
insert into sm_page(uid,`code`,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP1001','SPG1000','页面组管理','','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP10011000','SP1001','SPG1000','页面组管理','system/page/group/index.htm','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP10011001','SP1001','SPG1000','页面管理','system/page/index.htm','admin',now(),'admin',now());
insert into sm_page(uid,`code`,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP2000','SPG1000','数据管理','','admin',now(),'admin',now());
insert into sm_page(uid,`code`,parent_code,group_code,`name`,url,create_user,create_time,update_user,update_time)values(REPLACE (UUID(), '-', ''),'SP20001001','SP2000','SPG1000','数据库管理','system/db/database/index.htm','admin',now(),'admin',now());


############# 菜单相关 ########################
DROP TABLE
IF EXISTS sm_menu_group;

CREATE TABLE sm_menu_group (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '菜单分组';

INSERT INTO sm_menu_group (uid,`code`,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SMG1000','后台管理','admin',now(),'admin',now());

DROP TABLE
IF EXISTS sm_menu;

CREATE TABLE sm_menu (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '菜单编码',
	parent_code VARCHAR (50) DEFAULT '0' COMMENT '父级编码',
	group_code VARCHAR (50) DEFAULT '' COMMENT '菜单组编码',
	page_code VARCHAR (50) DEFAULT '' COMMENT '页面编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	icon VARCHAR (50) DEFAULT '' COMMENT '菜单图标',
	flag_able INT DEFAULT 0 COMMENT '是否可用 0 可用 1 不可用',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '系统菜单表';
INSERT INTO sm_menu(uid,`code`,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM1000','SMG1000','SP1000','菜单管理','admin',now(),'admin',now());
INSERT INTO sm_menu(uid,`code`,parent_code,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM10001000','SM1000','SMG1000','SP10001000','菜单组管理','admin',now(),'admin',now());
INSERT INTO sm_menu(uid,`code`,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM1001','SMG1000','SP1000','页面管理','admin',now(),'admin',now());
INSERT INTO sm_menu(uid,`code`,parent_code,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM10011000','SM1001','SMG1000','SP10011000','页面组管理','admin',now(),'admin',now());
INSERT INTO sm_menu(uid,`code`,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM1002','SMG1000','SP2000','数据管理','admin',now(),'admin',now());
INSERT INTO sm_menu(uid,`code`,parent_code,group_code,page_code,`name`,create_user,create_time,update_user,update_time)VALUES(REPLACE (UUID(), '-', ''),'SM10021000','SM1001','SMG1000','SP20001000','数据库管理','admin',now(),'admin',now());

############# 用户相关 ########################

DROP TABLE
IF EXISTS sm_user;

CREATE TABLE sm_user (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL COMMENT '编码',
	user_name VARCHAR (50) NOT NULL UNIQUE COMMENT '用户名',
	`password` VARCHAR (50) NOT NULL COMMENT '密码',
	real_name VARCHAR (50) NOT NULL COMMENT '真实姓名',
	head_pic VARCHAR (100) DEFAULT '' COMMENT '头像',
	phone VARCHAR (50) NOT NULL COMMENT '手机号',
	e_mail VARCHAR (50) NOT NULL COMMENT '电子邮箱',
	qq VARCHAR (50) DEFAULT '' COMMENT 'qq号码',
	we_chat VARCHAR (50) DEFAULT '' COMMENT '微信号',
	`status` VARCHAR (50) NOT NULL COMMENT '用户状态',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '用户信息表';

insert into sm_user (uid,`code`,user_name,`password`,real_name,phone,e_mail,`status`,create_user,create_time,update_user,update_time)
values(REPLACE (UUID(), '-', ''),'SU1000','admin',MD5('888888'),'管理员','13011112222','test@test.cms','0','sys',now(),'sys',now());

DROP TABLE
IF EXISTS sm_role;

CREATE TABLE sm_role (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '角色表';

DROP TABLE
IF EXISTS sm_menu_role;

CREATE TABLE sm_menu_role (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`menu_code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`role_code` VARCHAR (50) NOT NULL UNIQUE COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间'
) COMMENT '菜单角色关系表';

DROP TABLE
IF EXISTS sm_user_role;

CREATE TABLE sm_user_role (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	user_code VARCHAR (50) NOT NULL COMMENT '用户编码',
	role_code VARCHAR (50) NOT NULL COMMENT '角色编码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	UNIQUE user_role (user_code, role_code) COMMENT '用户角色唯一键约束'
) COMMENT '用户角色关系表';

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
values(REPLACE (UUID(), '-', ''),'systemmodule','systemmodule','com.mysql.jdbc.Driver',
'jdbc:mysql://localhost:3306/systemmodule?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull','root','','系统模块相关表','sys',now(),'sys',now());

insert into sm_database (uid,db_code,db_name,driver,url,user_name,`password`,remark,create_user,create_time,update_user,update_time)
values(REPLACE (UUID(), '-', ''),'loggermodule','loggermodule','com.mysql.jdbc.Driver',
'jdbc:mysql://localhost:3306/systemmodule?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull','root','','系统模块相关表','sys',now(),'sys',now());

DROP TABLE
IF EXISTS sm_table;

CREATE TABLE sm_table (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	db_code VARCHAR (50) NOT NULL COMMENT '数据库编码名称',
	table_code VARCHAR (50) NOT NULL UNIQUE COMMENT '数据表编码',
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
IF EXISTS sm_filed;

CREATE TABLE sm_filed (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	table_code VARCHAR (50) NOT NULL COMMENT '数据表编码',
	field_code VARCHAR (50) NOT NULL UNIQUE COMMENT '字段编码',
	field_name VARCHAR (45) NOT NULL COMMENT '字段名称',
	field_type VARCHAR (50) NOT NULL COMMENT '字段类型',
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