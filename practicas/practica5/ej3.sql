alter table Actores add column Nacionalidad char(40) default 'Estadounidense';
alter table Directores add column Nacionalidad char(40) default 'Estadounidense';
alter table Peliculas add column Nacionalidad char(40) default 'Estadounidense';

update Peliculas set nacionalidad = 'Espanhola' where id_pelicula = 4;
update Peliculas set nacionalidad = 'Danesa' where id_pelicula = 1;
update Peliculas set nacionalidad = 'Inglesa' where id_pelicula = 5;

insert into Peliculas values(null, 'La aguja en el pajar', 1, 2359, 6.0, DEFAULT);  