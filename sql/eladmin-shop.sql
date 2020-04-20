CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '商品名称',
  `describe` text COMMENT '商品描述',
  `specification` text COMMENT '商品规格',
  `category_id` bigint(20) NOT NULL COMMENT '所属分类',
  `count` bigint(20) NOT NULL COMMENT '库存',
  `original_price` double NOT NULL COMMENT '原价',
  `activity_price` double NOT NULL COMMENT '活动价',
  `merchant_id` bigint(20) NOT NULL COMMENT '所属商家',
  `enabled` bit(1) NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK6xm81rsmni7tc3sg4r7oskfdm` (`category_id`),
  KEY `FKebl7g0qcqkv90uwxd60xfd5a7` (`merchant_id`),
  CONSTRAINT `FK6xm81rsmni7tc3sg4r7oskfdm` FOREIGN KEY (`category_id`) REFERENCES `product_catagory` (`id`),
  CONSTRAINT `FKebl7g0qcqkv90uwxd60xfd5a7` FOREIGN KEY (`merchant_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='商品';

CREATE TABLE `product_catagory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  `pid` bigint(20) NOT NULL COMMENT '上级分类',
  `enabled` bit(1) NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建日期',
  `merchant_id` bigint(20) NOT NULL COMMENT '所属商家',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKnwc3pfnx1sayiqp67b8a7axks` (`merchant_id`),
  CONSTRAINT `FKnwc3pfnx1sayiqp67b8a7axks` FOREIGN KEY (`merchant_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='商品分类';

DROP TABLE IF EXISTS `order_main`;
CREATE TABLE `order_main` (
  `order_sn` varchar(64) NOT NULL COMMENT '订单编号',
  `create_time` datetime NOT NULL COMMENT '提交时间',
  `member_username` varchar(64) NOT NULL COMMENT '用户帐号',
  `total_amount` decimal(10,2) NOT NULL COMMENT '订单总金额',
  `pay_amount` decimal(10,2) NOT NULL COMMENT '应付金额（实际支付金额）',
  `freight_amount` decimal(10,2) DEFAULT NULL COMMENT '运费金额',
  `pay_type` int(1) DEFAULT NULL COMMENT '支付方式：0->未支付；1->支付宝；2->微信',
  `status` int(1) DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `delivery_company` varchar(64) DEFAULT NULL COMMENT '物流公司(配送方式)',
  `delivery_sn` varchar(64) DEFAULT NULL COMMENT '物流单号',
  `receiver_name` varchar(100) DEFAULT NULL COMMENT '收货人姓名',
  `receiver_phone` varchar(32) DEFAULT NULL COMMENT '收货人电话',
  `receiver_post_code` varchar(32) DEFAULT NULL COMMENT '收货人邮编',
  `receiver_province` varchar(32) DEFAULT NULL COMMENT '省份/直辖市',
  `receiver_city` varchar(32) DEFAULT NULL COMMENT '城市',
  `receiver_region` varchar(32) DEFAULT NULL COMMENT '区',
  `receiver_detail_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `note` varchar(500) DEFAULT NULL COMMENT '订单备注',
  `confirm_status` int(1) DEFAULT NULL COMMENT '确认收货状态：0->未确认；1->已确认',
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态：0->未删除；1->已删除',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `receive_time` datetime DEFAULT NULL COMMENT '确认收货时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `merchant_id` bigint(20) NOT NULL COMMENT '所属商家',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单表';

DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(64) NOT NULL COMMENT '订单编号',
  `product_id` bigint(20) NOT NULL COMMENT '商品id',
  `product_name` varchar(200) NOT NULL COMMENT '商品名称',
  `product_price` decimal(10,2) NOT NULL COMMENT '销售价格',
  `product_quantity` int(11) NOT NULL COMMENT '购买数量',
  `product_category_id` bigint(20) NOT NULL COMMENT '商品分类id',
  `product_category_name` varchar(500) NOT NULL COMMENT '商品分类名称',
  `merchant_id` bigint(20) NOT NULL COMMENT '所属商家',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单中所包含的商品';