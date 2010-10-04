CREATE DATABASE /*!32312 IF NOT EXISTS*/ javablog;

USE javablog;

CREATE TABLE IF NOT EXISTS `section` (

  `ID` int(10) unsigned NOT NULL auto_increment,

  `NAME` varchar(45) NOT NULL default '',

  `URL` varchar(45) NOT NULL default '',

  PRIMARY KEY  (`ID`),
  UNIQUE (`NAME`, `URL`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `article` (

  `ID` int(10) unsigned NOT NULL auto_increment,

  `SECTION_ID` int(10) unsigned NOT NULL ,

  `TITLE` varchar(100) NOT NULL default '',

  `TEXT` TEXT NOT NULL default '',

  `CREATED` TIMESTAMP NOT NULL default current_timestamp,

  `AUTHOR` varchar(50) NOT NULL default '',

  PRIMARY KEY  (`ID`),
  
  FOREIGN KEY (SECTION_ID) REFERENCES section (id) ON DELETE CASCADE ON UPDATE CASCADE

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `comments` (

  `ID` int(10) unsigned NOT NULL auto_increment,

  `ARTICLE_ID` int(10) unsigned NOT NULL ,
  
  `TEXT` TEXT NOT NULL default '',

  `CREATED` TIMESTAMP NOT NULL default current_timestamp,

  `AUTHOR` varchar(50) NOT NULL default '',

  PRIMARY KEY  (`ID`),
  
  FOREIGN KEY (ARTICLE_ID) REFERENCES article (id) ON DELETE CASCADE ON UPDATE CASCADE

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `configuration` (

  `ID` int(10) unsigned NOT NULL auto_increment,

  `CONFIGURATION_SET` varchar(50) NOT NULL DEFAULT '',
 
  `DEFAULT_ARTICLE_AUTHOR` varchar(50) NOT NULL DEFAULT '',

  `ADMIN_EMAIL` varchar(50) NOT NULL DEFAULT '',

  `MAIL_SMTP_HOST` varchar(50) NOT NULL DEFAULT '',

  `MAIL_SENDER_ADDRESS` varchar(50) NOT NULL DEFAULT '',

   PRIMARY KEY  (`ID`),

   UNIQUE (`CONFIGURATION_SET`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DELETE FROM configuration where CONFIGURATION_SET = 'DEFAULT';
INSERT INTO configuration values(null, 'DEFAULT' ,'admin', 'admin@javablog.com', '127.0.0.1', 'notify@javablog.com');

CREATE TABLE IF NOT EXISTS `users` (

  `ID` int(10) unsigned NOT NULL auto_increment,

  `USERNAME` varchar(50) NOT NULL DEFAULT '',
 
  `PASSWORD` varchar(50) NOT NULL DEFAULT '',

  `EMAIL` varchar(50) NOT NULL DEFAULT '',

  `REGISTERED` TIMESTAMP NOT NULL default current_timestamp,

  `LAST_LOGIN` TIMESTAMP,

  `ENABLED` BIT NOT NULL DEFAULT 0,

   PRIMARY KEY  (`ID`),

   UNIQUE (`USERNAME`, `EMAIL`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

  CREATE TABLE IF NOT EXISTS authorities (
   username VARCHAR(50) NOT NULL,
   authority VARCHAR(50) NOT NULL,
   foreign key (username) REFERENCES users(username) ON DELETE CASCADE ON UPDATE CASCADE
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

