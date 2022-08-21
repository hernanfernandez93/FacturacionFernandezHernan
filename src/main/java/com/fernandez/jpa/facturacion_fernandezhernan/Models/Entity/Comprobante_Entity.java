package com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table (name = "COMPROBANTE")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comprobante_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_factura;
    @Column
    private Date fechaEmsion;
    @ManyToOne
    @JoinColumn(name = "DNICliente")
    private Cliente_Entity cliente;
    @ManyToMany
    @JoinColumn(name = "id_detalle", columnDefinition = "text[]")
    private List<DetallePedido_entity> detalle;
    private BigDecimal total;
}
