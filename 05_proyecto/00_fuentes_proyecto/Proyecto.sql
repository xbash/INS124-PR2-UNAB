-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: Proyecto
-- ------------------------------------------------------
-- Server version	5.6.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Vendedor`
--

DROP TABLE IF EXISTS `Vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Vendedor` (
  `Rut_Vendedor` varchar(15) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Rut_Vendedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vendedor`
--

LOCK TABLES `Vendedor` WRITE;
/*!40000 ALTER TABLE `Vendedor` DISABLE KEYS */;
INSERT INTO `Vendedor` VALUES ('13131313-6','Dummy','Rosas 3286 D1207'),('14141414-3','Rodrigo Gonzalez','San Pio X');
/*!40000 ALTER TABLE `Vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buses`
--

DROP TABLE IF EXISTS `buses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buses` (
  `Patente` varchar(10) NOT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  `cantidad_asientos` int(11) DEFAULT NULL,
  PRIMARY KEY (`Patente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buses`
--

LOCK TABLES `buses` WRITE;
/*!40000 ALTER TABLE `buses` DISABLE KEYS */;
INSERT INTO `buses` VALUES ('GJFV16','Mercedes',2016,5);
/*!40000 ALTER TABLE `buses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta_pasajes`
--

DROP TABLE IF EXISTS `venta_pasajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta_pasajes` (
  `Folio` int(11) NOT NULL,
  `CodigoViaje` int(11) DEFAULT NULL,
  `FechaVta` varchar(45) DEFAULT NULL,
  `Rut_Vendedor` varchar(15) DEFAULT NULL,
  `Precio` int(11) DEFAULT NULL,
  PRIMARY KEY (`Folio`),
  KEY `fk_CodigoViaje_idx` (`CodigoViaje`),
  KEY `fk_Rut_Vendedor_idx` (`Rut_Vendedor`),
  CONSTRAINT `fk_CodigoViaje` FOREIGN KEY (`CodigoViaje`) REFERENCES `viajes` (`CodigoViaje`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rut_Vendedor` FOREIGN KEY (`Rut_Vendedor`) REFERENCES `Vendedor` (`Rut_Vendedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_pasajes`
--

LOCK TABLES `venta_pasajes` WRITE;
/*!40000 ALTER TABLE `venta_pasajes` DISABLE KEYS */;
INSERT INTO `venta_pasajes` VALUES (100001,900001,'16/06/2017','16519978-2',10000),(100002,900001,'16/06/2017','16519978-2',10000),(100003,900001,'16/06/2017','16519978-2',10000),(100004,900001,'16/06/2017','16519978-2',10000),(100005,900001,'16/06/2017','16519978-2',10000),(100006,900002,'16/06/2017','15996272-5',25000),(100007,900002,'16/06/2017','15996272-5',25000),(100008,900002,'16/06/2017','16519978-2',25000);
/*!40000 ALTER TABLE `venta_pasajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viajes`
--

DROP TABLE IF EXISTS `viajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viajes` (
  `CodigoViaje` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `hora` varchar(45) DEFAULT NULL,
  `bus` varchar(10) DEFAULT NULL,
  `conductor` varchar(45) DEFAULT NULL,
  `origen` varchar(45) DEFAULT NULL,
  `destino` varchar(45) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `CantAsientos` int(11) DEFAULT NULL,
  `PasajesDisponibles` int(11) DEFAULT NULL,
  `estado` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`CodigoViaje`),
  KEY `fk_buses_idx` (`bus`),
  CONSTRAINT `fk_buses` FOREIGN KEY (`bus`) REFERENCES `buses` (`Patente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viajes`
--

LOCK TABLES `viajes` WRITE;
/*!40000 ALTER TABLE `viajes` DISABLE KEYS */;
INSERT INTO `viajes` VALUES (900001,'2017-06-16','23:40','GJFV16','Rodrigo','Santiago','Antartida',10000,5,0,'P'),(900002,'2017-06-16','23:59','GJFV16','Rodrigo Gonzalez','Santiago','Isla de Pascua',25000,5,2,'P');
/*!40000 ALTER TABLE `viajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_cuadraturacaja`
--

DROP TABLE IF EXISTS `view_cuadraturacaja`;
/*!50001 DROP VIEW IF EXISTS `view_cuadraturacaja`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_cuadraturacaja` AS SELECT 
 1 AS `Folio`,
 1 AS `CodigoViaje`,
 1 AS `FechaVta`,
 1 AS `Rut_Vendedor`,
 1 AS `precio`,
 1 AS `nombre`,
 1 AS `fecha`,
 1 AS `hora`,
 1 AS `bus`,
 1 AS `estado`,
 1 AS `DiaVenta`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_ventasmensuales`
--

DROP TABLE IF EXISTS `view_ventasmensuales`;
/*!50001 DROP VIEW IF EXISTS `view_ventasmensuales`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_ventasmensuales` AS SELECT 
 1 AS `Folio`,
 1 AS `CodigoViaje`,
 1 AS `FechaVta`,
 1 AS `Rut_Vendedor`,
 1 AS `Precio`,
 1 AS `Mes`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'Proyecto'
--

--
-- Dumping routines for database 'Proyecto'
--

--
-- Final view structure for view `view_cuadraturacaja`
--

/*!50001 DROP VIEW IF EXISTS `view_cuadraturacaja`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_cuadraturacaja` AS select `vp`.`Folio` AS `Folio`,`vp`.`CodigoViaje` AS `CodigoViaje`,`vp`.`FechaVta` AS `FechaVta`,`vp`.`Rut_Vendedor` AS `Rut_Vendedor`,`vp`.`Precio` AS `precio`,`v`.`nombre` AS `nombre`,`vi`.`fecha` AS `fecha`,`vi`.`hora` AS `hora`,`vi`.`bus` AS `bus`,`vi`.`estado` AS `estado`,substr(`vp`.`FechaVta`,1,2) AS `DiaVenta` from ((`venta_pasajes` `vp` join `vendedor` `v`) join `viajes` `vi`) where ((`vp`.`Rut_Vendedor` = `v`.`Rut_Vendedor`) and (`vi`.`CodigoViaje` = `vp`.`CodigoViaje`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_ventasmensuales`
--

/*!50001 DROP VIEW IF EXISTS `view_ventasmensuales`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_ventasmensuales` AS select `venta_pasajes`.`Folio` AS `Folio`,`venta_pasajes`.`CodigoViaje` AS `CodigoViaje`,`venta_pasajes`.`FechaVta` AS `FechaVta`,`venta_pasajes`.`Rut_Vendedor` AS `Rut_Vendedor`,`venta_pasajes`.`Precio` AS `Precio`,substr(`venta_pasajes`.`FechaVta`,4,2) AS `Mes` from `venta_pasajes` order by `venta_pasajes`.`CodigoViaje` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-16 22:48:12
