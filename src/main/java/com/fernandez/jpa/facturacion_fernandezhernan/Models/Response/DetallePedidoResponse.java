package com.fernandez.jpa.facturacion_fernandezhernan.Models.Response;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Producto_Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedidoResponse {
    private long id_detalle;
    private Producto_Entity productodetalle;
    private int cantidad;
    private BigDecimal precio;
    private BigDecimal precioTotal;
}
