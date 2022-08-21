package com.fernandez.jpa.facturacion_fernandezhernan.Service;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.DetallePedidoRequest;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.DetallePedidoResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.handle.ApiException;

public interface DetallePedidoService {
    DetallePedidoResponse AgregarAlCarrito(DetallePedidoRequest dp) throws ApiException;
}
