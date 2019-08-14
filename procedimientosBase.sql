
use ProyectoIsoo;






DELIMITER //;
create procedure insertTemas(in temas varchar(1000),in Aplicaciones varchar(1000),in Servicios varchar(1000) )
begin
insert into temas(Tema,Aplicacion,Servicio)values(temas,Aplicaciones,Servicios);
end

DELIMITER //;
create procedure insertTemasModify(in idSubject int ,in temas varchar(1000),in Aplicaciones varchar(1000),in Servicios varchar(1000) )
begin
insert into temas(idTemas,Tema,Aplicacion,Servicio)values(idSubject,temas,Aplicaciones,Servicios);
end

insertSolucionModify

DELIMITER //;
create procedure insertProblem(in problem varchar(1000),in idSubject int )
begin
insert into problemas(Problema,idTema)values(problem,idSubject);
end

DELIMITER //;
create procedure insertProblemModify(in problem varchar(1000),in idSubject int )
begin
insert into problemas(Problema,idTema)values(problem,idSubject);
end;

DELIMITER //;
create procedure insertSoluciones(in solucion varchar(1000),in idSubject int )
begin
insert into solucionesAplicadas(solucionesaplicadas,idTema)values(solution,idSubject);
end

DELIMITER //;
create procedure insertSolucionModify(in solution varchar(1000),in idSubject int )
begin
insert into soluciones(solucion,idTema)values(solution,idSubject);
end;

DELIMITER //;
create procedure insertSolucionesAplicadas(in solucion varchar(1000),in idSubject int )
begin
insert into solucionesAplicadas(solucionesaplicadas,idTema)values(solution,idSubject);
end

DELIMITER //;
create procedure insertSolucionAplicadasModify(in solution varchar(1000),in idSubject int )
begin
insert into solucionesAplicadas(solucionesaplicadas,idTema)values(solution,idSubject);
end;