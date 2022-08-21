package com.fernandez.jpa.facturacion_fernandezhernan.Models.Response;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Cliente_Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ComprobanteResponse {

    private long id_factura;
    private Date fechaEmsion;
    private Cliente_Entity cliente;
    private List<DetallePedidoResponse> detalle;
    private BigDecimal totalfactura;

}
