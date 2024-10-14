package com.ra.service.product;


import com.ra.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Boolean save(Product product);
    Product findById(int id);
    Boolean update(Product product);
    void delete(int id);
}
