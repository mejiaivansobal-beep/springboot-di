package com.mejia.springboot.di.app.springboot_di.services;
/*En el service es donde nosotros trabajamos con los datos, accedemos a Repositories distintos para jugar con ellos etc. Todo relacionado a la logica del negocio*/

import com.mejia.springboot.di.app.springboot_di.models.Product;
import com.mejia.springboot.di.app.springboot_di.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    // Forma 1
    @Autowired // Inyectamos el entorno de Spring para acceder a propiedades de archivos externos.
    // Sin esto tendriamos que escribir codigo complejo para abrir el archivo, leer lineas y buscvar el valor 1.25d.
    Environment environment;

    @Autowired
    @Qualifier("productList")
    private ProductRepository productRepository;

    // Forma 2
    @Value("${config.code}")
    Double tax;

    public List<Product> findAll(){
        return productRepository.findAll().stream().map(p -> {
            Product pro = (Product) p.clone();
            System.out.println(tax);
            // pro.setPrice((long) (p.getPrice() * environment.getProperty("config.code", Double.class))); Forma 1 usando Enviroment
            // Forma 2 usando @Value
            pro.setPrice((long) (p.getPrice() * tax));
            return  pro;
        }).collect(Collectors.toList());
    };

    public Product findById(Long id){
        return productRepository.findById(id);
    }
}
