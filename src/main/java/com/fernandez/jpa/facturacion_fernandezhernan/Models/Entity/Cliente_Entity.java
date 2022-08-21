package com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table (name ="cliente")
public class Cliente_Entity {

    @Id
    private long dni;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Date fechaAlta;


}