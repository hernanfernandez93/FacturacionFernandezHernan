package com.fernandez.jpa.facturacion_fernandezhernan.Builder;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.DetallePedido_entity;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.DetallePedidoResponse;

public class DetalleBuilder {

    public static DetallePedidoResponse entityToResponse(DetallePedido_entity p) {
        return DetallePedidoResponse.builder()
                .id_detalle(p.getId_detalle())
                .productodetalle(p.getProductodetalle())
                .cantidad(p.getCantidad())
                .precio(p.getPrecio())
                .precioTotal(p.getPrecioTotal())
                .build();
    }

}
