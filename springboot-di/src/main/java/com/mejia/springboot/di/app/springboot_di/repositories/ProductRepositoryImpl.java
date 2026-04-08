package com.mejia.springboot.di.app.springboot_di.repositories;

import com.mejia.springboot.di.app.springboot_di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Primary
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria", 300L),
                new Product(2L, "Cpu", 850L),
                new Product(3L, "Teclado mini", 180L),
                new Product(4L, "Motherbopard", 490L)
        );
    }

    @Override
    public List<Product> findAll(){
        return this.data;
    }

    @Override
    public Product findById(Long id){
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
