/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Lizeth
 */
public interface CategoriaDao {
    package com.tienda.dao;

import com.tienda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;//jpa es una dependencia para extraer metodos que ya estan definidos para crear los cruds: leer, eliminar, actualizar, crear

public interface CategoriaDao extends JpaRepository <Categoria,Long //id llave primaria de la categoria> {
    
}
    
}
