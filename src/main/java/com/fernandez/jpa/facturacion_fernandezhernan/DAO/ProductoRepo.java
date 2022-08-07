package com.fernandez.jpa.facturacion_fernandezhernan.Repo;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Producto_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepo extends JpaRepository<Producto_Entity, Long> {


}
