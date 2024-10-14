package com.ra.service.product;

import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.dao.product.ProductDAO;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Boolean save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public Boolean update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public void delete(int id) {
        productDAO.delete(id);
    }
}