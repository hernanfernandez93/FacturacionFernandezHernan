package com.fernandez.jpa.facturacion_fernandezhernan.Builder;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Producto_Entity;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.ProductoRequest;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ProductoResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ProductoBuilder {
    public static ProductoResponse entityToResponse(Producto_Entity p) {
        return ProductoResponse.builder()
                .id_producto(p.getIdproducto())
                .codigoProducto(p.getCodigoProducto())
                .descripcion(p.getDescripcion())
                .precioLista(p.getPrecioLista())
                .precioVenta(p.getPrecioVenta())
                .stock(p.getStock())
                .build();
    }

    public static List<ProductoResponse> entityToResponseList(List<Producto_Entity> entityList) {
        return entityList.stream().map(ProductoBuilder::entityToResponse).collect(Collectors.toList());
    }

    public static Producto_Entity requestToEntity(ProductoRequest p) {
        return Producto_Entity.builder()
                .codigoProducto (p.getCodigoProducto())
                .descripcion(p.getDescripcion())
                .precioLista(p.getPrecioLista())
                .precioVenta(p.getPrecioVenta())
                .stock(p.getStock())
                .build();
    }


    public static Producto_Entity ResponsetoEntity (ProductoResponse p) {
        return Producto_Entity.builder()
                .codigoProducto(p.getCodigoProducto())
                .descripcion(p.getDescripcion())
                .precioLista(p.getPrecioLista())
                .precioVenta(p.getPrecioVenta())
                .stock(p.getStock())
                .build();
    }
}
