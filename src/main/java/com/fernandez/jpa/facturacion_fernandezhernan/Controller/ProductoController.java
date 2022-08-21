package com.fernandez.jpa.facturacion_fernandezhernan.Controller;

import com.fernandez.jpa.facturacion_fernandezhernan.DAO.ProductoRepo;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Request.ProductoRequest;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Response.ProductoResponse;
import com.fernandez.jpa.facturacion_fernandezhernan.Service.ProductoService;
import com.fernandez.jpa.facturacion_fernandezhernan.handle.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {
    @Autowired
    private ProductoRepo productoRepo;
    private final ProductoService service;

    @GetMapping()
    public ResponseEntity<List<ProductoResponse>> obtenerProductos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> buscarPorCodigo(@PathVariable Long id) throws ApiException {
        return ResponseEntity.ok(service.buscarPorCodigo(id));
    }

    @GetMapping("/{id}/{cantidad}")
    public ResponseEntity<ProductoResponse> buscarPorCodigoYCantidad(@PathVariable long id, @PathVariable int cantidad) throws ApiException {
        return ResponseEntity.ok(service.buscarPorProductoYcantidad(id, cantidad));
    }

    @PostMapping("/actualizar")
    public ResponseEntity<ProductoResponse> actualizar(@RequestBody ProductoRequest p) throws ApiException {
        return ResponseEntity.ok(service.actualizar(p));
    }

    @PostMapping("/crear")
    public ResponseEntity<ProductoResponse> crear(@RequestBody ProductoRequest p) throws ApiException {
        return ResponseEntity.ok(service.crear(p));
    }


    @PostMapping("/eliminar/{codigoProducto}")
    public void eliminarPorId(@PathVariable Long codigoProducto)throws ApiException {
        service.eliminarPorId(codigoProducto);
    }


}
