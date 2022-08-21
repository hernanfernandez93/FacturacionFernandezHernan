package com.fernandez.jpa.facturacion_fernandezhernan.Builder;


import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Comprobante_Entity;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Producto_Entity;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.ComprobanteRequest;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ComprobanteResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ProductoResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class ComprobanteBuilder {


    public static Comprobante_Entity requestToEntity(ComprobanteRequest c) {
        return Comprobante_Entity.builder()
                .cliente (null)
                .build();
    }

    public static ComprobanteResponse entityToResponse(Comprobante_Entity p) {
        return ComprobanteResponse.builder()
                .id_factura(p.getId_factura())
                .fechaEmsion(p.getFechaEmsion())
                .cliente(p.getCliente())
                .totalfactura(p.getTotal())
                .build();
    }

    public static List<ProductoResponse> entityToResponseList(List<Producto_Entity> entityList) {
        return entityList.stream().map(ProductoBuilder::entityToResponse).collect(Collectors.toList());
    }


}
