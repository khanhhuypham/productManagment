package com.ra.model.dao.category;

import com.ra.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        try{
            return session.createQuery("from Category", Category.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Category findById(int id) {
        Session session = sessionFactory.openSession();
        try{
            return session.get(Category.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Boolean save(Category category) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(category);
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
    public Boolean update(Category category) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(category);
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
