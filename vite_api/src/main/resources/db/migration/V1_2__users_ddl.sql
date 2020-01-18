CREATE  TABLE users (
  userid bigint(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  active TINYINT NOT NULL DEFAULT 1,
  created_by VARCHAR(45),
  created_datetime DATETIME,
  last_updated_by VARCHAR(45),
  last_updated_datetime DATETIME,
  PRIMARY KEY (userid));

CREATE TABLE user_roles (
  user_role_id bigint(11) NOT NULL AUTO_INCREMENT,
  userid bigint(11) NOT NULL,
  role varchar(45) NOT NULL,
  active TINYINT NOT NULL DEFAULT 1,
  created_by VARCHAR(45),
  created_datetime DATETIME,
  last_updated_by VARCHAR(45),
  last_updated_datetime DATETIME,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_userid_role (role,userid),
  KEY fk_user_idx (userid),
  CONSTRAINT fk_userid FOREIGN KEY (userid) REFERENCES users (userid));
  
