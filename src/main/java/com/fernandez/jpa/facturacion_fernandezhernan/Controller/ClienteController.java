package com.fernandez.jpa.facturacion_fernandezhernan.Controller;


import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.Cliente_Request;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ClienteResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.ClienteService;
import com.fernandez.jpa.facturacion_fernandezhernan.handle.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<List<ClienteResponse>> listarClientes(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{dni}")
    public ResponseEntity<ClienteResponse> buscarClientePorDni(@PathVariable Long dni) throws ApiException {
        return ResponseEntity.ok(clienteService.buscarPorDni(dni));
    }

    @PostMapping("/crear")
    public ResponseEntity<ClienteResponse> crearCliente(@RequestBody Cliente_Request cliente) throws ApiException {
        return ResponseEntity.ok(clienteService.crearCliente(cliente));
    }
}

