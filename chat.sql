CREATE DATABASE test_db DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE test_db;

SET GLOBAL time_zone = '+3:00';

CREATE TABLE table_user (
	id  INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    password  VARCHAR(45) NOT NULL,
    lastlogon  TIMESTAMP NOT NULL,
    PRIMARY KEY(id)
) ENGINE = INNODB;


CREATE TABLE table_group (
  id_group INT NOT NULL AUTO_INCREMENT,
  name_group VARCHAR(45) NOT NULL,
  members INT NOT NULL,
  last_message TIMESTAMP NOT NULL,
  admin_group INT NULL,
  PRIMARY KEY (id_group),
  INDEX table_user_idx (admin_group ASC),
  CONSTRAINT table_user
    FOREIGN KEY (admin_group)
    REFERENCES table_user (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE users_in_group (
	table_user_id INT NOT NULL,
    table_group_id_group INT NOT NULL,
    id_link INT,
    PRIMARY KEY (id_link),
	CONSTRAINT table_user1
        FOREIGN KEY (table_user_id)
        REFERENCES table_user(id)
        ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT table_group
		FOREIGN KEY (table_group_id_group)
		REFERENCES table_group (id_group)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)ENGINE = InnoDB;

CREATE TABLE group_chat (
  link_id_user_in_group INT NULL,
  group_chatcol VARCHAR(45) NULL,
  data DATETIME NULL,
  CONSTRAINT users_in_group
    FOREIGN KEY (link_id_user_in_group)
    REFERENCES users_in_group (id_link)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE = InnoDB;

CREATE TABLE user_to_user (
  user_id_sent INT NULL,
  user_id_inbox INT NULL,
  approved_chat VARCHAR(1) NULL,
  spam_chat VARCHAR(1) NULL,
  id_u_to_u_key INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id_u_to_u_key),
  CONSTRAINT table_user2
    FOREIGN KEY (user_id_sent )
    REFERENCES table_user (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT   table_user3
	 FOREIGN KEY (user_id_inbox )
     REFERENCES table_user (id )
     ON DELETE NO ACTION
     ON UPDATE NO ACTION
)ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS usr_chat (
  user_key INT NULL,
  message VARCHAR(100) NULL,
  data_time_message TIMESTAMP NULL,
  CONSTRAINT user_to_user
    FOREIGN KEY (user_key)
    REFERENCES user_to_user (id_u_to_u_key)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;






