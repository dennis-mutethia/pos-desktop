CREATE TABLE IF NOT EXISTS user_roles (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  description VARCHAR(64) DEFAULT NULL,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  created_by INT DEFAULT NULL,
  updated_at DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  updated_by INT DEFAULT NULL,
  status INT DEFAULT 1,
  UNIQUE KEY (name, status)
);
INSERT IGNORE INTO user_roles(name, description) 
VALUES
  ('Admin','All Permissions'), 
  ('Supervisor','Supervisor Permissions'), 
  ('Cashier','Cashier Permissions'), 
  ('Waiter','Waiter Permissions');

CREATE TABLE IF NOT EXISTS users (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(64) NOT NULL,
  password VARCHAR(64) DEFAULT NULL,
  role_id INT DEFAULT NULL,
  name VARCHAR(64) DEFAULT NULL,
  phone VARCHAR(64) DEFAULT NULL,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  created_by INT DEFAULT NULL,
  updated_at DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  updated_by INT DEFAULT NULL,
  status INT DEFAULT 1,
  UNIQUE KEY (username, status)
);
INSERT IGNORE INTO users(username, password, role_id, name) 
VALUES('admin', 'admin', 1, 'Admin');

CREATE TABLE IF NOT EXISTS product_categories (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  description VARCHAR(64) DEFAULT NULL,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  created_by INT DEFAULT NULL,
  updated_at DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  updated_by INT DEFAULT NULL,
  status INT DEFAULT 1,
  UNIQUE KEY (name, status)
);
INSERT IGNORE INTO product_categories(name) 
VALUES('');

CREATE TABLE IF NOT EXISTS suppliers (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64) DEFAULT NULL,
  phone VARCHAR(64) DEFAULT NULL,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  created_by INT DEFAULT NULL,
  updated_at DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  updated_by INT DEFAULT NULL,
  status INT DEFAULT 1,
  UNIQUE KEY (name, status)
);
INSERT IGNORE INTO suppliers(name) 
VALUES('');

CREATE TABLE IF NOT EXISTS products (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  barcode VARCHAR(64) DEFAULT NULL,
  supplier_id INT,
  category_id INT,
  buying_price DECIMAL(10, 2) DEFAULT NULL,
  stockist_price DECIMAL(10, 2) DEFAULT NULL,
  wholesale_price DECIMAL(10, 2) DEFAULT NULL,
  retail_price DECIMAL(10, 2) DEFAULT NULL,
  quantity DECIMAL(10, 2) DEFAULT NULL,
  restock_value DECIMAL(10, 2) DEFAULT NULL,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  created_by INT DEFAULT NULL,
  updated_at DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  updated_by INT DEFAULT NULL,
  status INT DEFAULT 1,
  UNIQUE KEY (name, category_id, status)
);

CREATE TABLE IF NOT EXISTS purchase_orders (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  product_id INT NOT NULL,
  buying_price DECIMAL(10, 2) DEFAULT NULL,
  order_qty DECIMAL(10, 2) DEFAULT NULL,
  received_at DATETIME DEFAULT NULL,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  created_by INT DEFAULT NULL,
  updated_at DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  updated_by INT DEFAULT NULL,
  status INT DEFAULT 0
);
