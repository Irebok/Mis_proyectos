create user 'usuario1'@'localhost' identified by 'usuario';
create user 'usuario2'@'localhost' identified by 'usuario';

GRANT SELECT ON mispeliculas.titulonacionalidad TO 'usuario1'@'localhost';
GRANT SELECT ON mispeliculas.ejerc7 TO 'usuario1'@'localhost';
GRANT SELECT ON mispeliculas.sigloXX TO 'usuario1'@'localhost';

GRANT SELECT ON mispeliculas.titulonacionalidad TO 'usuario2'@'localhost';
GRANT SELECT ON mispeliculas.ejerc7 TO 'usuario2'@'localhost';
GRANT SELECT ON mispeliculas.sigloXX TO 'usuario2'@'localhost';

FLUSH PRIVILEGES;