package com.fernandez.jpa.facturacion_fernandezhernan.Service;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.ProductoRequest;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ProductoResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.handle.ApiException;

import java.util.List;

public interface ProductoService  {

    ProductoResponse buscarPorCodigo(long id) throws ApiException;
    ProductoResponse buscarPorProductoYcantidad(long id, int cantidad) throws ApiException;
    List<ProductoResponse> buscarTodos();
    ProductoResponse crear(ProductoRequest producto) throws ApiException;
    ProductoResponse actualizar(ProductoRequest producto) throws ApiException;
    void eliminarPorId(Long id)throws ApiException;
    void descontarStock (long id, int cantidad) throws ApiException;

}
