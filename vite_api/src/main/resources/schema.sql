-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.11-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for vite_db
DROP DATABASE IF EXISTS `vite_db`;
CREATE DATABASE IF NOT EXISTS `vite_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vite_db`;

-- Dumping structure for table vite_db.columns
DROP TABLE IF EXISTS `columns`;
CREATE TABLE IF NOT EXISTS `columns` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `index_id` int(11) NOT NULL,
  `column_display_name` varchar(50) NOT NULL,
  `column_name` varchar(50) NOT NULL,
  `search` bit(1) NOT NULL DEFAULT b'1',
  `display` bit(1) NOT NULL DEFAULT b'1',
  `active` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- Dumping data for table vite_db.columns: ~2 rows (approximately)
/*!40000 ALTER TABLE `columns` DISABLE KEYS */;
INSERT INTO `columns` (`id`, `index_id`, `column_display_name`, `column_name`, `search`, `display`, `active`) VALUES
	(57, 1, 'Play Name', 'play_name', b'1', b'1', b'1'),
	(58, 1, 'Speech Number', 'speech_number', b'1', b'1', b'1'),
	(59, 1, 'Line Number', 'line_number', b'1', b'1', b'1'),
	(60, 1, 'Speaker', 'speaker', b'1', b'1', b'1'),
	(61, 1, 'Text Entry', 'text_entry', b'1', b'1', b'1'),
	(62, 1, 'Line Id', 'line_id', b'1', b'1', b'1'),
	(63, 1, 'Type', 'type', b'1', b'1', b'1');
/*!40000 ALTER TABLE `columns` ENABLE KEYS */;

-- Dumping structure for table vite_db.indices
DROP TABLE IF EXISTS `indices`;
CREATE TABLE IF NOT EXISTS `indices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `index_name` varchar(200) NOT NULL,
  `index_url` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table vite_db.indices: ~2 rows (approximately)
/*!40000 ALTER TABLE `indices` DISABLE KEYS */;
INSERT INTO `indices` (`id`, `index_name`, `index_url`) VALUES
	(1, 'Shakespeare', 'shakespeare'),
	(2, 'Accounts', 'bank');
/*!40000 ALTER TABLE `indices` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
