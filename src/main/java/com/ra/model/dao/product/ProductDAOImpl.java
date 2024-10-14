package com.ra.model.dao.product;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.openSession();
        try{
            return session.createQuery("from Product", Product.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        Session session = sessionFactory.openSession();
        try{
            return session.get(Product.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Boolean save(Product product) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }


    @Override
    public Boolean update(Product product) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return false;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();

        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
