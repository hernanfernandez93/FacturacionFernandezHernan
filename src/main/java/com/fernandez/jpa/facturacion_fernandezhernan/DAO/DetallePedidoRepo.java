package com.fernandez.jpa.facturacion_fernandezhernan.Repo;


import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.DetallePedido_entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetallePedidoRepo extends JpaRepository<DetallePedido_entity, Long> {

}