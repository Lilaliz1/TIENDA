drop schema if exists practica; 
drop user if exists usuario_prueba; 
CREATE SCHEMA practica ; 
USE practica;
create user 'usuario_prueba'@'%' identified by 'Usuar1o_Clave.'; 

grant all privileges on practica.* to 'usuario_prueba'@'%'; 
flush privileges;


create table arbol (
  id_arbol INT NOT NULL AUTO_INCREMENT,
  nombreComun VARCHAR(30) NOT NULL,  
  tipodeFlor VARCHAR(1600) NOT NULL,
  durezadeMadera  VARCHAR(1600) NOT NULL,
  altura_metros INT, 
  ruta_imagen VARCHAR(1050),
  PRIMARY KEY (id_arbol)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


INSERT INTO practica.arbol (  nombreComun, tipodeFlor, durezadeMadera, altura_metros,ruta_imagen) VALUES 

('Roble','flores blancas o rosaditas con líneas rojas y amarillas por dentro',' La madera es dura y resistente, de color pardo con vetas oscuras.', 25 ,    'https://botanicodesantiago.com/wp-content/uploads/2018/09/Roble-200x300.jpg'),
('Caoba','flores en panículas axilares de pétalos blancos',' La madera de color marrón rojizo, pesada, dura y resistente a los insectos.', 25 ,    'https://botanicodesantiago.com/wp-content/uploads/2018/09/Caoba.jpg');

SHOW TABLES;
