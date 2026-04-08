package com.mejia.springboot.di.app.springboot_di.controllers;

import com.mejia.springboot.di.app.springboot_di.models.Product;
import com.mejia.springboot.di.app.springboot_di.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController { // El Controller tiene por defecto un contexto, alcance o scope que se llama Singleton
    // Quiere decir que es una instancia que es compartida por toda la aplicacion de los usuario.

    // Sin inyeccion:
    // private ProductServiceImpl productServiceImpl = new ProductServiceImpl(); // Es un atributo de ProductController

    // Con inyeccion en el constructor:
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*
    Aqui inyectamos la interfaz, no la clase ServiceImpl, que hace esto?
    Pues Spinrg va a buscar un Componente que implemente la interfaz y la va a inyectar.
     */


    @GetMapping("/productos")
    public List<Product> list(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product find(@PathVariable Long id){
        return productService.findById(id);
    }
}
