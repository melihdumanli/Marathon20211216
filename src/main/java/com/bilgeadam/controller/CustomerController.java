package com.bilgeadam.controller;

import com.bilgeadam.model.CustomerEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;

public class CustomerController implements Serializable, IControllable<CustomerEntity> {

    private static final Logger logger = Logger.getLogger(CustomerController.class);
    private static final long serialVersionUID = 2277654766290830556L;

    @Override
    public void create(CustomerEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.save(entity);
            session.getTransaction().commit();
            logger.info("Customer Entity saved successfully");
        } catch (Exception e) {
            logger.error("CustomerEntityController.create() method failed" + CustomerController.class);
            e.printStackTrace();
        }

    }

    @Override
    public void delete(CustomerEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.remove(entity);
            session.getTransaction().commit();
            logger.info("CustomerEntity deleted successfully");
        } catch (Exception e) {
            logger.error("CustomerEntityController.delete() method failed" + CustomerController.class);
            e.printStackTrace();
        }
    }

    @Override
    public void update(CustomerEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.merge(entity);
            session.getTransaction().commit();
            logger.info("CustomerEntity updated successfully");
        } catch (Exception e) {
            logger.error("CustomerEntityController.update() method failed" + CustomerController.class);
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<CustomerEntity> list() {
        Session session = databaseConnectionHibernate();
        String hql = "FROM CustomerEntity";
        TypedQuery<CustomerEntity> query = session.createQuery(hql, CustomerEntity.class);

        ArrayList<CustomerEntity> list = (ArrayList<CustomerEntity>) query.getResultList();
        list.stream().forEach(System.out::println);
        logger.info("Customer Entities listed successfully" + CustomerEntity.class);
        return list;
    }

    @Override
    public CustomerEntity find(long id) {
        Session session = databaseConnectionHibernate();
        CustomerEntity customerEntity;
        try {
            customerEntity = session.find(CustomerEntity.class, id);

            if (customerEntity != null) {
                return customerEntity;
            } else {
                System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
                return null;
            }
        } catch (Exception e) {
            logger.error("CustomerEntityController find() method failed !!!!! " + CustomerEntity.class);
            e.printStackTrace();
        }
        return null;
    }

}
