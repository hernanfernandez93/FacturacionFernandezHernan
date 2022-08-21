package com.fernandez.jpa.facturacion_fernandezhernan.Service.Impl;

import com.fernandez.jpa.facturacion_fernandezhernan.Builder.ProductoBuilder;
import com.fernandez.jpa.facturacion_fernandezhernan.DAO.ProductoRepo;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Entity.Producto_Entity;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.ProductoRequest;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ProductoResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.handle.ApiException;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImp implements ProductoService {

    private final ProductoRepo prodrepo;

    @Override
    public ProductoResponse buscarPorCodigo(long id)throws ApiException {
        try {
            Producto_Entity p = prodrepo.obtenerProductoPorCodigo(id);
            if (p==null){
                throw new ApiException("Elemento no encontrado");
            }
            else{
                return ProductoBuilder.entityToResponse(p);
            }
        }
        catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }

    public ProductoResponse buscarPorProductoYcantidad(long id, int cantidad) throws ApiException{
        try {
            Producto_Entity p = prodrepo.obtenerProductoyCantidad(id,cantidad);
            if (p==null){
                throw new ApiException("Elemento no existente o cantidad insuficiente del producto: " + id);
            }
            else{
                return ProductoBuilder.entityToResponse(p);
            }
        }
        catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }


    @Override
    public List<ProductoResponse> buscarTodos() {
        List<Producto_Entity> listaProductosEntities = prodrepo.findAll();
        return ProductoBuilder.entityToResponseList(listaProductosEntities);
    }

    @Override
    public ProductoResponse crear(ProductoRequest producto) throws ApiException {
        try{
            Producto_Entity p = prodrepo.obtenerProductoPorCodigo(producto.getCodigoProducto());
            if (p == null){
                Producto_Entity pAguardar= ProductoBuilder.requestToEntity(producto);
                Producto_Entity entity = prodrepo.save(pAguardar);
                ProductoResponse response = ProductoBuilder.entityToResponse(entity);
                return response;
            }
            else{
                throw new ApiException("Producto Existente");
            }
        }
        catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }
    public ProductoResponse actualizar(ProductoRequest producto) throws ApiException {

        try {
            ProductoResponse buscado = buscarPorCodigo(producto.getCodigoProducto());
            prodrepo.delete(ProductoBuilder.ResponsetoEntity(buscado));
            Producto_Entity updated = prodrepo.save(ProductoBuilder.requestToEntity(producto));
            return ProductoBuilder.entityToResponse(updated);
        }
        catch (Exception e){
            throw new ApiException(e.getMessage());
        }
    }

    public void eliminarPorId(Long id)throws ApiException{
        try {
            ProductoResponse eliminar = buscarPorCodigo(id);
            prodrepo.BorrarProd(eliminar.getCodigoProducto());
        }
        catch (Exception e) {
            throw new ApiException(e.getMessage());
        }

    }

    @Override
    public void descontarStock (long id, int cantidad) throws ApiException{
        try {
            ProductoResponse buscado = buscarPorProductoYcantidad(id,cantidad);
            buscado.setStock(buscado.getStock()-cantidad);
            prodrepo.delete(ProductoBuilder.ResponsetoEntity(buscado));
            prodrepo.save(ProductoBuilder.ResponsetoEntity(buscado));
        }
        catch (Exception e){
            throw new ApiException(e.getMessage());
        }
    }


}
