package com.mejia.springboot.di.app.springboot_di.services;

import com.mejia.springboot.di.app.springboot_di.models.Product;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);


}
