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
public class ProductController {
    // Sin inyeccion:
    // private ProductServiceImpl productServiceImpl = new ProductServiceImpl(); // Es un atributo de ProductController

    // Inyeccion en el constructor:

    private ProductService productService;

    // @Autowired no es necesario escribir esta anotacion cuando pasamos un componente en el constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/productos")
    public List<Product> list(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product find(@PathVariable Long id){
        return productService.findById(id);
    }
}
