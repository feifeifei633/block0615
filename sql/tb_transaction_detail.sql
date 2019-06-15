SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_transaction_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_transaction_detail`;
CREATE TABLE `tb_transaction_detail`
(
  `tx_detail_id`  int NOT NULL auto_increment,
  `txhash`       char(64),
  `address`      varchar(100),
  `amount`       double,
  `type`         tinyint,
  PRIMARY KEY (`tx_detail_id`),
  index `idx_txhash` (`txhash`),
  index `idx_address` (`address`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
