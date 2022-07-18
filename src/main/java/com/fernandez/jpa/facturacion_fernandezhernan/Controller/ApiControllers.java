package com.fernandez.jpa.facturacion_fernandezhernan.Controller;

import com.fernandez.jpa.facturacion_fernandezhernan.Models.Cliente;
import com.fernandez.jpa.facturacion_fernandezhernan.Models.Producto;
import com.fernandez.jpa.facturacion_fernandezhernan.Repo.ClienteRepo;
import com.fernandez.jpa.facturacion_fernandezhernan.Repo.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.PostLoad;
import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @GetMapping (value ="/productos")
    public List<Producto> getProductos(){
        return productoRepo.findAll();
    }


    @GetMapping(value = "/")
    public String getPage(){
        return "welcome";
    }

    @PostMapping(value ="/saveproducto")
    public String ingresarProducto(@RequestBody Producto p){
        productoRepo.save(p);
        return "success";
    }

    @PostMapping (value = "/savecliente")
    public String ingresarCliente(@RequestBody Cliente c){
        clienteRepo.save(c);
        return "success";
    }


}
