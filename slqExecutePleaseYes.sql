insert into problemas values(0,'nulo',0);
insert into soluciones values(0,'nulo',0);
insert into solucionesAplicadas values(0,'nulo',0);
insert into temas values(0,'nulo',0);

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertSolucionesAplicadas`(in indice int,in solution varchar(1000),in idSubject int )
begin
insert into solucionesAplicadas(idsolucionesAplicadas,solucionaplicada,idTema)values(indice,solution,idSubject);
end$$
DELIMITER ;

DELIMITER 
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProblem`(in indice int,in problem varchar(1000),in idSubject int )
begin
insert into problemas(idproblemas,Problema,idTema)values(indice,problem,idSubject);
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertSoluciones`(in indice int,in solution varchar(1000),in idSubject int )
begin
insert into soluciones(idSolucion,Solucion,idTema)values(indice,solution,idSubject);
end$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertTemas`(in indice int,in temas varchar(1000),in Aplicaciones varchar(1000),in Servicios varchar(1000) )
begin
insert into temas(idTema,Tema,Aplicacion,Servicio)values(indice,temas,Aplicaciones,Servicios);
end$$
DELIMITER ;