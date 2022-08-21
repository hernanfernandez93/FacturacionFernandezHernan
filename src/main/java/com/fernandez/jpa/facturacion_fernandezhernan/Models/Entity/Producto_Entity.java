package com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity;


import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table (name ="Producto")
public class Producto_Entity {


    @GeneratedValue (strategy=SEQUENCE)
    private long idproducto;
    @Id
    @Column
    private long codigoProducto;
    @Column
    private String descripcion;
    @Column
    private BigDecimal precioVenta;
    @Column
    private BigDecimal precioLista;
    @Column
    private int stock;

}
