/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-07-27 13:46:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_daohang
-- ----------------------------
DROP TABLE IF EXISTS `t_daohang`;
CREATE TABLE `t_daohang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `daohang_title` varchar(200) DEFAULT NULL,
  `daohang_url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_daohang
-- ----------------------------
INSERT INTO `t_daohang` VALUES ('16', '首頁', 'http://localhost:8080/wangzhanWeb/html/index.html');
INSERT INTO `t_daohang` VALUES ('17', '公告展示页', 'list.html?type=2');
INSERT INTO `t_daohang` VALUES ('18', '学校主页', 'http://www.nenu.edu.cn/');
INSERT INTO `t_daohang` VALUES ('19', '新闻展示页', 'list.html?type=1');
INSERT INTO `t_daohang` VALUES ('20', 'et', 'asa');

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `author` varchar(500) DEFAULT NULL COMMENT '作者',
  `content` varchar(500) DEFAULT NULL COMMENT '内容',
  `sort_id` int(11) DEFAULT NULL COMMENT '类别id',
  `write_time` datetime DEFAULT NULL COMMENT '创建时间',
  `alter_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES ('44', 'aa', 'admin', '1111', '2', '2019-07-26 22:17:56', '2019-07-26 22:17:56');
INSERT INTO `t_news` VALUES ('45', 'bbb', 'admin', 'bbbbss', '2', '2019-07-26 22:19:46', '2019-07-27 09:13:59');
INSERT INTO `t_news` VALUES ('46', '123', 'admin', '日前，由中共长春市委教育工作委员会组织的2018年度长春市“高校文明杯”评选活动圆满结束，我校在活动中获得多项荣誉。', '1', '2019-07-27 08:25:17', '2019-07-27 13:34:41');
INSERT INTO `t_news` VALUES ('47', '我校2017-2018学年本科生奖学金颁奖典礼暨第十九届“理想与成才”报告团首场报告会圆满落幕 ', 'admin', '12月22日，党委学生工作部、学生处组织召开了2017-2018学年本科生奖学金颁奖典礼暨第十九届“理想与成才”报告团首场报告会。中共长春市委宣传部高教处处长陶树海、吉林省教育厅民族教育处副处长隗峰、东北师范大学党委书记杨晓慧、校长刘益春、党委副书记王延', '1', '2019-07-27 08:25:30', '2019-07-27 13:08:00');
INSERT INTO `t_news` VALUES ('48', 'eee', 'admin', 'eee', '1', '2019-07-27 08:25:35', '2019-07-27 08:25:35');
INSERT INTO `t_news` VALUES ('49', 'rrr', 'admin', 'rrr', '1', '2019-07-27 08:25:40', '2019-07-27 08:25:40');
INSERT INTO `t_news` VALUES ('50', 'ttt', 'admin', 'ttt', '1', '2019-07-27 08:25:45', '2019-07-27 08:25:45');
INSERT INTO `t_news` VALUES ('51', 'yyy', 'admin', 'yyy', '1', '2019-07-27 08:25:50', '2019-07-27 08:25:50');
INSERT INTO `t_news` VALUES ('52', 'uuu', 'admin', 'uuu', '1', '2019-07-27 08:25:56', '2019-07-27 08:25:56');
INSERT INTO `t_news` VALUES ('54', 'sss', 'admin', 'sss', '1', '2019-07-27 08:26:11', '2019-07-27 08:26:11');
INSERT INTO `t_news` VALUES ('57', 'xxx', 'admin', 'xxx', '1', '2019-07-27 08:26:36', '2019-07-27 08:26:36');
INSERT INTO `t_news` VALUES ('59', 'www', 'admin', 'www', '2', '2019-07-27 09:39:37', '2019-07-27 09:39:37');
INSERT INTO `t_news` VALUES ('60', '111', 'admin', '111', '1', '2019-07-27 13:19:55', '2019-07-27 13:19:55');
INSERT INTO `t_news` VALUES ('61', 'qwe', 'admin', 'qwe', '1', '2019-07-27 13:35:11', '2019-07-27 13:35:11');
INSERT INTO `t_news` VALUES ('62', 'aaa', 'admin', 'aaa', '1', '2019-07-27 13:35:27', '2019-07-27 13:35:27');

-- ----------------------------
-- Table structure for t_sort
-- ----------------------------
DROP TABLE IF EXISTS `t_sort`;
CREATE TABLE `t_sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sort_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_sort
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '账号',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `image` varchar(50) DEFAULT NULL COMMENT '头像',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `state` int(10) DEFAULT NULL COMMENT '0-游客    1-待审核   2-管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('16', 'test', 'e10adc3949ba59abbe56e057f20f883e', 'upload/a7fd9a48-f2cf-4b74-8d54-572e781bce0f.jpg', '12', '2019-07-26 21:19:44', '0');
INSERT INTO `t_user` VALUES ('17', 'admin', 'e10adc3949ba59abbe56e057f20f883e', null, '22', '2019-07-26 21:29:02', '0');
INSERT INTO `t_user` VALUES ('18', 'zxc', '5fa72358f0b4fb4f2c5d7de8c9a41846', 'upload/c3b0742d-310a-47b7-8ed0-1030fc412189.jpg', '12', '2019-07-27 08:27:41', '0');
INSERT INTO `t_user` VALUES ('19', 'wangying', 'e10adc3949ba59abbe56e057f20f883e', 'upload/8aa36e87-a80d-4c34-872b-72a605c375fb.jpg', '12', '2019-07-27 13:08:29', '0');
INSERT INTO `t_user` VALUES ('20', 'yyy', 'f0a4058fd33489695d53df156b77c724', 'upload/b5d75d11-7123-4ac5-864a-b4239a4df1c5.jpg', '12', '2019-07-27 13:39:08', '0');
