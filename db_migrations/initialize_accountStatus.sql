USE `bbuddy`;

DROP TABLE IF EXISTS `accountStatus`;
CREATE TABLE `accountStatus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` varchar(20) NOT NULL,
  `remark` varchar(200),
  `amount` varchar(20) NOT NULL,
  `amount_type` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

