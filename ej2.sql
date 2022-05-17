use mispeliculas;
alter table Peliculas add Valoracion decimal(3,2);
update peliculas set valoracion = 0.034 where id_pelicula = 3;