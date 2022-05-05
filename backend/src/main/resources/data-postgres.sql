-- Insert data into products
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Hiking boots', 'Keeps your feet warm', 2400, 'Boots', 'Unisex', false, NULL);
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Winter sweater', 'Holds the heat effectively', 800, 'Sweaters', 'Unisex', false, NULL);
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Winter hat', 'Fits well on most heads', 200, 'Hats', 'Unisex', false, 1);
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Water bottle', 'Lightweight plastic bottle', 120, 'All items', 'Unisex', false, NULL);
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
insert into "sizes" (size) values ('One size');
insert into "sizes" (size) values ('Small dogs');
insert into "sizes" (size) values ('0.7L');

-- Insert into colors
insert into "colors" (color) values ('Black');
insert into "colors" (color) values ('Blue');
insert into "colors" (color) values ('Red');
insert into "colors" (color) values ('Transparent');
insert into "colors" (color) values ('Green');
insert into "colors" (color) values ('Orange');
insert into "colors" (color) values ('Norwegian flag');
insert into "colors" (color) values ('Swedish flag');

-- Insert into roles
insert into "roles" (role_name) values ("admin");
insert into "roles" (role_name) values ("user");

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

-- Insert into product_entries
--black boots
insert into "product_entries" (productID, sizeID, colorID) values (1, 1 , 1 , 125);
insert into "product_entries" (productID, sizeID, colorID) values (1, 2 , 1 , 13);
insert into "product_entries" (productID, sizeID, colorID) values (1, 3 , 1 , 23);
insert into "product_entries" (productID, sizeID, colorID) values (1, 4 , 1 , 19);
insert into "product_entries" (productID, sizeID, colorID) values (1, 5 , 1 , 53);
insert into "product_entries" (productID, sizeID, colorID) values (1, 6 , 1 , 39);
insert into "product_entries" (productID, sizeID, colorID) values (1, 7 , 1 , 12);
insert into "product_entries" (productID, sizeID, colorID) values (1, 8 , 1 , 13);
insert into "product_entries" (productID, sizeID, colorID) values (1, 9 , 1 , 7);
insert into "product_entries" (productID, sizeID, colorID) values (1, 10 , 1 , 5);
insert into "product_entries" (productID, sizeID, colorID) values (1, 11 , 1 , 2);
--blue boots
insert into "product_entries" (productID, sizeID, colorID) values (1, 1 , 2 , 123);
insert into "product_entries" (productID, sizeID, colorID) values (1, 2 , 2 , 11);
insert into "product_entries" (productID, sizeID, colorID) values (1, 3 , 2 , 13);
insert into "product_entries" (productID, sizeID, colorID) values (1, 4 , 2 , 15);
insert into "product_entries" (productID, sizeID, colorID) values (1, 5 , 2 , 56);
insert into "product_entries" (productID, sizeID, colorID) values (1, 6 , 2 , 33);
insert into "product_entries" (productID, sizeID, colorID) values (1, 7 , 2 , 22);
insert into "product_entries" (productID, sizeID, colorID) values (1, 8 , 2 , 15);
insert into "product_entries" (productID, sizeID, colorID) values (1, 9 , 2 , 2);
insert into "product_entries" (productID, sizeID, colorID) values (1, 10 , 2 , 1);
insert into "product_entries" (productID, sizeID, colorID) values (1, 11 , 2 , 1);
--red boots
insert into "product_entries" (productID, sizeID, colorID) values (1, 1 , 3 , 51);
insert into "product_entries" (productID, sizeID, colorID) values (1, 2 , 3 , 3);
insert into "product_entries" (productID, sizeID, colorID) values (1, 3 , 3 , 64);
insert into "product_entries" (productID, sizeID, colorID) values (1, 4 , 3 , 19);
insert into "product_entries" (productID, sizeID, colorID) values (1, 5 , 3 , 33);
insert into "product_entries" (productID, sizeID, colorID) values (1, 6 , 3 , 59);
insert into "product_entries" (productID, sizeID, colorID) values (1, 7 , 3 , 12);
insert into "product_entries" (productID, sizeID, colorID) values (1, 8 , 3 , 23);
insert into "product_entries" (productID, sizeID, colorID) values (1, 9 , 3 , 6);
insert into "product_entries" (productID, sizeID, colorID) values (1, 10 , 3 , 5);
insert into "product_entries" (productID, sizeID, colorID) values (1, 11 , 3 , 3);
--green winter sweater
insert into "product_entries" (productID, sizeID, colorID) values (2, 12 , 5 , 10);
insert into "product_entries" (productID, sizeID, colorID) values (2, 13 , 5 , 9);
insert into "product_entries" (productID, sizeID, colorID) values (2, 14 , 5 , 2);
--orange winter sweater 
insert into "product_entries" (productID, sizeID, colorID) values (2, 12 , 6 , 6);
insert into "product_entries" (productID, sizeID, colorID) values (2, 13 , 6 , 10);
insert into "product_entries" (productID, sizeID, colorID) values (2, 14 , 6 , 9);
--winter hat
insert into "product_entries" (productID, sizeID, colorID) values (3, 15 , 7 , 1);
insert into "product_entries" (productID, sizeID, colorID) values (3, 15 , 7 , 23);
--water bottle
insert into "product_entries" (productID, sizeID, colorID) values (4, 17 , 4 , 10);
insert into "product_entries" (productID, sizeID, colorID) values (4, 17 , 2 , 13);
insert into "product_entries" (productID, sizeID, colorID) values (4, 17 , 3 , 12);
--clothes set for dogs
insert into "product_entries" (productID, sizeID, colorID) values (5, 16 , 5 , 32);
insert into "product_entries" (productID, sizeID, colorID) values (5, 16 , 6 , 23);

-- Insert into users
insert into "users" (first_name, last_name, email, password, country, zipcode, city, address) values ('Torstein', 'Eide', 'tosse@kewlmail.com', 'Torstein', 'Norway', 6004, 'Ålesund', 'Øvre strandgate 2');
insert into "users" (first_name, last_name, email, password, country, zipcode, city, address) values ('Joakim', 'Edvardsen', 'jokke@kewlmail.com', 'Joakim', 'Norway', 6004, 'Ålesund', 'Øvre strandgate 2');
insert into "users" (first_name, last_name, email, password, country, zipcode, city, address) values ('Richie', 'Bailey', 'bichy@kewlmail.com', 'Richie', 'Norway', 6004, 'Ålesund', 'Øvre strandgate 2');
insert into "users" (first_name, last_name, email, password, country, zipcode, city, address) values ('Eduard', 'Cristea', 'eddy@kewlmail.com', 'Eduard', 'Norway', 6004, 'Ålesund', 'Øvre strandgate 2');

-- Insert into user_roles
insert into "user_roles" (userID, roleID) values (1, 1);
insert into "user_roles" (userID, roleID) values (2, 1);
insert into "user_roles" (userID, roleID) values (3, 1);
insert into "user_roles" (userID, roleID) values (4, 2);


CREATE TABLE IF NOT EXISTS "user_roles" (
    userID integer REFERENCES "users" (userID),
    roleID integer REFERENCES "roles" (roleID),

    PRIMARY KEY (userID, roleID)
)