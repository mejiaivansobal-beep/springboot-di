package com.mejia.springboot.di.app.springboot_di.repositories;

import com.mejia.springboot.di.app.springboot_di.models.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/product.json"); // Leemos un archivo
        ObjectMapper mappe = new ObjectMapper(); // Es una libreria de Jackson: Esta API es para trabajar con JSON
        try {
            // Devuelve un Array y nosotros lo convertimso a un List
            list = Arrays.asList(mappe.readValue(resource.getFile(), Product[].class));// Convierte el resource a un archivo Json y poblamos
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
