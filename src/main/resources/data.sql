insert into curso (DESCRIPCION, NOMBRE) values ('Descripcion del objetivo del noveno cuatrimestre ', 'Noveno');

insert into materia (NOMBRE, ID_CURSO, HORAS_SEMANA) values ('Gestion de Proyectos', 1, 4);
insert into materia (NOMBRE, ID_CURSO, HORAS_SEMANA) values ('Desarrollo Web', 1, 5);
insert into materia (NOMBRE, ID_CURSO, HORAS_SEMANA) values ('Desarrollo Movil', 1, 6);


--select * from curso;
--select * from materia;
--select m.*
--from  curso c inner join materia m on  c.id_curso = m.id_curso;