package com.fernandez.jpa.facturacion_fernandezhernan.DAO;


import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.DetallePedido_entity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DetallePedidoRepo extends JpaRepository<DetallePedido_entity, Long> {

}