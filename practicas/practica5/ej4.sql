#insert into Peliculas values(32, 'La solucion imposible', 2, 021543, 7.23, 'Inglesa',2001, default);

alter table Peliculas add column hora timestamp default now();
alter table Actores add column hora timestamp default now();
alter table Directores add column hora timestamp default now();