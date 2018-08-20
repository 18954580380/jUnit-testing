drop table if exists ssm_user;
CREATE TABLE `ssm_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(5) NOT NULL,
  `loginName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;