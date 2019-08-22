-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-08-2019 a las 05:15:43
-- Versión del servidor: 10.1.34-MariaDB
-- Versión de PHP: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


drop database baseproyectoisoo;
create database baseproyectoisoo;
use baseproyectoisoo;

--
-- Base de datos: `iso`
--
-- CREATE DATABASE IF NOT EXISTS `iso` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
-- USE `iso`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 NOT NULL,
  `estado` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `id` int(11) NOT NULL,
  `codigo` int(25) DEFAULT NULL,
  `serv` varchar(100) CHARACTER SET utf8 NOT NULL,
  `apl` varchar(100) CHARACTER SET utf8 NOT NULL,
  `plat` varchar(100) CHARACTER SET utf8 NOT NULL,
  `estadoserv` varchar(100) CHARACTER SET utf8 NOT NULL,
  `tieneip` tinyint(1) NOT NULL,
  `ip` int(11) NOT NULL,
  `estado` int(1) NOT NULL DEFAULT '1',
  `idcategoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) DEFAULT NULL,
  `contraseña` varchar(25) NOT NULL,
  `cargo` varchar(25) DEFAULT NULL,
  `telefono` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idcategoria` (`idcategoria`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `servicios`
--
ALTER TABLE `servicios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

-- Filtros para la tabla `servicios`
ALTER TABLE `servicios`
  ADD CONSTRAINT `servicios_ibfk_1` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`id`);
COMMIT;
--
-- Restricciones para tablas volcadas
--


-- ----------------------------------------------------------------


CREATE TABLE `temas` (
  `idTema` int(11) NOT NULL,
  `Tema` varchar(1000) DEFAULT NULL,
  `Aplicacion` varchar(1000) DEFAULT NULL,
  `Servicio` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idTema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE `problemas` (
  `idproblemas` int(11) NOT NULL,
  `Problema` varchar(1000) DEFAULT NULL,
  `idTema` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproblemas`),
  KEY `fkProblemaTema` (`idTema`),
  CONSTRAINT `fkProblemaTema` FOREIGN KEY (`idTema`) REFERENCES `temas` (`idTema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--

--




CREATE TABLE `soluciones` (
  `idSolucion` int(11) NOT NULL,
  `Solucion` varchar(1000) DEFAULT NULL,
  `idTema` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSolucion`),
  KEY `fkSolucionesTema` (`idTema`),
  CONSTRAINT `fkSolucionesTema` FOREIGN KEY (`idTema`) REFERENCES `temas` (`idTema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE  TABLE `solucionesaplicadas` (
  `idsolucionesAplicadas` int(11) NOT NULL,
  `SolucionAplicada` varchar(1000) DEFAULT NULL,
  `idTema` int(11) DEFAULT NULL,
  PRIMARY KEY (`idsolucionesAplicadas`),
  KEY `fkSolucionAplicadasTema` (`idTema`),
  CONSTRAINT `fkSolucionAplicadasTema` FOREIGN KEY (`idTema`) REFERENCES `temas` (`idTema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProblem`(in indice int,in problem varchar(1000),in idSubject int )
begin
insert into problemas(idproblemas,Problema,idTema)values(indice,problem,idSubject);
end ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProblemModify`(in problem varchar(1000),in idSubject int )
begin
insert into problemas(Problema,idTema)values(problem,idSubject);
end ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertSolucionAplicadasModify`(in solution varchar(1000),in idSubject int )
begin
insert into solucionesAplicadas(solucionaplicada,idTema)values(solution,idSubject);
end ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertSoluciones`(in indice int,in solution varchar(1000),in idSubject int )
begin
insert into soluciones(idSolucion,Solucion,idTema)values(indice,solution,idSubject);
end ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertSolucionesAplicadas`(in indice int,in solution varchar(1000),in idSubject int )
begin
insert into solucionesAplicadas(idsolucionesAplicadas,solucionaplicada,idTema)values(indice,solution,idSubject);
end ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertSolucionModify`(in solution varchar(1000),in idSubject int )
begin
insert into soluciones(solucion,idTema)values(solution,idSubject);
end ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertTemas`(in indice int,in temas varchar(1000),in Aplicaciones varchar(1000),in Servicios varchar(1000) )
begin
insert into temas(idTema,Tema,Aplicacion,Servicio)values(indice,temas,Aplicaciones,Servicios);
end ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertTemasModify`(in idSubject int ,in temas varchar(1000),in Aplicaciones varchar(1000),in Servicios varchar(1000) )
begin
update temas set idTema=idSubject,Tema=temas,Aplicacion=Aplicaciones,Servicio=Servicios where idTema=idSubject;
end ;;
DELIMITER ;



CREATE TABLE `baseproyectoisoo`.`login` (
  `idLogin` INT NOT NULL,
  `Usuario` VARCHAR(45) NOT NULL,
  `Clave` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLogin`));



-- Dump completed on 2019-08-19 15:01:14
