package com.fernandez.jpa.facturacion_fernandezhernan.DAO;


import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Comprobante_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprobanteRepo extends JpaRepository<Comprobante_Entity, Long> {

}