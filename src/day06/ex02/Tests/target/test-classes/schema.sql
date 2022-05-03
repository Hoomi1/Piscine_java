CREATE TABLE IF NOT EXISTS product
(
    identifier BIGINT primary key IDENTITY,
    name VARCHAR(50) not null,
    price int not null
);