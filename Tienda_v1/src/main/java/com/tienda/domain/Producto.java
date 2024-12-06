package com.tienda.domain;


import com.tienda.domain.Categoria;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lizeth
 */

 

@Data //clase de datos
@Entity //se va a mapear con una tabla de la BD la de techshop
@Table(name="producto")
public class Producto implements Serializable {//
    
    private static final long serialVersionUID = 1L;//constante que permite doble confirmacion que tod lo que haya en esta clase se pueda serializar, si en algun momento se modifica un numero
    //en la BD que no haya incompatibilidad con este codigo, hace una doble verificcion de formato o numero acomoda los datos a como estan en la BD
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //idenfica el valor de la clave o la llave primaria, se va a autoincrementar
    @Column(name="id_producto")
    private Long idProducto;//en la tabla tenemos primary key que es= a idproducto, se pone long pensando que lleguemos a tener muchos id, escalabilidad
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    private String detalle;
    private double precio;
    private int existencias;
    //private Long idCategoria;  //reemplazar con el many to one
    @ManyToOne
    @JoinColumn(name="id_Categoria")
    Categoria categoria;
    
    
    

    public Producto() {//constructor para el hybernet que es para extraer toda esa info de la BD, esto es lo mismo que getter y setter
    }

    public Producto(String producto, boolean activo) {
        this.descripcion = producto;
        this.activo = activo;
    }
} 

