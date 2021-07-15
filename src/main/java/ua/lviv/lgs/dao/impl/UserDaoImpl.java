package ua.lviv.lgs.dao.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.shared.FactoryManager;
import ua.lviv.lgs.utils.ConnectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    private EntityManager em = FactoryManager.getEntityManager();


    @Override
    public User create(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }





    @Override
    public User read(Integer id) {
        User user = null;
        try {
            user = em.find(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }





    @Override
    public User update(User t) {
        // TODO Auto-generated method stub
        return null;
    }





    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }





    @Override
    public List<User> readAll() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User> from = criteria.from(User.class);
            criteria.select(from);
            criteria.where(builder.equal(from.get("email"), email));
            TypedQuery<User> typed = em.createQuery(criteria);
            user = typed.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
