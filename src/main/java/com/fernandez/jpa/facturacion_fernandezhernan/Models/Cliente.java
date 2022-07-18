package com.fernandez.jpa.facturacion_fernandezhernan.Models;
import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Cliente {

    @Id
    private long dni;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private LocalDate fechaAlta;

}
