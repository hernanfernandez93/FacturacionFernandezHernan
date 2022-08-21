package com.fernandez.jpa.facturacion_fernandezhernan.Service;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.Cliente_Request;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ClienteResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.handle.ApiException;

import java.util.List;

public interface ClienteService {
    List<ClienteResponse> buscarTodos();
    ClienteResponse buscarPorDni (Long dni) throws ApiException;
    ClienteResponse crearCliente(Cliente_Request cliente) throws ApiException;

}
