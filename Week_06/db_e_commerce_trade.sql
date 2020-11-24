/*
Navicat MySQL Data Transfer

Source Server         : 106.53.1.238
Source Server Version : 50642
Source Host           : 106.53.1.238:3306
Source Database       : db_e_commerce_trade

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2020-11-24 14:41:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_account
-- ----------------------------
DROP TABLE IF EXISTS `tb_account`;
CREATE TABLE `tb_account` (
  `account_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '账号ID',
  `account_source` int(2) NOT NULL COMMENT '账号来源（1-手机号，2-微信，3-QQ）',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `w_open_id` varchar(255) DEFAULT NULL COMMENT '微信 OpenId',
  `q_open_id` varchar(255) DEFAULT NULL COMMENT 'QQ OpenId',
  `union_id` varchar(255) DEFAULT NULL COMMENT '公众平台唯一标识',
  `we_chat` varchar(50) DEFAULT NULL COMMENT '微信号',
  `qq` varchar(50) DEFAULT NULL COMMENT 'QQ号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码（密文存储）',
  `reg_time` datetime NOT NULL COMMENT '注册时间',
  `app_id` int(10) NOT NULL COMMENT '应用标识',
  `app_type` int(2) NOT NULL COMMENT '应用类型（1-Android，2-iOS）',
  `del_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态（0-未删除，1-已删除）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账号信息表';

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `goods_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `goods_name` varchar(50) NOT NULL COMMENT '商品名称',
  `goods_price` decimal(8,2) NOT NULL COMMENT '商品价格',
  `goods_real_price` decimal(8,2) NOT NULL COMMENT '商品真实价格',
  `goods_desc` varchar(500) DEFAULT NULL COMMENT '商品简介',
  `goods_status` int(2) NOT NULL COMMENT '商品状态（1-正常，2-下架）',
  `del_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态（0-未删除，1-已删除）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息表';

-- ----------------------------
-- Table structure for tb_goods_stock
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_stock`;
CREATE TABLE `tb_goods_stock` (
  `stock_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '库存ID',
  `goods_id` int(10) NOT NULL COMMENT '商品ID',
  `goods_count` int(10) NOT NULL COMMENT '商品数量',
  `del_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态（0-未删除，1-已删除）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品库存表';

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` int(10) NOT NULL COMMENT '用户ID',
  `order_no` varchar(50) NOT NULL COMMENT '订单编号',
  `order_status` int(2) NOT NULL COMMENT '订单状态（1-准备下单，2-下单中，3-下单完成，4-取消订单，5-关闭订单）',
  `order_time` datetime NOT NULL COMMENT '下单时间',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单总价',
  `order_real_price` decimal(10,2) NOT NULL COMMENT '订单真实总价',
  `pay_time` datetime NOT NULL COMMENT '交易时间',
  `pay_price` decimal(10,2) NOT NULL COMMENT '交易总价',
  `pay_type` int(2) NOT NULL COMMENT '交易方式（1-支付宝，2-微信，3-银行卡）',
  `pay_status` int(2) NOT NULL COMMENT '交易状态（1-等待交易，2-交易完成，3-交易取消，4-交易超时，5-交易关闭）',
  `del_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态（0-未删除，1-已删除）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单信息表';

-- ----------------------------
-- Table structure for tb_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_goods`;
CREATE TABLE `tb_order_goods` (
  `order_goods_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单商品关联ID',
  `order_id` int(10) NOT NULL COMMENT '订单ID',
  `goods_id` int(10) NOT NULL COMMENT '商品ID',
  `goods_count` int(10) NOT NULL COMMENT '商品购买数量',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`order_goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单商品关联表';

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `account_id` int(10) NOT NULL COMMENT '账号ID',
  `user_status` int(2) NOT NULL COMMENT '用户状态（1-正常，2-受限，3-拉黑）',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sex` int(2) DEFAULT '0' COMMENT '性别（0-未知，1-男，2-女）',
  `head_img_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `head_img_status` int(2) DEFAULT NULL COMMENT '头像状态（1-未添加，2-审核中，3-审核成功，4-审核失败）',
  `birthday` varchar(255) DEFAULT NULL COMMENT '出生年月日',
  `del_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态（0-未删除，1-已删除）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';
