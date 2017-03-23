/**
id int primary key AUTO_INCREMENT COMMENT '主键',
uid varchar(50) not null COMMENT 'uuid',
`code` varchar(50) not null UNIQUE COMMENT '编码',
create_user varchar(50) not null COMMENT '创建人',
create_time datetime not null COMMENT '创建时间',
update_user varchar(50) not null COMMENT '最后修改人',
update_time datetime not null COMMENT '最后修改时间'
*/
DROP DATABASE
IF EXISTS educationmodule;

CREATE DATABASE educationmodule DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE educationmodule;

DROP TABLE
IF EXISTS em_define;

CREATE TABLE em_define (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	parent_code VARCHAR (50) DEFAULT '' COMMENT '父级编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '参数表';

DROP TABLE
IF EXISTS em_user;

CREATE TABLE em_user (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`username` VARCHAR (50) NOT NULL UNIQUE COMMENT '用户名',
	`password` VARCHAR (50) NOT NULL COMMENT '密码',
	`status` VARCHAR (50) NOT NULL COMMENT '用户状态 初始化定义为正常',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '用户表';

DROP TABLE
IF EXISTS em_user_extend;

CREATE TABLE em_user_extend (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	real_name VARCHAR (50) NOT NULL COMMENT '真实姓名',
	type_code VARCHAR (50) NOT NULL COMMENT '用户类型：教师，学生',
	wechat VARCHAR (100) DEFAULT '' COMMENT '微信',
	microblog VARCHAR (100) DEFAULT '' COMMENT '微博',
	qq VARCHAR (20) DEFAULT '' COMMENT 'qq',
	head_pic VARCHAR (200) DEFAULT '' COMMENT '头像',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '用户扩展表';

DROP TABLE
IF EXISTS em_class_student;

CREATE TABLE em_class_student (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	class_code VARCHAR (50) NOT NULL COMMENT '班级编码',
	`student_code` VARCHAR (50) NOT NULL COMMENT '学生编码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	UNIQUE class_student (class_code, student_code) COMMENT '班级学生唯一键约束'
) COMMENT '班级学生关系表';

DROP TABLE
IF EXISTS em_lesson;

CREATE TABLE em_lesson (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	type_code VARCHAR (50) NOT NULL COMMENT '课程类型',
	teacher_code VARCHAR (50) NOT NULL COMMENT '授课教师',
	start_time datetime COMMENT '开始时间',
	length INT DEFAULT 0 COMMENT '课程时长',
	intro VARCHAR (200) DEFAULT '' COMMENT '课程简介',
	adjunct VARCHAR (500) DEFAULT '' COMMENT '附件',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '课程表';

DROP TABLE
IF EXISTS em_lesson_extend;

CREATE TABLE em_lesson_extend (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	video_url VARCHAR (500) NOT NULL COMMENT '视频播放地址',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '课程扩展表';

DROP TABLE
IF EXISTS em_lesson_sign;

CREATE TABLE em_lesson_sign (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	lesson_code VARCHAR (50) NOT NULL UNIQUE COMMENT '课程编码',
	student_code VARCHAR (50) NOT NULL COMMENT '学生编码',
	create_time datetime NOT NULL COMMENT '创建时间',
	UNIQUE lesson_student (lesson_code, student_code) COMMENT '学生课程签到唯一键约束'
) COMMENT '课程签到记录';