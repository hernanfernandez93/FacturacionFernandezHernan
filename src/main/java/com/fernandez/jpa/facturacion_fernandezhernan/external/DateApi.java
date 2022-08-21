package com.fernandez.jpa.facturacion_fernandezhernan.external;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.DateResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DateApi {
    public DateResponse getDate(){
        RestTemplate restTemplate = new RestTemplate();
        final String url = "http://worldclockapi.com/api/json/utc/now";
        return restTemplate.getForObject(url, DateResponse.class,"currentDateTime");

    }
}
