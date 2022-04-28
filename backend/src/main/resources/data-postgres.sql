-- Insert data into products
-- ADD FK
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Hiking boots', 'Keeps your feet warm', 2400, 'Boots', 'Unisex', false, );
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Winter sweater', 'Holds the heat effectively', 800, 'Sweaters', 'Unisex', false, );
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Winter hat', 'Fits well on most heads', 200, 'Hats', 'Unisex', false, );
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Water bottle', 'Lightweight plastic bottle, with hook for easy attachment to a bag', 120, 'All items', 'Unisex', false, );
insert into "products" (product_name, description, price, category, sex, featured, discountID) values ('Clothes set for dogs', 'Boots, pants and sweater for dogs', 6670, 'All items', 'Animal', false, );

-- Insert data into discounts
insert into "discounts" (discount_name, description, discount_percentage, active) values ('Hat campaign', 'Buy 3 for 500 NOK', 17, true);
insert into "discounts" (discount_name, description, discount_percentage, active) values ('Dog set campaign', 'Discount from 6670 NOK to 700 NOK', 89.5, true);

