CREATE TABLE IF NOT EXISTS "users" (
    userID serial PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    zipcode int NOT NULL,
    city VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
)

CREATE TABLE IF NOT EXISTS "discounts" (
    discountID serial PRIMARY KEY,
    discount_name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    discount_percentage VARCHAR(255) NOT NULL,
    active BOOLEAN DEFAULT false
)

CREATE TABLE IF NOT EXISTS "products" (
    productID serial PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price int NOT NULL,
    category VARCHAR(255) NOT NULL,
    sex VARCHAR(255) NOT NULL,
    discoundID integer REFERENCES "discounts" (discountID)
)

CREATE TABLE IF NOT EXISTS "sizes" (
    sizeID serial PRIMARY KEY,
    size VARCHAR(255)
)

CREATE TABLE IF NOT EXISTS "colors" (
    colorID serial PRIMARY KEY,
    color VARCHAR(255)
)

CREATE TABLE IF NOT EXISTS "roles" (
    roleID serial PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL,
    userID integer REFERENCES "users" (userID) NOT NULL
)

CREATE TABLE IF NOT EXISTS "carts" (
    cartID serial PRIMARY KEY,
    userID integer REFERENCES "users" (userID) NOT NULL
)

CREATE TABLE IF NOT EXISTS "cart_products" (
    cartID integer REFERENCES "carts" (cartID),
    productID integer REFERENCES "products" (productID),
    product_size VARCHAR(255) NOT NULL,
    product_color VARCHAR(255) NOT NULL
)

CREATE TABLE IF NOT EXISTS "orders" (
    orderID serial PRIMARY KEY,
    total_price int NOT NULL DEFAULT 0,
    status VARCHAR(255) NOT NULL, 
    userID integer REFERENCES "users" (userID)
)

CREATE TABLE IF NOT EXISTS "order_products" (
    orderID integer REFERENCES "orders" (orderID) NOT NULL,
    productID integer REFERENCES "products" (productID) NOT NULL
)

CREATE TABLE IF NOT EXISTS "product_details" (
    product_detailsID serial PRIMARY KEY,
    productID integer REFERENCES "products" (productID),
    details VARCHAR(255) NOT NULL
)

CREATE TABLE IF NOT EXISTS "product_entries" (
    productID integer REFERENCES "products" (productID),
    sizeID integer REFERENCES "sizes" (sizeID),
    colorID integer REFERENCES "colors" (colorID),
    quanitity integer NOT NULL DEFAULT 0,

    PRIMARY KEY (productID, sizeID, colorID)
)

CREATE TABLE IF NOT EXISTS "images" (
    imageID serial PRIMARY KEY,
    image bytea NOT NULL,
    thumbnail bytea NOT NULL,
    productID integer REFERENCES "products" (productID)
)