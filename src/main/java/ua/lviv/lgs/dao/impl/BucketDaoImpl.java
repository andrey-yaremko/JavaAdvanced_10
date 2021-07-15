package ua.lviv.lgs.dao.impl;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.shared.FactoryManager;
import ua.lviv.lgs.utils.ConnectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BucketDaoImpl implements BucketDao {

    private EntityManager em = FactoryManager.getEntityManager();

    @Override
    public Bucket create(Bucket bucket) {
        try {
            em.getTransaction().begin();
            em.persist(bucket);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bucket;
    }

    @Override
    public Bucket read(Integer id) {
        Bucket bucket = null;
        try {
            bucket = em.find(Bucket.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Bucket update(Bucket t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Integer id) {
        try {
            Bucket bucket = read(id);
            em.getTransaction().begin();
            em.remove(bucket);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bucket> readAll() {
        Query query = null;
        try {
            query = em.createQuery("Select e From Bucket e");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return query.getResultList();
    }

}
