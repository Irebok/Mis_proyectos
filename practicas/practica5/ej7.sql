drop view if exists ejerc7;

create view ejerc7 as(
    select nombrePelicula, peliculas.id_pelicula, peliculas.nacionalidad, directores.nombredirector, actores.nombreactor, actores.id_actor from peliculas, actores
            inner join actuan on actuan.id_actor = actores.id_actor
            inner join directores on directores.id_director = id_director 
            where actuan.id_pelicula = peliculas.id_pelicula and directores.id_director = peliculas.id_director
            #group by peliculas.id_pelicula, nombrePelicula, directores.nombredirector, actores.nombreactor
            #order by nombrePelicula
);