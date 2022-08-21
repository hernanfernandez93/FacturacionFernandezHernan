package com.fernandez.jpa.facturacion_fernandezhernan.Models.Request;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.DetallePedidoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class ComprobanteRequest {

    private Long dni;
    private List<DetallePedidoRequest> detalle;

}
