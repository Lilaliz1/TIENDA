package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoDao extends JpaRepository <Producto,Long> {
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup); //query 1 de consultadas ampliadas (sencillas)
    
    //Ejemplo de método utilizando Consultas con JPQL
    @Query(value="SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery=true,
            value="SELECT * FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
  
@Query(value = "SELECT a FROM Producto a WHERE a.cantidad < :inventario ORDER BY a.descripcion ASC")
public List<Producto> bajostock(@Param("inventario") int Inventario);


@Query(nativeQuery = true, value = "SELECT * FROM producto WHERE producto.cantidad < :inventario ORDER BY producto.descripcion ASC")
public List<Producto> bajostockNativo(@Param("inventario") int Inventario);

}