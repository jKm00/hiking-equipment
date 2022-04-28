-- Insert data into products
-- ADD FK
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Hiking boots', 'Keeps your feet warm', 2400, 'Boots', 'Unisex', false, );
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Winter sweater', 'Holds the heat effectively', 800, 'Sweaters', 'Unisex', false, );
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Winter hat', 'Fits well on most heads', 200, 'Hats', 'Unisex', false, 1);
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Water bottle', 'Lightweight plastic bottle', 120, 'All items', 'Unisex', false, );
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Clothes set for dogs', 'Boots, pants and sweater for dogs', 6670, 'All items', 'Animal', false, 2);

-- Insert data into discounts
insert into "discounts" (discount_name, description, discount_percentage, active) values ('Hat campaign', 'Buy 3 for 500 NOK', 17, true);
insert into "discounts" (discount_name, description, discount_percentage, active) values ('Dog set campaign', 'Discount from 6670 NOK to 700 NOK', 89.5, true);

-- Insert data into sizes
insert into "sizes" (size) values ('37');
insert into "sizes" (size) values ('38');
insert into "sizes" (size) values ('39');
insert into "sizes" (size) values ('40');
insert into "sizes" (size) values ('41');
insert into "sizes" (size) values ('42');
insert into "sizes" (size) values ('43');
insert into "sizes" (size) values ('44');
insert into "sizes" (size) values ('45');
insert into "sizes" (size) values ('46');
insert into "sizes" (size) values ('47');
insert into "sizes" (size) values ('XS');
insert into "sizes" (size) values ('S');
insert into "sizes" (size) values ('M');
insert into "sizes" (size) values ('Small dogs');

-- Insert into colors
insert into "colors" (color) values ('Black');
insert into "colors" (color) values ('Blue');
insert into "colors" (color) values ('Red');
insert into "colors" (color) values ('Transparent');
insert into "colors" (color) values ('Green');
insert into "colors" (color) values ('Orange');

-- Insert into roles
-- ADD FK
insert into "roles" (role_name, userID) values ("admin");
insert into "roles" (role_name, userID) values ("user");

-- Insert into product_details
-- hiking boots
insert into "product_detals" (productID, details) values (1, 'Easy to put on');
insert into "product_detals" (productID, details) values (1, '-15C up to -25C');
-- Winter hat
insert into "product_detals" (productID, details) values (3, 'Available with Norwegian and swedish flag');
insert into "product_detals" (productID, details) values (3, '80% wool, 20% nylon');
-- Water bottle
insert into "product_detals" (productID, details) values (4, 'Hook for easy attachment to a bag');
insert into "product_detals" (productID, details) values (4, 'Volume: 0.7 liters');
-- Clothes set for dogs
insert into "product_detals" (productID, details) values (5, 'Only for small dogs (no larger than pitbull)');
