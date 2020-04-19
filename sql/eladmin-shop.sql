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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='商品分类';