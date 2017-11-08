/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : systemmodule

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-11-08 13:52:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sm_code
-- ----------------------------
DROP TABLE IF EXISTS `sm_code`;
CREATE TABLE `sm_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(50) NOT NULL COMMENT 'uuid',
  `code_start` varchar(100) DEFAULT '' COMMENT '编码起始',
  `date_apply` char(6) DEFAULT '' COMMENT '日期参数',
  `min_number` int(11) DEFAULT '100000' COMMENT '最小数字',
  `now_number` int(11) DEFAULT '100000' COMMENT '当前数字',
  `code_note` varchar(45) DEFAULT '' COMMENT '备注',
  `flag_date` int(11) DEFAULT '1' COMMENT '是否日期列',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_uniq` (`code_start`) COMMENT '编码起始唯一键约束'
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='系统统一编码维护表';

-- ----------------------------
-- Table structure for sm_define
-- ----------------------------
DROP TABLE IF EXISTS `sm_define`;
CREATE TABLE `sm_define` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(50) NOT NULL COMMENT 'uuid',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `parent_code` varchar(50) DEFAULT '0' COMMENT '父级编码',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '最后修改人',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参数维护表';

-- ----------------------------
-- Table structure for sm_menu
-- ----------------------------
DROP TABLE IF EXISTS `sm_menu`;
CREATE TABLE `sm_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(50) NOT NULL COMMENT 'uuid',
  `code` varchar(50) NOT NULL COMMENT '菜单编码',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `parent_code` varchar(50) DEFAULT '0' COMMENT '父级编码',
  `group_code` varchar(50) DEFAULT '' COMMENT '菜单组编码',
  `page_code` varchar(50) DEFAULT '' COMMENT '页面编码',
  `icon` varchar(50) DEFAULT '' COMMENT '菜单图标',
  `flag_able` int(11) DEFAULT '0' COMMENT '是否可用 0 可用 1 不可用',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '最后修改人',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='系统菜单';

-- ----------------------------
-- Table structure for sm_menu_group
-- ----------------------------
DROP TABLE IF EXISTS `sm_menu_group`;
CREATE TABLE `sm_menu_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(50) NOT NULL COMMENT 'uid',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '最后修改人',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='菜单分组';

-- ----------------------------
-- Table structure for sm_page
-- ----------------------------
DROP TABLE IF EXISTS `sm_page`;
CREATE TABLE `sm_page` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(50) NOT NULL COMMENT 'uuid',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `url` varchar(500) DEFAULT '' COMMENT '链接地址',
  `param` varchar(500) DEFAULT '' COMMENT '参数',
  `flag_able` int(2) DEFAULT '0' COMMENT '是否可用 0 可用 1 不可用',
  `is_deleted` int(2) DEFAULT '0' COMMENT '是否已删除 0 未删除 1 已删除',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '最后修改人',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='页面维护表';

-- ----------------------------
-- Table structure for sm_role
-- ----------------------------
DROP TABLE IF EXISTS `sm_role`;
CREATE TABLE `sm_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(50) NOT NULL COMMENT 'uuid',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `en_name` varchar(50) NOT NULL COMMENT '英文简称',
  `status` varchar(50) NOT NULL COMMENT '状态',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '最后修改人',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Table structure for sm_role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sm_role_permissions`;
CREATE TABLE `sm_role_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(50) NOT NULL COMMENT 'uuid',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `en_name` varchar(50) NOT NULL COMMENT '英文简称',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '最后修改人',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Table structure for sm_user
-- ----------------------------
DROP TABLE IF EXISTS `sm_user`;
CREATE TABLE `sm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(50) NOT NULL COMMENT 'uuid',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `real_name` varchar(50) NOT NULL COMMENT '真实姓名',
  `head_pic` varchar(100) DEFAULT '' COMMENT '头像',
  `phone` varchar(50) NOT NULL COMMENT '手机号',
  `e_mail` varchar(50) NOT NULL COMMENT '电子邮箱',
  `qq` varchar(50) DEFAULT '' COMMENT 'qq号码',
  `we_chat` varchar(50) DEFAULT '' COMMENT '微信号',
  `status` varchar(50) NOT NULL COMMENT '用户状态',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '最后修改人',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户信息';

-- ----------------------------
-- Table structure for sm_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sm_user_role`;
CREATE TABLE `sm_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(50) NOT NULL COMMENT 'uuid',
  `user_code` varchar(50) NOT NULL COMMENT '用户编码',
  `role_code` varchar(50) NOT NULL COMMENT '角色编码',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_role` (`user_code`,`role_code`) COMMENT '用户角色唯一键约束'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系';

-- ----------------------------
-- Procedure structure for proc_getcode
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_getcode`;
DELIMITER ;;
CREATE DEFINER=`skip-grants user`@`skip-grants host` PROCEDURE `proc_getcode`(IN p_code_start VARCHAR(100))
BEGIN

DECLARE p_date CHAR (6);


DECLARE p_now CHAR (6);


DECLARE p_return VARCHAR (30);


DECLARE p_nowno INT;


SET p_now = DATE_FORMAt(now(), '%y%m%d');


SET p_date = ifnull(
	(
		SELECT
			a.date_apply
		FROM
			sm_code a
		WHERE
			a.code_start = p_code_start
	),
	''
);


IF (p_date = '') THEN
	INSERT INTO `sm_code` (
		`uid`,
		`code_start`,
		`date_apply`,
		`min_number`,
		`now_number`
	)
VALUES
	(
		REPLACE (uuid(), '-', ''),
		p_code_start,
		p_now,
		100000,
		100000
	);


SET p_date = p_now;


END
IF;


IF (p_date != p_now) THEN

IF length(p_date) != 6 THEN

SET p_now = '';


ELSE
	UPDATE sm_code
SET now_number = min_number,
 date_apply = p_now
WHERE
	code_start = p_code_start
AND flag_date = 1;


END
IF;


END
IF;

START TRANSACTION;


SET p_return = (
	SELECT
		now_number
	FROM
		sm_code zwwc
	WHERE
		zwwc.code_start = p_code_start FOR UPDATE
);


SET p_return = p_return + 1;

UPDATE sm_code
SET now_number = p_return
WHERE
	code_start = p_code_start;

COMMIT;

SELECT
	concat(
		p_code_start,
		p_now,
		p_return
	) AS webcode;


END
;;
DELIMITER ;
