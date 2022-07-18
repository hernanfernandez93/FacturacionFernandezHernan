package com.fernandez.jpa.facturacion_fernandezhernan.Repo;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepo extends JpaRepository<Cliente, Long> {

}