package com.fernandez.jpa.facturacion_fernandezhernan.Models;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Producto;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Builder
@Data
public class DetallePedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id_detalle;
    @OneToOne
    @JoinColumn
    private Producto productodetalle;
    @Column
    private int cantidad;
    @Column
    private double precio;

}