drop table if exists tutoriza;
drop table if exists horario;
drop table if exists prerreq;
drop table if exists cursa;
drop table if exists alumno_3ciclo;
drop table if exists imparte;
drop table if exists grupo;
drop table if exists aula; 
drop table if exists materia;
drop table if exists docente;
drop table if exists departamento;


create table aula
	(edificio		varchar(34),
	 numero_sala	varchar(7),
	 capacidad		numeric(4,0),
	 primary key (edificio, numero_sala)
	);

create table departamento
	(nombre_dpto	varchar(32), 
	 edificio		varchar(34), 
	 presupuesto	numeric(12,2) check (presupuesto > 0),
	 primary key (nombre_dpto)
	);

create table materia
	(id_materia		varchar(8), 
	 nombre			varchar(50), 
	 nombre_dpto	varchar(32),
	 creditos		numeric(2,0) check (creditos > 0),
	 primary key (id_materia),
	 foreign key (nombre_dpto) references departamento(nombre_dpto)
		on delete set null
	);

create table docente
	(ID				varchar(5), 
	 nombre			varchar(20) not null, 
	 nombre_dpto	varchar(32), 
	 salario		numeric(8,2) check (salario > 10000),
	 primary key (ID),
	 foreign key (nombre_dpto) references departamento (nombre_dpto)
		on delete set null
	);

create table grupo
	(id_materia		varchar(8), 
     id_grupo		varchar(8),
	 cuatrimestre	varchar(7)
		check (cuatrimestre in ('Primero', 'Segundo')), 
	 anho			numeric(4,0) check (anho > 1701 and anho < 2100), 
	 edificio		varchar(34),
	 numero_sala	varchar(7),
	 id_horario		varchar(4),
	 primary key (id_materia, id_grupo, cuatrimestre, anho),
	 foreign key (id_materia) references materia (id_materia) 
		on delete cascade,
	 foreign key (edificio, numero_sala) references aula (edificio, numero_sala)
		on delete set null
	);

create table imparte
	(ID				varchar(5), 
	 id_materia		varchar(8),
	 id_grupo		varchar(8), 
	 cuatrimestre	varchar(7),
	 anho			numeric(4,0),
	 primary key (ID, id_materia, id_grupo, cuatrimestre, anho),
	 foreign key (id_materia, id_grupo, cuatrimestre, anho) references grupo (id_materia, id_grupo, cuatrimestre, anho)
		on delete cascade,
	 foreign key (ID) references docente (ID)
		on delete cascade
	);

create table alumno_3ciclo
	(ID				varchar(5), 
	 nombre			varchar(20) not null, 
	 nombre_dpto	varchar(32), 
	 tot_creditos	numeric(3,0) check (tot_creditos >= 0),
	 primary key (ID),
	 foreign key (nombre_dpto) references departamento (nombre_dpto)
		on delete set null
	);

create table cursa
	(ID				varchar(5), 
	 id_materia		varchar(8),
	 id_grupo		varchar(8), 
	 cuatrimestre	varchar(7),
	 anho			numeric(4,0),
	 nota		        varchar(3),
	 primary key (ID, id_materia, id_grupo, cuatrimestre, anho),
	 foreign key (id_materia,id_grupo, cuatrimestre, anho) references grupo (id_materia,id_grupo, cuatrimestre, anho)
		on delete cascade,
	 foreign key (ID) references alumno_3ciclo (ID)
		on delete cascade
	);

create table tutoriza
	(ID_a			varchar(5),
	 ID_d			varchar(5),
	 primary key (ID_a),
	 foreign key (ID_d) references docente (ID)
		on delete set null,
	 foreign key (ID_a) references alumno_3ciclo (ID)
		on delete cascade
	);

create table horario
	(id_horario		varchar(4),
	 dia			varchar(1),
	 hora_comienzo	numeric(2) check (hora_comienzo >= 0 and hora_comienzo < 24),
	 min_comienzo	numeric(2) check (min_comienzo >= 0 and min_comienzo < 60),
	 hora_fin		numeric(2) check (hora_fin >= 0 and hora_fin < 24),
	 min_fin		numeric(2) check (min_fin >= 0 and min_fin < 60),
	 primary key (id_horario, dia, hora_comienzo, min_comienzo)
	);

create table prerreq
	(id_materia		varchar(8), 
	 id_prerreq		varchar(8),
	 primary key (id_materia, id_prerreq),
	 foreign key (id_materia) references materia (id_materia)
		on delete cascade,
	 foreign key (id_prerreq) references materia (id_materia)
	);

