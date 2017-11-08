/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : systemmodule

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-11-08 13:52:33
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
-- Records of sm_code
-- ----------------------------
INSERT INTO `sm_code` VALUES ('1', 'd6416a1ac07011e7a0c154e1ad664e0c', 'SMG', '171106', '100000', '100002', '', '1');
INSERT INTO `sm_code` VALUES ('2', '381b6814c07611e7a0c154e1ad664e0c', 'SM', '171108', '100000', '100001', '', '1');
INSERT INTO `sm_code` VALUES ('3', 'bd147babc07e11e7a0c154e1ad664e0c', 'SP', '171108', '100000', '100001', '', '1');
INSERT INTO `sm_code` VALUES ('4', '1172756fc39e11e7824e54e1ad664e0c', null, '171107', '100000', '100000', '', '1');
INSERT INTO `sm_code` VALUES ('5', '55abdd7ec39e11e7824e54e1ad664e0c', null, '171107', '100000', '100000', '', '1');
INSERT INTO `sm_code` VALUES ('6', '55b4b6a0c39e11e7824e54e1ad664e0c', 'SU', '171107', '100000', '100005', '', '1');
INSERT INTO `sm_code` VALUES ('7', '056c60bac3a011e7824e54e1ad664e0c', null, '171107', '100000', '100000', '', '1');
INSERT INTO `sm_code` VALUES ('8', '1c72acb8c3a011e7824e54e1ad664e0c', null, '171107', '100000', '100000', '', '1');
INSERT INTO `sm_code` VALUES ('9', '36e5ac4cc3a011e7824e54e1ad664e0c', null, '171107', '100000', '100000', '', '1');
INSERT INTO `sm_code` VALUES ('10', '3be6be8cc3a011e7824e54e1ad664e0c', null, '171107', '100000', '100000', '', '1');
INSERT INTO `sm_code` VALUES ('11', 'c5d2fc98c42011e7824e54e1ad664e0c', 'SR', '171108', '100000', '100005', '', '1');

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
-- Records of sm_define
-- ----------------------------

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
-- Records of sm_menu
-- ----------------------------
INSERT INTO `sm_menu` VALUES ('1', '228d3877c06911e7a0c154e1ad664e0c', 'SM1000', '菜单相关', '0', 'SMG1000', '', '', '0', '0', 'init', '2017-11-03 15:32:24', 'init', '2017-11-03 15:32:24');
INSERT INTO `sm_menu` VALUES ('2', '2297f8d2c06911e7a0c154e1ad664e0c', 'SM10001000', '分组管理', 'SM1000', 'SMG1000', 'SP1000', '', '0', '0', 'init', '2017-11-03 15:32:24', 'init', '2017-11-03 15:32:24');
INSERT INTO `sm_menu` VALUES ('3', '229e4c24c06911e7a0c154e1ad664e0c', 'SM10001001', '菜单管理', 'SM1000', 'SMG1000', 'SP1001', '', '0', '0', 'init', '2017-11-03 15:32:24', 'init', '2017-11-03 15:32:24');
INSERT INTO `sm_menu` VALUES ('4', '22a77cb5c06911e7a0c154e1ad664e0c', 'SM10001002', '页面管理', 'SM1000', 'SMG1000', 'SP1002', '', '0', '0', 'init', '2017-11-03 15:32:24', 'init', '2017-11-03 15:32:24');
INSERT INTO `sm_menu` VALUES ('5', '22b0b241c06911e7a0c154e1ad664e0c', 'SM1001', '用户相关', '0', 'SMG1000', '', '', '0', '0', 'init', '2017-11-03 15:32:24', 'init', '2017-11-03 15:32:24');
INSERT INTO `sm_menu` VALUES ('6', '22b70e87c06911e7a0c154e1ad664e0c', 'SM1002', '参数相关', '0', 'SMG1000', '', '', '0', '0', 'init', '2017-11-03 15:32:24', 'init', '2017-11-03 15:32:24');
INSERT INTO `sm_menu` VALUES ('9', '6f33a145e35f4d4fa4e97934067c8947', 'SM171107100001', '用户管理', 'SM1001', 'SMG1000', 'SP171107100001', '', '0', '1', 'SU1000', '2017-11-07 09:21:55', 'SU1000', '2017-11-07 09:21:55');
INSERT INTO `sm_menu` VALUES ('10', 'cb70efc9a7fd49e2a5d5a26626349dc2', 'SM171108100001', '角色管理', 'SM1001', 'SMG1000', 'SP171108100001', '', '0', '2', 'SU1000', '2017-11-08 08:57:13', 'SU1000', '2017-11-08 08:57:13');

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
-- Records of sm_menu_group
-- ----------------------------
INSERT INTO `sm_menu_group` VALUES ('1', 'b8664225c04311e7a0c154e1ad664e0c', 'SMG1000', 'cms', 'init', '2017-11-03 11:04:34', 'init', '2017-11-03 11:04:34');

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
-- Records of sm_page
-- ----------------------------
INSERT INTO `sm_page` VALUES ('1', 'dc465c83c04411e7a0c154e1ad664e0c', 'SP1000', '分组管理', 'system/menu/group/index.htm', '', '1', '0', 'init', '2017-11-03 11:12:44', 'test', '2017-11-03 18:09:41');
INSERT INTO `sm_page` VALUES ('2', 'dc5362d5c04411e7a0c154e1ad664e0c', 'SP1001', '菜单管理', 'system/menu/index.htm', '', '0', '0', 'init', '2017-11-03 11:12:44', 'init', '2017-11-03 11:12:44');
INSERT INTO `sm_page` VALUES ('3', 'dc5b8f96c04411e7a0c154e1ad664e0c', 'SP1002', '页面管理', 'system/menu/page/index.htm', '', '0', '0', 'init', '2017-11-03 11:12:44', 'init', '2017-11-03 11:12:44');
INSERT INTO `sm_page` VALUES ('6', '8feea1331443430691c178160ed9a973', 'SP171107100001', '用户管理', 'system/user/index.htm', '', '0', '0', 'SU1000', '2017-11-07 09:21:31', 'SU1000', '2017-11-07 09:21:31');
INSERT INTO `sm_page` VALUES ('7', '0242b570b7ee4cb7bdf8017e622d8579', 'SP171108100001', '角色管理', 'system/user/role/index.htm', '', '0', '0', 'SU1000', '2017-11-08 08:56:55', 'SU1000', '2017-11-08 08:56:55');

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
-- Records of sm_role
-- ----------------------------
INSERT INTO `sm_role` VALUES ('2', 'b1ec5812eac345808a933a61f78aebad', 'SR171108100004', 'admin01', 'admin', '0', 'SU1000', '2017-11-08 09:13:00', 'SU1000', '2017-11-08 09:14:09');
INSERT INTO `sm_role` VALUES ('3', '7f00deaf137349b09f483b4783ceccdc', 'SR171108100005', 'user', 'user', '0', 'SU1000', '2017-11-08 10:52:58', 'SU1000', '2017-11-08 10:52:58');

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
-- Records of sm_role_permissions
-- ----------------------------

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
-- Records of sm_user
-- ----------------------------
INSERT INTO `sm_user` VALUES ('1', '022e100dbee811e7a0c154e1ad664e0c', 'SU1000', 'admin', '21218cca77804d2ba1922c33e0151105', '管理员', '', '13011112222', 'test@test.cms', '', '', '0', 'sys', '2017-11-01 17:35:33', 'sys', '2017-11-01 17:35:33');
INSERT INTO `sm_user` VALUES ('2', '1d703ec4cbc744a382b62a0d092dadc5', 'SU171107100001', 'user', 'e10adc3949ba59abbe56e057f20f883e', '123456', 'system/user/head/405492129f05429a802c2c2268a073ab.jpg', '13425521335', '22', '2', '2', '0', 'SU171107100001', '2017-11-07 17:30:42', 'SU1000', '2017-11-07 17:47:30');

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
-- Records of sm_user_role
-- ----------------------------

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
