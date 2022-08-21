package com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table (name = "DetallePedido")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedido_entity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id_detalle;
    @ManyToOne
    @JoinColumn(name = "codigoProducto")
    private Producto_Entity productodetalle;
    @Column
    private int cantidad;
    @Column
    private BigDecimal precio;
    @Column
    private BigDecimal precioTotal;

}