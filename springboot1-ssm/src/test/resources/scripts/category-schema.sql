drop table if exists ssm_category;
create table ssm_category
(
  id int unsigned auto_increment
    primary key,
  name varchar(10) not null,
  display_order int not null
)
  charset=utf8mb4
;

