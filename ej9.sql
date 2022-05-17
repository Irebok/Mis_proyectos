insert into tituloNacionalidad (nombrePelicula, nacionalidad) values('El que rie el ultimo rie mejor', 'Italiana');
#// Deja hacerlo siempre y cuando los campos not null tengan valor por defecto

update tituloNacionalidad set nacionalidad = 'Rusa' where nombrePelicula = 'El que rie el ultimo rie mejor';
#// Cambia en peliculas y en las vistas

delete from tituloNacionalidad where nombrePelicula = 'El que rie el ultimo rie mejor';
#// La elimina de las vistas y de la relacion de peliculas

########### ejerc7 (group by) no va a ser posible realizar ninguna operacion

insert into ejerc7 values('El que rie el ultimo rie mejor', 45, 'Italiana', 'Josefina Alvarez', 'Estefano Giolo', 66);
#//The target table ejerc7 of the INSERT is not insertable-into

update ejerc7 set nacionalidad = 'China' where nombrePelicula = 'La aguja en el pajar';
#//The target table ejerc7 of the UPDATE is not updatable

delete from ejerc7 where id_Actor = 4 and id_pelicula = 5; 
#//#//The target table ejerc7 of the DELETE is not updatable

############# 

insert into sigloxx values(23,'Caminante del camino', 1,2223, 'Espanhola',6.23, 1987);
#// Cambia en peliculas y en las vistas

update sigloxx set valoracion = 9.99 where nombrePelicula = 'Caminante del camino';
#// Cambia en peliculas y en las vistas

delete from sigloxx where id_pelicula = 23; 
#// La elimina de peliculas y de las vistas


