package com.fernandez.jpa.facturacion_fernandezhernan.Service.Impl;
import com.fernandez.jpa.facturacion_fernandezhernan.Builder.DetalleBuilder;
import com.fernandez.jpa.facturacion_fernandezhernan.Builder.ProductoBuilder;
import com.fernandez.jpa.facturacion_fernandezhernan.DAO.DetallePedidoRepo;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.DetallePedido_entity;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.DetallePedidoRequest;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.DetallePedidoResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ProductoResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.handle.ApiException;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.ProductoService;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.DetallePedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DetallePedidoImpl implements DetallePedidoService {

    private final DetallePedidoRepo repo;
    private final ProductoService pservice;

    public DetallePedidoResponse AgregarAlCarrito(DetallePedidoRequest dp) throws ApiException {
        try {
            ProductoResponse p = pservice.buscarPorProductoYcantidad(dp.getProductodetalle(), dp.getCantidad());
            pservice.descontarStock(dp.getProductodetalle(), dp.getCantidad());
            DetallePedido_entity dpEntity = new DetallePedido_entity();
            dpEntity.setCantidad(dp.getCantidad());
            dpEntity.setPrecio(p.getPrecioVenta());
            dpEntity.setPrecioTotal(p.getPrecioVenta().multiply(BigDecimal.valueOf(dp.getCantidad())));
            dpEntity.setProductodetalle(ProductoBuilder.ResponsetoEntity(p));
            repo.save(dpEntity);
            DetallePedidoResponse response = DetalleBuilder.entityToResponse(dpEntity);
            return response;
        }
        catch (Exception e){
            throw new ApiException(e.getMessage());
        }

    }




}
