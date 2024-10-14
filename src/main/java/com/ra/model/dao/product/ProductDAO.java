package com.ra.model.dao.product;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    Boolean save(Product product);
    Product findById(int id);
    Boolean update(Product product);
    void delete(int id);
}
