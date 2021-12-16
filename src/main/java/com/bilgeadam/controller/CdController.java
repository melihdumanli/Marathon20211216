package com.bilgeadam.controller;

import com.bilgeadam.model.CDEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;

public class CdController implements Serializable, IControllable<CDEntity> {
    private static final long serialVersionUID = -6980607845534064673L;
    private static final Logger logger = Logger.getLogger(CdController.class);

    @Override
    public void create(CDEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.save(entity);
            session.getTransaction().commit();
            logger.info("CD Entity saved successfully");
        } catch (Exception e) {
            logger.error("CDEntityController.create() method failed" + CdController.class);
            e.printStackTrace();
        }
    }

    @Override
    public void delete(CDEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.remove(entity);
            session.getTransaction().commit();
            logger.info("CDEntity deleted successfully");
        } catch (Exception e) {
            logger.error("CDEntityController.delete() method failed" + CdController.class);
            e.printStackTrace();
        }
    }

    @Override
    public void update(CDEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.merge(entity);
            session.getTransaction().commit();
            logger.info("CDEntity updated successfully");
        } catch (Exception e) {
            logger.error("CDEntityController.update() method failed" + CdController.class);
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<CDEntity> list() {
        Session session = databaseConnectionHibernate();
        String hql = "FROM CDEntity";
        TypedQuery<CDEntity> query = session.createQuery(hql, CDEntity.class);

        ArrayList<CDEntity> results = (ArrayList<CDEntity>) query.getResultList();
        results.stream().forEach(System.out::println);
        logger.info("CD Entities listed successfully" + CdController.class);
        return results;
    }

    @Override
    public CDEntity find(long id) {
        return null;
    }
}
