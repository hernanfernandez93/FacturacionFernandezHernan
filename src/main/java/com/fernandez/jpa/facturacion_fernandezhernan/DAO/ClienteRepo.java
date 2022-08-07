package com.fernandez.jpa.facturacion_fernandezhernan.Repo;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Cliente_Entity;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ClienteResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepo extends JpaRepository<Cliente_Entity, Long> {

}