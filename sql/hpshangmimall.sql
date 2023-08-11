/*
 Navicat Premium Data Transfer

 Source Server         : wyt
 Source Server Type    : MySQL
 Source Server Version : 80029 (8.0.29)
 Source Host           : localhost:3306
 Source Schema         : hpshangmimall

 Target Server Type    : MySQL
 Target Server Version : 80029 (8.0.29)
 File Encoding         : 65001

 Date: 11/08/2023 14:13:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
# 创建数据库
create database hpshangmimall;
use hpshangmimall;
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins`
(
    `id`       int                                                     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
    `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 105
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '管理员'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins`
VALUES (1, 'admin', '202cb962ac59075b964b07152d234b70');
INSERT INTO `admins`
VALUES (2, '777', '202cb962ac59075b964b07152d234b70');
INSERT INTO `admins`
VALUES (4, 'wyt123', '202cb962ac59075b964b07152d234b70');

-- ----------------------------
-- Table structure for carts
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts`
(
    `id`      int NOT NULL AUTO_INCREMENT,
    `amount`  int NOT NULL DEFAULT 0 COMMENT '数量',
    `good_id` int NOT NULL COMMENT '商品ID',
    `user_id` int NOT NULL DEFAULT 0 COMMENT '用户ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 41
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '购物车'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of carts
-- ----------------------------
INSERT INTO `carts`
VALUES (1, 1, 6, 1);
INSERT INTO `carts`
VALUES (2, 1, 32, 1);
INSERT INTO `carts`
VALUES (3, 1, 5, 1);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`
(
    `id`      int UNSIGNED                                            NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `cover`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '封面',
    `name`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '名称',
    `intro`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '介绍',
    `spec`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '规格',
    `price`   int                                                     NOT NULL DEFAULT 0 COMMENT '价格',
    `stock`   int                                                     NOT NULL DEFAULT 0 COMMENT '库存',
    `sales`   int                                                     NOT NULL DEFAULT 0 COMMENT '销量',
    `content` text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '详情',
    `type_id` int                                                     NOT NULL DEFAULT 0 COMMENT '分类ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 42
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '商品'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods`
VALUES (1, '../upload/ed1fc78f-4dc8-4015-b4e5-48ba5b150bb1.jpg', '四川耙耙柑 酸甜甘香 柔嫩多汁', '皮薄易剥 肉质软嫩',
        '约500g', 13, 9, 2, '', 1);
INSERT INTO `goods`
VALUES (2, '../upload/1-2.jpg', '红心火龙果', NULL, '750g-1kg/两个', 28, 10, 2, '', 1);
INSERT INTO `goods`
VALUES (3, '../upload/1-3.jpg', '皇冠梨 松软多汁', '果肉甘甜 细腻无渣', '约500g', 9, 10, 3, '', 1);
INSERT INTO `goods`
VALUES (4, '../upload/1-4.jpg', '西州蜜瓜', '果肉厚质 中心橘红', '约1kg-1.5kg 一个', 30, 7, 7, '', 1);
INSERT INTO `goods`
VALUES (5, '../upload/1-5.jpg', '小台芒果 自然生长 生态种植', '皮薄核小 果肉丰厚', '约500g', 26, 8, 7, '', 1);
INSERT INTO `goods`
VALUES (6, '../upload/1-6.jpg', '栖霞苹果 爽脆清甜', '肉质紧密 味道甘甜', '约550g/2个', 9, 2, 14, '', 1);
INSERT INTO `goods`
VALUES (7, '../upload/1-7.jpg', '龙眼/桂圆 新鲜水果 汁多味甜', '增强记忆 消除疲劳', '约500g', 18, 10, 7, '', 1);
INSERT INTO `goods`
VALUES (8, '../upload/1-8.jpg', '广西百香果 香气浓郁 甜酸可口', '果香浓郁 搭配蜂蜜更美味', '2颗/份', 5, 10, 8, '', 1);
INSERT INTO `goods`
VALUES (9, '../upload/1-9.jpg', '美早樱桃 果大核小 饱满均匀', '堪比车厘子的美味', '约300g/盒', 36, 10, 9, '', 1);
INSERT INTO `goods`
VALUES (10, '../upload/1-10.jpg', '智利红提 珍贵品种 品质上等', '紧实爆汁 果肉新鲜', '约500g', 18, 10, 10, '', 1);
INSERT INTO `goods`
VALUES (11, '../upload/1-11.jpg', '尖椒 烧烤食材 新鲜蔬菜', '农家种植 健康饮食', '约300g', 5, 10, 0, '', 1);
INSERT INTO `goods`
VALUES (12, '../upload/1-12.jpg', '荷兰瓜 生态种植 自然生长', '颜色翠绿，鲜嫩爽脆', '约300g', 5, 10, 0, '', 1);
INSERT INTO `goods`
VALUES (13, '../upload/1-13.jpg', '小白菜 清脆鲜嫩 清甜回甘', '农家种植 找回儿时味道', '约500g', 10, 10, 0, '', 1);
INSERT INTO `goods`
VALUES (14, '../upload/1-14.jpg', '菠菜 口感鲜嫩 入口清香', '不催熟 生长周期长', '约300g', 12, 10, 0, '', 1);
INSERT INTO `goods`
VALUES (15, '../upload/2-1.jpg', '福成尚品前腱子', NULL, '1000g', 99, 10, 0, '', 2);
INSERT INTO `goods`
VALUES (16, '../upload/2-2.jpg', '牦牛精肉2斤+ 牦牛肋排2斤', '自然生长', '2kg', 226, 10, 0, '', 2);
INSERT INTO `goods`
VALUES (17, '../upload/2-3.jpg', '巴美草香猪后臀尖 原味原香', '精致美味，解锁味觉记忆', '约500g', 32, 10, 0, '', 2);
INSERT INTO `goods`
VALUES (18, '../upload/2-4.jpg', '农畉猪肉-猪脊骨 肉厚骨细', '骨鲜髓足', '约500g', 13, 10, 0, '', 2);
INSERT INTO `goods`
VALUES (19, '../upload/2-5.jpg', '一品江村黄鸡', '味道鲜美，口感软嫩弹滑', '约1kg', 46, 10, 0, '', 2);
INSERT INTO `goods`
VALUES (20, '../upload/2-6.jpg', '正大单冻鸡翅根 精选种鸡', '富有弹性', '约1kg', 35, 10, 0, '', 2);
INSERT INTO `goods`
VALUES (21, '../upload/3-1.jpg', '五梁红有机种植 大米', '五常市有机大米', '5kg', 68, 10, 0, '', 3);
INSERT INTO `goods`
VALUES (22, '../upload/3-2.jpg', '五常大米珠光黄', NULL, '5kg', 60, 10, 0, '', 3);
INSERT INTO `goods`
VALUES (23, '../upload/3-3.jpg', '五得利强筋雪花小麦粉', NULL, '2.5kg', 32, 10, 0, '', 3);
INSERT INTO `goods`
VALUES (24, '../upload/3-4.jpg', '香满园美味富强小麦粉', NULL, '5kg', 21, 10, 0, '', 3);
INSERT INTO `goods`
VALUES (25, '../upload/3-5.jpg', '老农帝国 黑豆 自然成熟', NULL, '2.5kg', 82, 10, 0, '', 3);
INSERT INTO `goods`
VALUES (26, '../upload/3-6.jpg', '中畅佳禾 大麦 自然生长', NULL, '400g', 59, 10, 0, '', 3);
INSERT INTO `goods`
VALUES (27, '../upload/4-1.jpg', '百威啤酒 经典灌装 小麦醇正拉罐', NULL, '500ml*3', 26, 10, 0, '', 4);
INSERT INTO `goods`
VALUES (28, '../upload/4-2.jpg', 'Perrier巴黎水天然含气矿泉水 开启生活新方式', '天然气泡', '330ml', 9, 10, 0, '', 4);
INSERT INTO `goods`
VALUES (29, '../upload/4-3.jpg', '吉吉黑糖', NULL, '玫瑰花味180g', 23, 9, 1, '', 4);
INSERT INTO `goods`
VALUES (30, '../upload/4-4.jpg', '北冰洋汽水', '桔汁汽水330ml', NULL, 5, 10, 0, '', 4);
INSERT INTO `goods`
VALUES (31, '../upload/4-5.jpg', '每日C葡萄柚汁', NULL, '300ml', 6, 10, 0, '', 4);
INSERT INTO `goods`
VALUES (32, '../upload/4-6.jpg', '即品坚果 台湾甄选 颗颗饱满', '留存水果本真 有滋有味', '56g', 12, 5, 5, '', 4);
INSERT INTO `goods`
VALUES (34, '../upload/2-1.jpg', '福成尚品前腱子', '', '1000g', 99, 10, 0, '', 5);
INSERT INTO `goods`
VALUES (35, '../upload/2-2.jpg', '牦牛精肉2斤+ 牦牛肋排2斤', '自然生长', '2kg', 226, 10, 0, '', 5);
INSERT INTO `goods`
VALUES (36, '../upload/2-3.jpg', '巴美草香猪后臀尖 原味原香', '精致美味，解锁味觉记忆', '约500g', 32, 10, 0, '', 5);
INSERT INTO `goods`
VALUES (37, '../upload/2-4.jpg', '农畉猪肉-猪脊骨 肉厚骨细', '骨鲜髓足', '约500g', 13, 10, 0, '', 5);
INSERT INTO `goods`
VALUES (38, '../upload/2-5.jpg', '一品江村黄鸡', '味道鲜美，口感软嫩弹滑', '约1kg', 46, 10, 0, '', 5);
INSERT INTO `goods`
VALUES (39, '../upload/2-6.jpg', '正大单冻鸡翅根 精选种鸡', '富有弹性', '约1kg', 35, 10, 0, '', 5);
INSERT INTO `goods`
VALUES (41, '../upload/630b07a0-29cd-4169-942d-0b50f2255d49.jpg', '涛', '涛涛', '150kg', 666, 666, 0, '6666', 5);

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items`
(
    `id`       int NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `price`    int NOT NULL DEFAULT 0 COMMENT '购买时价格',
    `amount`   int NOT NULL DEFAULT 0 COMMENT '购买数量',
    `order_id` int NOT NULL DEFAULT 0 COMMENT '订单ID',
    `good_id`  int NOT NULL DEFAULT 0 COMMENT '商品ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 19
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '订单项'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items`
VALUES (1, 26, 1, 1, 5);
INSERT INTO `items`
VALUES (2, 30, 1, 1, 4);
INSERT INTO `items`
VALUES (3, 13, 1, 1, 1);
INSERT INTO `items`
VALUES (4, 23, 1, 2, 29);
INSERT INTO `items`
VALUES (5, 12, 2, 3, 32);
INSERT INTO `items`
VALUES (6, 9, 2, 4, 6);
INSERT INTO `items`
VALUES (7, 26, 1, 4, 5);
INSERT INTO `items`
VALUES (8, 9, 4, 5, 6);
INSERT INTO `items`
VALUES (9, 12, 2, 6, 32);
INSERT INTO `items`
VALUES (10, 30, 2, 6, 4);
INSERT INTO `items`
VALUES (11, 9, 1, 6, 6);
INSERT INTO `items`
VALUES (12, 12, 1, 7, 32);
INSERT INTO `items`
VALUES (13, 9, 1, 7, 6);
INSERT INTO `items`
VALUES (14, 666, 1, 13, 41);
INSERT INTO `items`
VALUES (15, 26, 2, 13, 5);
INSERT INTO `items`
VALUES (16, 28, 2, 13, 2);
INSERT INTO `items`
VALUES (17, 30, 2, 13, 4);
INSERT INTO `items`
VALUES (18, 32, 1, 13, 17);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`
(
    `id`      int                                                     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `total`   int                                                     NOT NULL DEFAULT 0 COMMENT '订单金额',
    `amount`  int                                                     NOT NULL DEFAULT 0 COMMENT '商品总数',
    `status`  tinyint                                                 NOT NULL DEFAULT 1 COMMENT '订单状态(1未付款/2已付款/3已发货/4已完成)',
    `paytype` tinyint                                                 NOT NULL DEFAULT 0 COMMENT '支付方式 (1微信/2支付宝)',
    `name`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '收货人',
    `phone`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '收货电话',
    `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '收货地址',
    `systime` datetime                                                NULL     DEFAULT NULL COMMENT '下单时间',
    `user_id` int                                                     NOT NULL DEFAULT 0 COMMENT '下单用户ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 14
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '订单'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders`
VALUES (1, 69, 3, 4, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-04-19 00:07:48', 1);
INSERT INTO `orders`
VALUES (2, 23, 1, 4, 2, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-05-25 15:54:33', 1);
INSERT INTO `orders`
VALUES (3, 24, 1, 4, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-05-25 16:22:39', 1);
INSERT INTO `orders`
VALUES (5, 36, 1, 4, 2, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-05-29 14:13:39', 1);
INSERT INTO `orders`
VALUES (6, 93, 3, 2, 1, '密码123456', '123456789abc', '湖南浦东新区', '2021-06-11 10:56:20', 1);
INSERT INTO `orders`
VALUES (13, 866, 8, 1, 1, 'Tao宝宝', '19976851773', '北京', '2023-08-07 23:35:06', 8);

-- ----------------------------
-- Table structure for tops
-- ----------------------------
DROP TABLE IF EXISTS `tops`;
CREATE TABLE `tops`
(
    `id`      int     NOT NULL AUTO_INCREMENT,
    `type`    tinyint NOT NULL DEFAULT 1 COMMENT '推荐类型(1今日推荐)',
    `good_id` int     NOT NULL DEFAULT 0 COMMENT '商品ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 15
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '推荐商品'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tops
-- ----------------------------
INSERT INTO `tops`
VALUES (3, 1, 3);
INSERT INTO `tops`
VALUES (4, 1, 4);
INSERT INTO `tops`
VALUES (5, 1, 5);
INSERT INTO `tops`
VALUES (6, 1, 6);
INSERT INTO `tops`
VALUES (8, 1, 32);
INSERT INTO `tops`
VALUES (12, 1, 41);
INSERT INTO `tops`
VALUES (14, 1, 7);

-- ----------------------------
-- Table structure for types
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types`
(
    `id`   int                                                    NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
    `num`  int                                                    NULL DEFAULT 0 COMMENT '排序号 (从小到大)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '分类'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types`
VALUES (1, '生态果蔬', 1);
INSERT INTO `types`
VALUES (2, '肉禽蛋奶', 2);
INSERT INTO `types`
VALUES (3, '米面粮油', 3);
INSERT INTO `types`
VALUES (4, '休闲零食', 4);
INSERT INTO `types`
VALUES (5, '玩具', 5);
INSERT INTO `types`
VALUES (6, '户外用品', 6);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `id`       int                                                     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
    `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
    `name`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人',
    `phone`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货电话',
    `address`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users`
VALUES (8, 'admin', '81dc9bdb52d04dc20036dbd8313ed055', 'Tao宝宝', '19976851773', '北京');

SET FOREIGN_KEY_CHECKS = 1;
