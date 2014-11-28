-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.0.45-community-nt - MySQL Community Edition (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para banco
DROP DATABASE IF EXISTS `banco`;
CREATE DATABASE IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `banco`;


-- Volcando estructura para tabla banco.tarjetacredito
DROP TABLE IF EXISTS `tarjetacredito`;
CREATE TABLE IF NOT EXISTS `tarjetacredito` (
  `id` int(10) NOT NULL auto_increment,
  `numero` varchar(12) NOT NULL,
  `cupoMaximo` int(10) NOT NULL,
  `cupoDisponible` int(10) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `numeroComprobacion` varchar(7) NOT NULL,
  `contaseña` varchar(4) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `numero` (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.tarjetacredito: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `tarjetacredito` DISABLE KEYS */;
INSERT INTO `tarjetacredito` (`id`, `numero`, `cupoMaximo`, `cupoDisponible`, `tipo`, `numeroComprobacion`, `contaseña`) VALUES
	(1, '10', 100, 500, 'tipoV', '1000', '1111'),
	(2, '20', 200, 500, 'tipoM', '2000', '2222'),
	(3, '30', 300, 750, 'tipoV', '3000', '3333'),
	(4, '40', 400, 1000, 'tipoV', '4000', '4444'),
	(5, '50', 500, 900, 'tipoM', '5000', '5555'),
	(6, '60', 600, 500, 'tipoM', '6000', '6666');
/*!40000 ALTER TABLE `tarjetacredito` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
