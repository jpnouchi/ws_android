create table phone (
  `id` int(10) unsigned NOT NULL auto_increment,
  `manufacturer` varchar(80) NOT NULL,
  `brand` varchar(80) NOT NULL,
  `model` varchar(80) NOT NULL,
  `release` varchar(50) NOT NULL,
  `os` varchar(80) NOT NULL,
  `osVersion` varchar(10) NOT NULL,
  `processor` varchar(50) NOT NULL,
  `memory` varchar(50) NOT NULL,
  `da_user_create` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;