CREATE TABLE `config_columns` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `index_id` bigint(11) NOT NULL,
  `column_display_name` varchar(50) NOT NULL,
  `column_name` varchar(50) NOT NULL,
  `search` tinyint(1) NOT NULL DEFAULT b'1',
  `display` tinyint(1) NOT NULL DEFAULT b'1',
  `active` tinyint(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

CREATE TABLE `config_index` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `index_name` varchar(200) NOT NULL,
  `index_url` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

