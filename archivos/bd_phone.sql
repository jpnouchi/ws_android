
CREATE DATABASE IF NOT EXISTS json;
USE json;
DROP TABLE IF EXISTS `phone`;
create table `phone` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `manufacturer` varchar(80) NOT NULL,
  `brand` varchar(80) NOT NULL,
  `model` varchar(80) NOT NULL,
  `release` varchar(50) NOT NULL,
  `os` varchar(50) NOT NULL,
  `osVersion` varchar(50) NOT NULL,
  `processor` varchar(50) NOT NULL,
  `memory` varchar(50) NOT NULL,
  `storage` varchar(50) NOT NULL,
  `weight` varchar(50) NOT NULL,
  `dateCreate` datetime NOT NULL,
  `userCreate` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `phone` (`manufacturer`,`brand`,`model`,`release`,`os`,`osVersion`,`processor`,`memory`,`storage`,`weight`,`dateCreate`,`userCreate`) VALUES 
 ('HTC','Google/HTC','Nexus One','January 2010','Android','2.1 Eclair','1 GHz Qualcomm Scorpion','512 MB','512 MB','130 g','2010-10-10','jose');
 
 INSERT INTO `phone` (`manufacturer`,`brand`,`model`,`release`,`os`,`osVersion`,`processor`,`memory`,`storage`,`weight`,`dateCreate`,`userCreate`) VALUES 
 ('Samsung','Google/Samsung','Nexus S I9023','December 2010','Android','2.3 Gingerbread','1 GHz single-core ARM Cortex-A8','512 MB','16 GB','129 g','2011-02-10','pedro');
 
 INSERT INTO `phone` (`manufacturer`,`brand`,`model`,`release`,`os`,`osVersion`,`processor`,`memory`,`storage`,`weight`,`dateCreate`,`userCreate`) VALUES 
 ('Samsung','Google/Samsung','Galaxy Nexus I9250','November 2011','Android','4.0 Ice Cream Sandwich','1.2 GHz dual-core ARM Cortex-A9','1 GB','16 GB','135 g','2012-03-13','juan');
