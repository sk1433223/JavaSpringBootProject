/* 创建springbootdb数据库并指定字符集编码 */
CREATE DATABASE `springbootdb`CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
-- springbootdb
CREATE TABLE `springbootdb`.`user`(
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(50) NOT NULL,
  `pass_word` VARCHAR(50) NOT NULL,
  `status` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `user`(id,user_name,pass_word,`status`) VALUES (1,'admin','123','1');
INSERT INTO `user`(id,user_name,pass_word,`status`) VALUES (3,'user','123','1');
INSERT INTO `user`(id,user_name,pass_word,`status`) VALUES (5,'123','123','1');
INSERT INTO `user`(id,user_name,pass_word,`status`) VALUES (7,'777','123','1'),(8,'888','123','1'),(9,'999','123','1'),(10,'1010','123','1');

SELECT * FROM `user`;