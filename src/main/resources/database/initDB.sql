CREATE TABLE IF NOT EXISTS products (
    id BIGSERIAL PRIMARY KEY,
    product_name VARCHAR(260) NOT NULL,
    product_description VARCHAR(4099) ,
    product_price INTEGER ,
    product_stock VARCHAR(254)
    );