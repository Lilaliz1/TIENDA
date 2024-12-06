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
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

   



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
  public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup); //query 1 de consultadas ampliadas (sencillas)
  
    @Query(nativeQuery=true,
            value="SELECT * FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
 
    // Obtener productos con inventario bajo
    public List<Producto> bajostock(int inventario);
}


    

