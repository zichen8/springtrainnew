DROP TABLE IF EXISTS `transaction_bid`;
CREATE TABLE `transaction_bid` (
    `transactionid` int(11) NOT NULL AUTO_INCREMENT,
    `tradeid` int(11) NOT NULL,
	`securitycode` varchar(200) DEFAULT NULL,
	`quantity` int(11) NOT NULL,
	`insertorupdateorcancel` tinyint(1) NOT NULL,
	`buyorsell` bit(1) NOT NULL,
	`accountid` bigint(20) NOT NULL,
  PRIMARY KEY (`transactionid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `transaction_last`;
CREATE TABLE `transaction_last` (
    `tradeid` int(11) NOT NULL,
	`securitycode` varchar(200) DEFAULT NULL,
	`quantity` int(11) NOT NULL,
	`accountid` bigint(20) NOT NULL,
  PRIMARY KEY (`tradeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
