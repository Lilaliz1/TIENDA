
package com.prueba1.domain;

/**
 *
 * @author Lizeth
 */
import jakarta.persistence.*; //jpa repository extraer info de la BD
import java.io.Serializable;// OBJETOS QUE ESTAN EN LA CLASE se puedan implementar en otros lugares
import lombok.Data;// metodos autom[aticamente definirle a java que esto es una clase de datos
public class Condominio {
  
  


@Data //clase de datos
@Entity //se va a mapear con una tabla de la BD la de techshop
@Table(name="Condominio")
public class Condominio implements Serializable {//
    
    private static final long serialVersionUID = 1L;//constante que permite doble confirmacion que tod lo que haya en esta clase se pueda serializar, si en algun momento se modifica un numero
    //en la BD que no haya incompatibilidad con este codigo, hace una doble verificcion de formato o numero acomoda los datos a como estan en la BD
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //idenfica el valor de la clave o la llave primaria, se va a autoincrementar
    @Column(name="id_condominio")
    private Long idcondominio;//en la tabla tenemos primary key que es= a idcondominio, se pone long pensando que lleguemos a tener muchos id, escalabilidad
    private String modelo;
    private double  precio_casa;
    private String imagen;
    private boolean activo;
    private int cuartos;
    
   

    public Condominio() {//constructor para el hybernet que es para extraer toda esa info de la BD, esto es lo mismo que getter y setter
    }

    public Condominio(String modelo, boolean activo) {
        this.modelo = modelo;
        this.activo = activo;
    }
} 
}

