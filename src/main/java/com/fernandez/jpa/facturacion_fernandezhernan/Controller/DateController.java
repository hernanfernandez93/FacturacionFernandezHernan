package com.fernandez.jpa.facturacion_fernandezhernan.Controller;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.DateResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.DateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Hora")
public class DateController {

    private final DateService dateService;

    @GetMapping(produces ={MediaType.APPLICATION_JSON_VALUE})
    public String getDate(){
        DateResponse o = dateService.buscarHora();
        String d = o.getCurrentDateTime().toString();
        return d;
    }

}
