CREATE TABLE IF NOT EXISTS user_roles (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  description TEXT DEFAULT NULL,
  created_at NUMERIC DEFAULT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by INTEGER DEFAULT NULL,
  updated_at NUMERIC NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_by INTEGER DEFAULT NULL,
  status INTEGER DEFAULT 1,
  UNIQUE (name, status)
);
INSERT OR IGNORE INTO user_roles(name,description) 
VALUES
    ('Admin','All Permissions'), 
    ('Supervisor','Supervisor Permissions'), 
    ('Cashier','Cashier Permissions'), 
    ('Waiter','Waiter Permissions');

CREATE TABLE IF NOT EXISTS users (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  username TEXT NOT NULL,
  password TEXT DEFAULT NULL,
  role_id INTEGER DEFAULT NULL,
  name TEXT DEFAULT NULL,
  phone TEXT DEFAULT NULL,
  created_at NUMERIC DEFAULT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by INTEGER DEFAULT NULL,
  updated_at NUMERIC NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_by INTEGER DEFAULT NULL,
  status INTEGER DEFAULT 1,
  UNIQUE (username, status)
);
INSERT OR IGNORE INTO users(username,password,role_id,name) 
VALUES('admin','admin',1,'Admin');

CREATE TABLE IF NOT EXISTS product_categories (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  description TEXT DEFAULT NULL,
  created_at NUMERIC DEFAULT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by INTEGER DEFAULT NULL,
  updated_at NUMERIC NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_by INTEGER DEFAULT NULL,
  status INTEGER DEFAULT 1,
  UNIQUE (name, status)
);

CREATE TABLE IF NOT EXISTS products (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  barcode TEXT DEFAULT NULL,
  category_id INTEGER,
  buying_price REAL DEFAULT NULL,
  stockist_price REAL DEFAULT NULL,
  wholesale_price REAL DEFAULT NULL,
  retail_price REAL DEFAULT NULL,
  quantity REAL DEFAULT NULL,
  restock_value REAL DEFAULT NULL,
  created_at NUMERIC DEFAULT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by INTEGER DEFAULT NULL,
  updated_at NUMERIC NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_by INTEGER DEFAULT NULL,
  status INTEGER DEFAULT 1,
  UNIQUE (name, category_id, status)
);
