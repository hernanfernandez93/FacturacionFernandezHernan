package com.fernandez.jpa.facturacion_fernandezhernan.Controller;


import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.ComprobanteRequest;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ComprobanteResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.ComprobanteService;
import com.fernandez.jpa.facturacion_fernandezhernan.handle.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Comprobante")
@RequiredArgsConstructor
public class ComprobanteController {

    private final ComprobanteService service;
    @PostMapping("/crear")
    public ResponseEntity<ComprobanteResponse> crear(@RequestBody ComprobanteRequest c) throws ApiException {
        return ResponseEntity.ok(service.crearcomprobante(c));
    }

}

