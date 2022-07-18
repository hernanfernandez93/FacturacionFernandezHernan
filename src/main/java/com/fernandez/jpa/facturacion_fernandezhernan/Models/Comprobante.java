package com.fernandez.jpa.facturacion_fernandezhernan.Models;


import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Comprobante {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id_factura;
    @Column
    private LocalDate fechaEmsion;
    @OneToOne
    @JoinColumn(name = "DNICliente")
    private Cliente cliente;
    @Column
    private double precioLista;
    @OneToMany
    @JoinColumn(name = "DETALLE")
    private List<DetallePedido> detallePedidoList;

}
