package com.fernandez.jpa.facturacion_fernandezhernan.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Inventario {

    @Id
    @GeneratedValue
    private long ID_inventario;
    @OneToOne
    @JoinColumn(name = "ID-Producto")
    private Producto p;
    @Column
    private int cantidadPedida;
    @Column
    private Double PrecioFijado;


}
