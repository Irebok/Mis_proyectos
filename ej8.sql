alter table peliculas add year int;

update peliculas set year = 2015 where id_pelicula = 2;
update peliculas set year = 2010 where id_pelicula = 3;
update peliculas set year = 1989 where id_pelicula = 4;
update peliculas set year = 1996 where id_pelicula = 5;
update peliculas set year = 2008 where id_pelicula = 9;
update peliculas set year = 2012 where id_pelicula = 10;
update peliculas set year = 2013 where id_pelicula = 12;
update peliculas set year = 1987 where id_pelicula = 11;
update peliculas set year = 1987 where id_pelicula = 14;

drop view if exists sigloxx;
create view SigloXX as (
        select id_pelicula, nombrePelicula, id_director, imdb, nacionalidad, valoracion, year from peliculas
        where year < 2000
);

select * from SigloXX where nacionalidad = 'inglesa';