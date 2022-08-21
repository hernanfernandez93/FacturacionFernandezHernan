package com.fernandez.jpa.facturacion_fernandezhernan.Service.Impl;



import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.DateResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.DateService;
import com.fernandez.jpa.facturacion_fernandezhernan.external.DateApi;
import org.springframework.stereotype.Service;


@Service
public class DateServiceImp implements DateService {

    private final DateApi dateApi = new DateApi();

    @Override
    public DateResponse buscarHora(){
        return dateApi.getDate();
    }




}
