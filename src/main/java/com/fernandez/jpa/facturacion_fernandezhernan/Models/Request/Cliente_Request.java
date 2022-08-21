package com.fernandez.jpa.facturacion_fernandezhernan.Models.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente_Request {
    private String nombre;
    private String apellido;
    private Long dni;
}
