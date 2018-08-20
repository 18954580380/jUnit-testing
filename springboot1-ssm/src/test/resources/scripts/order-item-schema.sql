drop table if exists ssm_order_item;
create table ssm_order_item
(
  id int unsigned auto_increment
    primary key,
  product_id int not null,
  order_id int not null,
  amount int not null
)
  charset=utf8mb4
;

