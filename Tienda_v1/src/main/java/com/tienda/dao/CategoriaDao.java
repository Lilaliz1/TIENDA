package com.tienda.dao;


import com.tienda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Lizeth
 */

    
public interface CategoriaDao extends JpaRepository <Categoria,Long> {

    
    
}
