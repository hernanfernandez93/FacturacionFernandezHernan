package com.fernandez.jpa.facturacion_fernandezhernan.Builder;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Cliente_Entity;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.Cliente_Request;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ClienteResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteBuilder {

    public static ClienteResponse entityToResponse(Cliente_Entity cliente) {
        return ClienteResponse.builder()
                .dni(cliente.getDni())
                .apellido(cliente.getApellido())
                .nombre(cliente.getNombre())
                .fechaAlta(cliente.getFechaAlta())
                .build();
    }

    public static Cliente_Entity ResponseToEntity(ClienteResponse cliente) {
        return Cliente_Entity.builder()
                .dni(cliente.getDni())
                .apellido(cliente.getApellido())
                .nombre(cliente.getNombre())
                .fechaAlta(cliente.getFechaAlta())
                .build();
    }


    public static List<ClienteResponse> entityToResponseList(List<Cliente_Entity> entityList) {
        return entityList.stream()
                .map(ClienteBuilder::entityToResponse)
                .collect(Collectors.toList());
    }

    public static Cliente_Entity requestToEntity(Cliente_Request cliente) {
        return Cliente_Entity.builder()
                .dni(cliente.getDni())
                .apellido(cliente.getApellido())
                .nombre(cliente.getNombre())
                .fechaAlta(null)
                .build();
    }

}
