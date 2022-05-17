alter table peliculas alter column id_director set default 3;

# -------> http://dev.mysql.com/doc/refman/5.7/en/view-updatability.html
insert into ejerc7 values('La prueba', 22,'Griega', 'Josefina Alvarez', 'Estefano Giolo', 66);
#//Can not insert into join view 'mispeliculas.ejerc7' without fields list

update ejerc7 set nacionalidad = 'China' where nombrePelicula = 'La aguja en el pajar';
#// Lo deja hacer y lo cambia en todas

delete from ejerc7 where id_Actor = 4 and id_pelicula = 5; 
#//Can not delete from join view 'mispeliculas.ejerc7'