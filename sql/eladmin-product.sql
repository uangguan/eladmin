INSERT INTO `product_catagory` (`id`, `name`, `pid`, `enabled`, `create_time`, `merchant_id`)
VALUES
	(1, '根分类', 0, 1, '2020-03-29 11:00:08', 1),
	(2, '电脑类', 1, 1, '2020-03-29 11:00:08', 1),
	(3, '手机类', 1, 1, '2020-03-29 11:00:08', 1),
	(4, '零食类', 1, 1, '2020-03-29 11:00:08', 1),
	(5, 'mac', 2, 1, '2020-03-29 11:00:08', 1);


INSERT INTO `product` (`id`, `name`, `describe`, `specification`, `category_id`, `count`, `original_price`, `activity_price`, `merchant_id`, `enabled`, `create_time`)
VALUES
	(1, 'MacBook pro 16', 'macbook pro 16 inch', '16 inch ', 5, 10, 16000, 15000, 14, 1, '2020-03-29 11:00:08'),
	(2, 'MacBook pro 15', 'macbook pro 15 inch', '15 inch ', 5, 10, 15000, 14000, 14, 1, '2020-03-29 11:00:08'),
    (3, 'MacBook pro 13', 'macbook pro 13 inch', '13 inch ', 5, 10, 14000, 13000, 14, 1, '2020-03-29 11:00:08');