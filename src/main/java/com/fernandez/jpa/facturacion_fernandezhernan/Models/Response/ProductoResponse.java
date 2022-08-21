package com.fernandez.jpa.facturacion_fernandezhernan.Models.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponse {

    private long id_producto;
    private long codigoProducto;
    private String descripcion;
    private BigDecimal precioVenta;
    private BigDecimal precioLista;
    private int stock;

}
