package com.fernandez.jpa.facturacion_fernandezhernan.Models.Response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResponse {
    private long dni;
    private String nombre;
    private String apellido;
    private Date fechaAlta;
}
