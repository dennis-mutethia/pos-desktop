CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `description` varchar(16) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by` int NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` int DEFAULT NULL,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_status` (`name`,`status`)
);
INSERT INTO `user_roles`(`name`,`description`,`created_at`,`created_by`,`status`) 
VALUES
    ('Admin','All Permissions',NOW(),0,1), 
    ('Supervisor','Supervisor Permissions',NOW(),0,1), 
    ('Cashier','Cashier Permissions',NOW(),0,1), 
    ('Waiter','Waiter Permissions',NOW(),0,1);

CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `password` varchar(256) NOT NULL,
  `role_id` int DEFAULT '0',
  `name` varchar(64) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by` int NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` int DEFAULT NULL,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_status` (`username`,`status`)
);
INSERT INTO `users`(`username`,`password`,`role_id`,`name`,`created_at`,`created_by`,`status`) 
VALUES('admin',SHA2('admin',256),1,'Admin',NOW(),0,1);

CREATE TABLE IF NOT EXISTS `product_categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `description` varchar(20) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by` int NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` int DEFAULT NULL,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_status` (`name`,`status`)
);

CREATE TABLE IF NOT EXISTS `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `barcode` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `category_id` int DEFAULT '0',
  `buying_price` double DEFAULT '0.0',
  `stockist_price` double DEFAULT '0.0',
  `wholesale_price` double DEFAULT '0.0',
  `retail_price` double DEFAULT '0.0',
  `quantity` double DEFAULT '0.0',
  `restock_value` double DEFAULT '0.0',
  `created_at` datetime DEFAULT NULL,
  `created_by` int NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` int DEFAULT NULL,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_category_id_status` (`name`,`category_id`,`status`)
);
