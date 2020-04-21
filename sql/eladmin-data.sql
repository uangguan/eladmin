INSERT INTO `order_main` (`id`, `order_sn`, `create_time`, `member_username`, `total_amount`, `pay_amount`, `freight_amount`, `pay_type`, `status`, `delivery_company`, `delivery_sn`, `receiver_name`, `receiver_phone`, `receiver_post_code`, `receiver_province`, `receiver_city`, `receiver_region`, `receiver_detail_address`, `note`, `confirm_status`, `delete_status`, `payment_time`, `delivery_time`, `receive_time`, `modify_time`, `merchant_id`)
VALUES
	(1, '12345', '2020-04-11 13:56:05', 'hgw', 100.00, 90.00, NULL, 1, 0, '顺丰', '123', '黄先生', '17789816090', '570226', '海南', '海口', '龙华区', '滨濂村', NULL, 0, 0, NULL, NULL, NULL, NULL, 14);
INSERT INTO `order_main` (`order_sn`, `create_time`, `member_username`, `total_amount`, `pay_amount`, `freight_amount`, `pay_type`, `status`, `delivery_company`, `delivery_sn`, `receiver_name`, `receiver_phone`, `receiver_post_code`, `receiver_province`, `receiver_city`, `receiver_region`, `receiver_detail_address`, `note`, `confirm_status`, `delete_status`, `payment_time`, `delivery_time`, `receive_time`, `modify_time`, `merchant_id`)
VALUES
	('12345', '2020-04-11 13:56:05', 'hgw', 100.00, 90.00, NULL, 1, 0, '顺丰', '123', '黄先生', '17789816090', '570226', '海南', '海口', '龙华区', '滨濂村', NULL, 0, 0, NULL, NULL, NULL, NULL, 15);

INSERT INTO `order_item` (`id`, `order_id`, `product_id`, `product_name`, `product_price`, `product_quantity`, `product_category_id`, `product_category_name`, `merchant_id`)
VALUES
	(1, 1, 1, 'mac', 10.00, 1, 5, 'amc', 14),
    (1, 1, 1, 'mac', 10.00, 1, 5, 'amc', 14),
	(1, 1, 1, 'mac', 10.00, 1, 5, 'amc', 14),

