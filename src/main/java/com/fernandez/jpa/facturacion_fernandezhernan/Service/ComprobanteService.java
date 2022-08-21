package com.fernandez.jpa.facturacion_fernandezhernan.Service;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.ComprobanteRequest;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ComprobanteResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.handle.ApiException;

public interface ComprobanteService {
    ComprobanteResponse crearcomprobante(ComprobanteRequest c) throws ApiException;
    //ComprobanteResponse crearcomprobante(ComprobanteRequest c) throws ApiException;
}
