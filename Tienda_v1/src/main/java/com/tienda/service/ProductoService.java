/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Lizeth
 */
 package com.tienda.service;
import com.tienda.domain.Producto;
import java.util.List;

   



public interface ProductoService {
    
    // Se obtiene un listado de productos en un List
    public List<Producto> getProductos(boolean activos);//este es mi metodo
     ///Se obtiene un Producto, a partir del id de un Cateogira
    public Producto getProducto(Producto producto);

    ///Se inserta un nuevo Producto si el id del Producto esta vacio
    ///Se actualiza un Producto si el id del Producto no esta vacio
    public void save(Producto producto);

    ///Se elimina e producto que tiene el id pasado por parametro
    public void delete(Producto producto);
 
}
    

