CREATE SCHEMA STORE;

CREATE TABLE IF NOT EXISTS STORE.PRODUCTS (
	ID UUID PRIMARY KEY,
	NAME VARCHAR ( 200 ) NOT NULL,
	VALUE NUMERIC NOT NULL
);