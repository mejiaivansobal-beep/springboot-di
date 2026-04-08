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

    @Autowired
    Environment environment;

    @Autowired
    @Qualifier("productList")
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll().stream().map(p -> {
            Product pro = (Product) p.clone();
            pro.setPrice((long) (p.getPrice() * environment.getProperty("config.code", Double.class)));
            return  pro;
        }).collect(Collectors.toList());
    };

    public Product findById(Long id){
        return productRepository.findById(id);
    }
}
