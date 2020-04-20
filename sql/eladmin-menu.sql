INSERT INTO `menu` (`id`, `i_frame`, `name`, `component`, `pid`, `sort`, `icon`, `path`, `cache`, `hidden`, `component_name`, `create_time`, `permission`, `type`)
VALUES
	(21, 0, '商品模块', '', 0, 1, 'menu', 'product', 0, 0, NULL, '2019-01-04 16:22:03', NULL, 0),
	(22, 0, '商品分类管理', 'product/catagory/index', 21, 999, 'menu', 'catagory', 0, 0, NULL, '2019-01-04 16:23:29', NULL, 1),
	(23, 0, '商品管理', 'product/product/index', 21, 999, 'menu', 'product', 0, 0, NULL, '2019-01-04 16:23:57', NULL, 1);


INSERT INTO `menu` VALUES (117, b'0', '商品新增', '', 23, 1, '', '', b'0', b'0', '', '2020-03-29 10:59:46', 'product:add', 2);
INSERT INTO `menu` VALUES (118, b'0', '商品编辑', '', 23, 2, '', '', b'0', b'0', '', '2020-03-29 11:00:08', 'product:edit', 2);
INSERT INTO `menu` VALUES (119, b'0', '商品删除', '', 23, 3, '', '', b'0', b'0', '', '2020-03-29 11:00:23', 'product:del', 2);
INSERT INTO `menu` VALUES (123, b'0', '商品查询', '', 23, 4, '', '', b'0', b'0', '', '2020-03-29 11:00:23', 'product:list', 2);

INSERT INTO `menu` VALUES (120, b'0', '商品分类新增', '', 22, 1, '', '', b'0', b'0', '', '2020-03-29 10:59:46', 'productCatagory:add', 2);
INSERT INTO `menu` VALUES (121, b'0', '商品分类编辑', '', 22, 2, '', '', b'0', b'0', '', '2020-03-29 11:00:08', 'productCatagory:edit', 2);
INSERT INTO `menu` VALUES (122, b'0', '商品分类删除', '', 22, 3, '', '', b'0', b'0', '', '2020-03-29 11:00:23', 'productCatagory:del', 2);
INSERT INTO `menu` VALUES (124, b'0', '商品分类查询', '', 22, 4, '', '', b'0', b'0', '', '2020-03-29 11:00:23', 'productCatagory:list', 2);

INSERT INTO `menu` (`id`, `i_frame`, `name`, `component`, `pid`, `sort`, `icon`, `path`, `cache`, `hidden`, `component_name`, `create_time`, `permission`, `type`)
VALUES
	(126, 0, '订单模块', '', 0, 1, 'menu', 'order', 0, 0, NULL, '2020-03-29 16:22:03', NULL, 0),
	(127, 0, '订单管理', 'order/order/index', 126, 999, 'menu', 'order', 0, 0, NULL, '2020-03-29 16:23:57', NULL, 1);
INSERT INTO `menu` VALUES (128, b'0', '订单编辑', '', 127, 1, '', '', b'0', b'0', '', '2020-03-29 11:00:08', 'product:edit', 2);
INSERT INTO `menu` VALUES (129, b'0', '订单删除', '', 127, 2, '', '', b'0', b'0', '', '2020-03-29 11:00:23', 'product:del', 2);
INSERT INTO `menu` VALUES (130, b'0', '订单查询', '', 127, 3, '', '', b'0', b'0', '', '2020-03-29 11:00:23', 'product:list', 2);