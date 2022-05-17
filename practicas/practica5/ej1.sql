use misPeliculas

alter table Peliculas drop foto;
alter table Peliculas drop nombreFoto;

alter table Actores add foto blob not null;
alter table Directores add foto blob not null;
