package com.fernandez.jpa.facturacion_fernandezhernan.Service.Impl;

import com.fernandez.jpa.facturacion_fernandezhernan.Builder.ClienteBuilder;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Cliente_Entity;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.Cliente_Request;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ClienteResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.DAO.ClienteRepo;
import com.fernandez.jpa.facturacion_fernandezhernan.handle.ApiException;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.ClienteService;
import com.fernandez.jpa.facturacion_fernandezhernan.external.DateApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImp implements ClienteService {

    private final ClienteRepo clienteRepository;

    @Override
    public List<ClienteResponse> buscarTodos() {
        List<Cliente_Entity> listaClientesEntities = clienteRepository.findAll();
        List<ClienteResponse> listaClienteResponse = ClienteBuilder.entityToResponseList(listaClientesEntities);
        return listaClienteResponse;
    }

    @Override
    public ClienteResponse crearCliente(Cliente_Request cliente) throws ApiException {
        try {
            Cliente_Entity buscado = clienteRepository.findById(cliente.getDni()).orElse(null);

            if (buscado == null) {
                Cliente_Entity clienteAGuardar = ClienteBuilder.requestToEntity(cliente);
                clienteAGuardar.setFechaAlta(new DateApi().getDate().getCurrentDateTime());
                Cliente_Entity entity = clienteRepository.save(clienteAGuardar);
                ClienteResponse clienteAResponder = ClienteBuilder.entityToResponse(entity);
                return clienteAResponder;
            } else {
                throw new ApiException("Cliente ya existe");
            }
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }

    @Override
    public ClienteResponse buscarPorDni (Long dni) throws ApiException{
       try {
           Cliente_Entity cliente = clienteRepository.findById(dni).orElse(null);
           if (cliente != null) {
               return ClienteBuilder.entityToResponse(cliente);
           } else {
               throw new ApiException("Cliente inexistente");
           }
       }
       catch (Exception e){
           throw new ApiException (e.getMessage());
       }

    }
}
