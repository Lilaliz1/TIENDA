/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba1.dao;

/**
 *
 * @author Lizeth
 */
import com.prueba1.domain.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;//jpa es una dependencia para extraer metodos que ya estan definidos para crear los cruds: leer, eliminar, actualizar, crear


    


public interface CondominioDao extends JpaRepository <Condominio,Long> {

  //  @Override
//    public default <S extends prueba_1> S save(S entity) {
      //  throw new UnsupportedOperationException("Not supported yet."); //id llave primaria de la categoria> {

//}

}