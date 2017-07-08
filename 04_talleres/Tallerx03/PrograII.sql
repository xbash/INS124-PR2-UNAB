-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-06-2017 a las 19:32:58
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prograii`
--
CREATE DATABASE IF NOT EXISTS `prograii` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `prograii`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `folio` varchar(15) NOT NULL,
  `rut` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `glosa` varchar(45) DEFAULT NULL,
  `neto` float DEFAULT NULL,
  `iva` float DEFAULT NULL,
  `total` float DEFAULT NULL,
  `estadopago` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`folio`, `rut`, `nombre`, `glosa`, `neto`, `iva`, `total`, `estadopago`) VALUES
('09qwe', '09u', '09u', '09u', 10, 10, 10, 'S'),
('09u21e', '09u', '09u', '09u', 10, 10, 10, 's'),
('09u21e2', '09u', '09u', '09u', 10, 10, 10, 's'),
('12345', '165199782', 'RodrigoA', 'GLOSATEST', 10000, 1900, 11900, 'S'),
('123456', '171623512', 'Rodrigo', 'Testing No Pagado', 100000, 19000, 119000, 'N'),
('165199782', '165199782', 'pasodj', 'poj', 10, 20, 30, 'S'),
('3454', '123', '123', '1', 1222, 2222, 333, 'N'),
('918y2398', '165199782', 'Rodrigo', 'apodjapsodj', 10000, 20000, 50000, 'S'),
('adapsodjad', 'aposjdasd', 'asdpojads', 'asdpojasd', 20, 20, 20, 'S'),
('oihoih', 'oih', 'oih', 'oih', 10, 10, 10, 's');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`folio`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
