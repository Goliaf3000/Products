CREATE TABLE IF NOT EXISTS products
(
    id   BIGSERIAL PRIMARY KEY ,
    productName  VARCHAR(260) NOT NULL ,
    productDescription VARCHAR(4099) NOT NULL ,
    productPrice INTEGER NOT NULL ,
    productStock VARCHAR(254) NOT NULL
    );
