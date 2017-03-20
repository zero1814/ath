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
IF EXISTS em_school;

CREATE TABLE em_school (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (50) NOT NULL COMMENT '名称',
	address VARCHAR (500) NOT NULL COMMENT '详细地址',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '学院表';

DROP TABLE
IF EXISTS em_class;

CREATE TABLE em_class (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	parent_code VARCHAR (50) DEFAULT '' COMMENT '父级编码',
	`name` VARCHAR (100) NOT NULL COMMENT '名称',
	school_code VARCHAR (50) NOT NULL COMMENT '学校编码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '班级名称';

DROP TABLE
IF EXISTS em_user;

CREATE TABLE em_user (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`user_name` VARCHAR (50) NOT NULL UNIQUE COMMENT '用户名',
	`password` VARCHAR (50) NOT NULL COMMENT '密码',
	type VARCHAR (50) NOT NULL COMMENT '用户类型',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '用户表';

DROP TABLE
IF EXISTS em_teacher;

CREATE TABLE em_teacher (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`user_code` VARCHAR (50) NOT NULL COMMENT '用户编码',
	`name` VARCHAR (20) NOT NULL COMMENT '姓名',
	sex INT DEFAULT 0 COMMENT '性别 0 男 1 女',
	school_code VARCHAR (50) NOT NULL COMMENT '学校编码',
	intro VARCHAR (500) DEFAULT '' COMMENT '简介',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE uniqu_teacher (user_code, school_code) COMMENT '教师唯一约束'
) COMMENT '教师表';

DROP TABLE
IF EXISTS em_student;

CREATE TABLE em_student (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`user_code` VARCHAR (50) NOT NULL UNIQUE COMMENT '用户编码',
	class_code VARCHAR (50) NOT NULL COMMENT '班级编码',
	`name` VARCHAR (20) NOT NULL COMMENT '姓名',
	sex INT DEFAULT 0 COMMENT '性别 0 男 1 女',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE uniqu_teacher (user_code, class_code) COMMENT '学生唯一约束'
) COMMENT '学生表';

DROP TABLE
IF EXISTS em_course;

CREATE TABLE em_course (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`name` VARCHAR (100) NOT NULL COMMENT '名称',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '课程科目表';

DROP TABLE
IF EXISTS em_teacher_course;

CREATE TABLE em_teacher_course (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	teacher_code VARCHAR (50) NOT NULL COMMENT '教师编码',
	course_code VARCHAR (50) NOT NULL COMMENT '课程科目编码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	UNIQUE uniqe_teacher_course (teacher_code, course_code) COMMENT '唯一约束'
) COMMENT '教师课程科目关系表';

DROP TABLE
IF EXISTS em_lesson;

CREATE TABLE em_lesson (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	`teacher_code` VARCHAR (50) NOT NULL COMMENT '教师编码',
	classes_code VARCHAR (50) NOT NULL COMMENT '班级编码',
	intro VARCHAR (500) DEFAULT '' COMMENT '课程描述',
	adjunct VARCHAR (500) DEFAULT '' COMMENT '课程附件',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '课程表';

DROP TABLE
IF EXISTS em_lesson_question;

CREATE TABLE em_lesson_question (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	lesson_code VARCHAR (50) NOT NULL COMMENT '课程编码',
	question text COMMENT '问题内容',
	flag_solve INT DEFAULT 0 COMMENT '是否已解决 0 未解决 1 已解决',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '课程学生提问';

DROP TABLE
IF EXISTS em_lesson_question_answer;

CREATE TABLE em_lesson_question_answer (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	question_code VARCHAR (50) NOT NULL COMMENT '问题编码',
	answer text COMMENT '回答内容',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '教师课程答疑';

DROP TABLE
IF EXISTS em_lesson_evaluation;

CREATE TABLE em_lesson_evaluation (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	lesson_code VARCHAR (50) NOT NULL COMMENT '课程编码',
	score INT DEFAULT 0 COMMENT '评分',
	content VARCHAR (500) DEFAULT '' COMMENT '评价内容',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '课程评价表';

DROP TABLE
IF EXISTS em_lesson_student_evaluation;

CREATE TABLE em_lesson_student_evaluation (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	lesson_code VARCHAR (50) NOT NULL COMMENT '课程编码',
	student_code VARCHAR (50) NOT NULL COMMENT '学生编码',
	score INT DEFAULT 0 COMMENT '评分',
	content VARCHAR (500) DEFAULT '' COMMENT '评价内容',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间',
	UNIQUE unique_lesson_student (lesson_code, student_code) COMMENT '唯一键约束'
) COMMENT '课程学生评价表';

DROP TABLE
IF EXISTS em_lesson_exam_paper;

CREATE TABLE em_lesson_exam (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	lesson_code VARCHAR (50) NOT NULL COMMENT '课程编码',
	exam_code VARCHAR (50) NOT NULL COMMENT '测验编码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '课程测验';

DROP TABLE
IF EXISTS em_exam_question;

CREATE TABLE em_exam_question (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	question_code VARCHAR (50) NOT NULL COMMENT '题库编码',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间'
) COMMENT '测验试卷';

DROP TABLE
IF EXISTS em_question_bank;

CREATE TABLE em_question_bank (
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	uid VARCHAR (50) NOT NULL COMMENT 'uuid',
	`code` VARCHAR (50) NOT NULL UNIQUE COMMENT '编码',
	type_code VARCHAR (50) NOT NULL COMMENT '类型',
	question text COMMENT '题目',
	question_options text COMMENT '题目选项 针对选择题',
	answer text COMMENT '答案',
	create_user VARCHAR (50) NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user VARCHAR (50) NOT NULL COMMENT '最后修改人',
	update_time datetime NOT NULL COMMENT '最后修改时间'
) COMMENT '题库';