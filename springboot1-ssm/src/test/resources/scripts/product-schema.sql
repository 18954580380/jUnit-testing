drop table if exists ssm_product;
create table ssm_product
(
  id int unsigned auto_increment
    primary key,
  name varchar(20) not null,
  price float not null,
  amount int not null,
  category_id int not null
)
  charset=utf8mb4
;

create index index_category_id
  on ssm_product (category_id)
;

