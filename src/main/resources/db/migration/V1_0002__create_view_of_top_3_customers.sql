CREATE VIEW top_3_customers AS
  SELECT *
  FROM mydb.public.customer
  ORDER BY id DESC
  LIMIT 3;