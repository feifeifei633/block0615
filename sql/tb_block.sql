
+。SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_block
-- ----------------------------
DROP TABLE IF EXISTS `tb_block`;
CREATE TABLE `tb_block`
(
 `bid`  int NOT NULL auto_increment,
 `blockhash`  char(64) NOT NULL,
 `height`     int NOT NULL,
 `time`       datetime,
  `txSize`     smallint,
  `size`       int,
  `difficulty` double,
  `weight`     float,
  `miner` varchar(155),
  `version` varchar(155),
  `nonce` int,
  `previousblock` char(64),
  `nextblock` char(64),

  PRIMARY KEY (`bid`),

  index `idx_height` (`height`),

  index `idx_time` (`time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
