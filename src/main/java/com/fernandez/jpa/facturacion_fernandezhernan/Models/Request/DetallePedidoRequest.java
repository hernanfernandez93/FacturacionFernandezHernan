package com.fernandez.jpa.facturacion_fernandezhernan.Models.Request;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Producto_Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoRequest {

    private long productodetalle;
    private int cantidad;

}
