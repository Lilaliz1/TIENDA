/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author Lizeth
 */
@Data //clase de datos
@Entity //se va a mapear con una tabla de la BD la de techshop
@Table(name = "rol")

public class Rol {

    private static final long serialVersionUID = 1L;//constante que permite doble confirmacion que tod lo que haya en esta clase se pueda serializar, si en algun momento se modifica un numero
    //en la BD que no haya incompatibilidad con este codigo, hace una doble verificcion de formato o numero acomoda los datos a como estan en la BD

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //idenfica el valor de la clave o la llave primaria, se va a autoincrementar
    @Column(name = "id_rol")
    private Long idRol;
    private String nombre;
    @Column(name = "id_usuario")

    private Long idUsuario;
}
