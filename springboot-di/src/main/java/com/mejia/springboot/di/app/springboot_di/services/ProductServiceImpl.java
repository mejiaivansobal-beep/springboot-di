package com.mejia.springboot.di.app.springboot_di.services;
/*En el service es donde nosotros trabajamos con los datos, accedemos a Repositories distintos para jugar con ellos etc. Todo relacionado a la logica del negocio*/

import com.mejia.springboot.di.app.springboot_di.models.Product;
import com.mejia.springboot.di.app.springboot_di.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Este componente es dependencia de ProductControllerImpl
@Service
public class ProductServiceImpl implements ProductService{
    // Sin inyeccion:
    // private ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();

    // Con inyeccion en el metodo:
    private ProductRepository productRepository; // Implementamos la interfaz

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){ // .map() significa que el objeto va a ser modificado
        return productRepository.findAll().stream().map(p -> { // Siempre debemos devolver despues de -> el objeto modificado.
            /* Cumplimos el principio de inmutabilidad al crear una nueva instancia y mandar un nuevo objeto modificado y no modificar y pasarle al .map el objeto de la lista original
            Product pro = new Product(p.getId(),p.getName(),); */
            //pro.setPrice((long) (p.getPrice() * 1.25));
            Product pro = (Product) p.clone(); // .clone() devuelve una nueva instancia del Product
            pro.setPrice((long) (p.getPrice() * 1.25));
            return  pro;
        }).collect(Collectors.toList()); // Como estabamos devolviendo un Stream<Product> al usar .stream() debemos hacer la inversa para convertir el stream a
        // una lista nuevamente ya que es lo que pide el metodo
    };

    public Product findById(Long id){
        return productRepository.findById(id);
    }
}
