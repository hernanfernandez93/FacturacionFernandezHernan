package com.fernandez.jpa.facturacion_fernandezhernan.Controller;

import com.fernandez.jpa.facturacion_fernandezhernan.DAO.DetallePedidoRepo;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.DetallePedidoRequest;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.DetallePedidoResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.DetallePedidoService;
import com.fernandez.jpa.facturacion_fernandezhernan.handle.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detalle")
@RequiredArgsConstructor
public class DetalleController {

    @Autowired
    private DetallePedidoRepo repo;
    private final DetallePedidoService service;


    @PostMapping("/agregar")
    public ResponseEntity<DetallePedidoResponse> AgregarAlCarrito(@RequestBody DetallePedidoRequest dp) throws ApiException {
        return ResponseEntity.ok(service.AgregarAlCarrito(dp));
    }


}
