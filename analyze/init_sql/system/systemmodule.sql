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

DROP TABLE
IF EXISTS sm_code;

CREATE TABLE sm_code (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code_start` VARCHAR (100) DEFAULT '' COMMENT '编码起始',
	`date_apply` CHAR (6) DEFAULT '' COMMENT '日期参数',
	`min_number` INT (11) DEFAULT '100000' COMMENT '最小数字',
	`now_number` INT (11) DEFAULT '100000' COMMENT '当前数字',
	`code_note` VARCHAR (45) DEFAULT '' COMMENT '备注',
	`flag_date` INT (11) DEFAULT '1' COMMENT '是否日期列',
	UNIQUE code_uniq (code_start) COMMENT '编码起始唯一键约束'
) COMMENT '系统统一编码维护表';

DROP TABLE
IF EXISTS sm_define;

CREATE TABLE sm_define (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	parent_code VARCHAR (50) DEFAULT '0' COMMENT '父级编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '参数维护表';