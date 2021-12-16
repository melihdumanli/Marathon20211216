package com.bilgeadam.controller;

import com.bilgeadam.model.VinylEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;

public class VinylController implements Serializable, IControllable<VinylEntity> {
    private static final long serialVersionUID = 5090776801945348871L;
    private static final Logger logger = Logger.getLogger(DvdController.class);

    @Override
    public void create(VinylEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.save(entity);
            session.getTransaction().commit();
            logger.info("Vinyl Entity saved successfully");
        } catch (Exception e) {
            logger.error("Vinyl EntityController.create() method failed" + VinylController.class);
            e.printStackTrace();
        }
    }

    @Override
    public void delete(VinylEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.remove(entity);
            session.getTransaction().commit();
            logger.info("Vinyl Entity deleted successfully");
        } catch (Exception e) {
            logger.error("Vinyl EntityController.delete() method failed" + VinylController.class);
            e.printStackTrace();
        }
    }

    @Override
    public void update(VinylEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.merge(entity);
            session.getTransaction().commit();
            logger.info("Vinyl Entity updated successfully");
        } catch (Exception e) {
            logger.error("Vinyl EntityController.update() method failed" + VinylController.class);
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<VinylEntity> list() {
        Session session = databaseConnectionHibernate();
        String hql = "FROM VinylEntity";
        TypedQuery<VinylEntity> query = session.createQuery(hql, VinylEntity.class);

        ArrayList<VinylEntity> results = (ArrayList<VinylEntity>) query.getResultList();
        return results;
    }

    @Override
    public VinylEntity find(long id) {
        Session session = databaseConnectionHibernate();
        VinylEntity vinylEntity;
        try {
            vinylEntity = session.find(VinylEntity.class, id);

            if (vinylEntity != null) {
                return vinylEntity;
            } else {
                System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
                return null;
            }
        } catch (Exception e) {
            logger.error("VinylEntityController find() method failed !!!!! " + VinylEntity.class);
            e.printStackTrace();
        }
        return null;
    }
}
