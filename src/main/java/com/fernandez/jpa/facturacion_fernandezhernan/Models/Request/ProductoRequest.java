package com.fernandez.jpa.facturacion_fernandezhernan.Models.Request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequest {

    private Long codigoProducto;
    private String descripcion;
    private BigDecimal precioVenta;
    private BigDecimal precioLista;
    private int stock;

}
