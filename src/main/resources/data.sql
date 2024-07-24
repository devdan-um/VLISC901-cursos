insert into curso (DESCRIPCION, NOMBRE, CUATRIMESTRE) values ('Descripcion del objetivo del primer cuatrimestre', 'Primero', 1);
insert into curso (DESCRIPCION, NOMBRE, CUATRIMESTRE) values ('Descripcion del objetivo del primer cuatrimestre', 'Segundo', 2);
insert into curso (DESCRIPCION, NOMBRE, CUATRIMESTRE) values ('Descripcion del objetivo del primer cuatrimestre', 'Noveno', 9);

insert into materia (NOMBRE, ID_CURSO, HORAS_SEMANA) values ('Gestion de Proyectos', 1, 4);
insert into materia (NOMBRE, ID_CURSO, HORAS_SEMANA) values ('Desarrollo Web', 1, 5);
insert into materia (NOMBRE, ID_CURSO, HORAS_SEMANA) values ('Desarrollo Movil', 1, 6);


--select * from curso;
--select * from materia;
--select m.*
--from  curso c inner join materia m on  c.id_curso = m.id_curso;