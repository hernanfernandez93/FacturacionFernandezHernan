package com.fernandez.jpa.facturacion_fernandezhernan.Models;


import lombok.*;
import javax.persistence.*;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id_producto;
    @Column
    private String descripcion;
    @Column
    private double precioVenta;
    @Column
    private double precioLista;


}
