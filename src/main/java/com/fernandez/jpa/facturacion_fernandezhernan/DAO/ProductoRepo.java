package com.fernandez.jpa.facturacion_fernandezhernan.DAO;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Producto_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface ProductoRepo extends JpaRepository<Producto_Entity, Long> {

    @Query("Select p FROM Producto_Entity p WHERE p.codigoProducto =:codigo")
    public  Producto_Entity obtenerProductoPorCodigo(@Param("codigo")long codigo);


    @Query("Select p FROM Producto_Entity p WHERE p.codigoProducto =:codigo AND p.stock >:cantidad")
    public  Producto_Entity obtenerProductoyCantidad(@Param("codigo")long codigo, @Param("cantidad")int cantidad);

    @Transactional
    @Modifying
    @Query("delete FROM Producto_Entity p WHERE p.codigoProducto =:codigo")
    public  void BorrarProd(@Param("codigo")long codigo);

}
