CREATE TABLE customer
(
  id            SERIAL       NOT NULL
    CONSTRAINT customer_pkey
    PRIMARY KEY,
  address       VARCHAR(255) NOT NULL,
  city          VARCHAR(255) NOT NULL,
  contact_name  VARCHAR(255) NOT NULL,
  country       VARCHAR(255) NOT NULL,
  customer_name VARCHAR(255) NOT NULL,
  postal_code   VARCHAR(255) NOT NULL
);

INSERT INTO customer (customer_name, contact_name, address, city, postal_code, country)
VALUES ('Alfreds Futterkiste', 'Maria Anders', 'Obere Str. 57', 'Berlin', 12209, 'Germany');
INSERT INTO customer (customer_name, contact_name, address, city, postal_code, country) VALUES
  ('Ana Trujillo Emparedados y helados', 'Ana Trujillo', 'Avda. de la Constitución 2222', 'México D.F.', 05021,
   'Mexico');
INSERT INTO customer (customer_name, contact_name, address, city, postal_code, country)
VALUES ('Antonio Moreno Taquería', 'Antonio Moreno', 'Mataderos 2312', 'México D.F.', 05023, 'Mexico');
INSERT INTO customer (customer_name, contact_name, address, city, postal_code, country)
VALUES ('Around the Horn', 'Thomas Hardy', '120 Hanover Sq.', 'London', 'WA1 1DP', 'UK');
INSERT INTO customer (customer_name, contact_name, address, city, postal_code, country)
VALUES ('Berglunds snabbköp', 'Christina Berglund', 'Berguvsvägen  8', 'Luleå', 'S-958 22', 'Sweden');