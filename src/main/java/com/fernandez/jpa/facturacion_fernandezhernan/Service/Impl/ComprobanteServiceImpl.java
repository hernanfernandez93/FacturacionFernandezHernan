package com.fernandez.jpa.facturacion_fernandezhernan.Service.Impl;

import com.fernandez.jpa.facturacion_fernandezhernan.Builder.ClienteBuilder;
import com.fernandez.jpa.facturacion_fernandezhernan.Builder.ComprobanteBuilder;
import com.fernandez.jpa.facturacion_fernandezhernan.DAO.ComprobanteRepo;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Comprobante_Entity;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.ComprobanteRequest;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.DetallePedidoRequest;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ComprobanteResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.DetallePedidoResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ProductoResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.DetallePedidoService;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.ProductoService;
import com.fernandez.jpa.facturacion_fernandezhernan.handle.ApiException;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.ClienteService;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.ComprobanteService;
import com.fernandez.jpa.facturacion_fernandezhernan.external.DateApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ComprobanteServiceImpl implements ComprobanteService {

    private final ComprobanteRepo repo;
    private final ClienteService clienteservice;
    private final DetallePedidoService detalleService;
    private final ProductoService prodservice;

    public ComprobanteResponse crearcomprobante(ComprobanteRequest c) throws ApiException {
       try{
           Comprobante_Entity entity = new Comprobante_Entity();
           entity.setFechaEmsion(new DateApi().getDate().getCurrentDateTime());
           entity.setCliente(ClienteBuilder.ResponseToEntity(clienteservice.buscarPorDni(c.getDni())));

           for (int i = 0; i < c.getDetalle().size(); i++) {
               long prod = c.getDetalle().get(i).getProductodetalle();
               int cant = c.getDetalle().get(i).getCantidad();
               prodservice.buscarPorProductoYcantidad(prod, cant);
           }

           for (int i = 0; i < c.getDetalle().size(); i++) {
                   DetallePedidoResponse response = detalleService.AgregarAlCarrito(c.getDetalle().get(i));
           }
           entity.setTotal(calculartotal(c));
           repo.save(entity);
           return ComprobanteBuilder.entityToResponse(entity);

        }
        catch (Exception e){
           throw new ApiException(e.getMessage());
        }
    }

    public BigDecimal calculartotal (ComprobanteRequest c) throws ApiException {

        try {
            BigDecimal totalFactura = new BigDecimal(0);
            for (int i = 0; i < c.getDetalle().size(); i++) {
                int cantidad = c.getDetalle().get(i).getCantidad();
                long idprod = c.getDetalle().get(i).getProductodetalle();
                ProductoResponse p = prodservice.buscarPorCodigo(idprod);
                BigDecimal totalDetalle = p.getPrecioVenta();
                totalFactura = totalFactura.add((totalDetalle.multiply(BigDecimal.valueOf(cantidad))));
            }
            return totalFactura;
        }
        catch (Exception e){
            throw new ApiException(e.getMessage());
        }

    }

}
