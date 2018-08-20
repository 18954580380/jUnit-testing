drop table if exists ssm_order;
create table ssm_order
(
  id int unsigned auto_increment
    primary key,
  order_number VARCHAR(11) not null,
  created_date timestamp default CURRENT_TIMESTAMP not null,
  user_id int not null,
  total_price double not null
)
  charset=utf8mb4
;

