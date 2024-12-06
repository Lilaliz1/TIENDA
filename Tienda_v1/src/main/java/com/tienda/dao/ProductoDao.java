package com.tienda.dao;


import com.tienda.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Lizeth
 */

  
public interface ProductoDao extends JpaRepository <Producto,Long> {

    @Override
    public default <S extends Producto> S save(S entity) {
        throw new UnsupportedOperationException("Not supported yet."); //id llave primaria de la producto> {
    
}
    
}

