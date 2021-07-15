package ua.lviv.lgs.dao.impl;

import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.shared.FactoryManager;
import ua.lviv.lgs.utils.ConnectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private EntityManager em = FactoryManager.getEntityManager();

    @Override
    public Product create(Product product) {
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception e) {

        }
        return product;
    }

    @Override
    public Product read(Integer id) {
        Product product = null;
        try {
            product = em.find(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product update(Product t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Product> readAll() {
        Query query = null;
        try {
            query = em.createQuery("SELECT e FROM Product e");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (List<Product>) query.getResultList();
    }
}
