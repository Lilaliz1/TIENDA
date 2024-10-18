/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lizeth
 */
public class CategoriaServiceImpl {
    package com.tienda.service.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;//service es un estereotipo en java, esta clase es de servicio
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired// instancia en el service de la categoria dao del metodo findall, findbyid
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly=true)//cuando estoy agregando los metodos de findall, o por id
    public List<Categoria> getCategorias(boolean activos) {
        var lista=categoriaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());//no mostrar las categorias no activas
        }
        return lista;
    }
}
    
}
