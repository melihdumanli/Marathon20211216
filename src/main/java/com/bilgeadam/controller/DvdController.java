package com.bilgeadam.controller;

import com.bilgeadam.model.DVDEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;

public class DvdController implements Serializable, IControllable<DVDEntity> {
    private static final long serialVersionUID = 9169889414480555269L;
    private static final Logger logger = Logger.getLogger(DvdController.class);

    @Override
    public void create(DVDEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.save(entity);
            session.getTransaction().commit();
            logger.info("DVD Entity saved successfully");
        } catch (Exception e) {
            logger.error("DVDEntityController.create() method failed" + DvdController.class);
            e.printStackTrace();
        }
    }

    @Override
    public void delete(DVDEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.remove(entity);
            session.getTransaction().commit();
            logger.info("DVDEntity deleted successfully");
        } catch (Exception e) {
            logger.error("DVDEntityController.delete() method failed" + DvdController.class);
            e.printStackTrace();
        }
    }

    @Override
    public void update(DVDEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.merge(entity);
            session.getTransaction().commit();
            logger.info("DVDEntity updated successfully");
        } catch (Exception e) {
            logger.error("DVDEntityController.update() method failed" + DvdController.class);
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<DVDEntity> list() {
        Session session = databaseConnectionHibernate();
        String hql = "FROM DVDEntity";
        TypedQuery<DVDEntity> query = session.createQuery(hql, DVDEntity.class);
        ArrayList<DVDEntity> results = (ArrayList<DVDEntity>) query.getResultList();
        return results;
    }

    @Override
    public DVDEntity find(long id) {
        Session session = databaseConnectionHibernate();
        DVDEntity dvdEntity;
        try {
            dvdEntity = session.find(DVDEntity.class, id);

            if (dvdEntity != null) {
                return dvdEntity;
            } else {
                System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
                return null;
            }
        } catch (Exception e) {
            logger.error("DVDEntityController find() method failed !!!!! " + DVDEntity.class);
            e.printStackTrace();
        }
        return null;
    }
}
