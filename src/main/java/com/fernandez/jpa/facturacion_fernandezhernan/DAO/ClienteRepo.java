package com.fernandez.jpa.facturacion_fernandezhernan.DAO;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Cliente_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente_Entity, Long> {

}