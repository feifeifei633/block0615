SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_transactions
-- ----------------------------
DROP TABLE IF EXISTS `tb_transactions`;
CREATE TABLE `tb_transactions`
(
  `txid`  int NOT NULL auto_increment,
  `txhash`  char(64) NOT NULL,
  `blockhash`  char(64) NOT NULL,
  `time`       datetime,
  `amount`    double ,
  `size`       int,
  `weight`     float,
  `confirmations` int  ,
  `totalinput`     double ,
  `totaloutput`     double ,
  `fees` double,
  `feeperbyte` double,
  `feeperweightunit` double,
  `btctransacted` double,
  PRIMARY KEY (`txid`),
  index `idx_blockhash` (`blockhash`),
  index `idx_time` (`time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
