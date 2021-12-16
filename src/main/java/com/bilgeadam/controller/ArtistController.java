package com.bilgeadam.controller;

import com.bilgeadam.model.ArtistEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;

public class ArtistController implements Serializable,IControllable<ArtistEntity> {
    private static final long serialVersionUID = 773751335028925237L;
    private static final Logger logger = Logger.getLogger(ArtistController.class);

    @Override
    public void create(ArtistEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.save(entity);
            session.getTransaction().commit();
            logger.info("Artist Entity saved successfully");
        } catch (Exception e) {
            logger.error("ArtistEntityController.create() method failed" + ArtistController.class);
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ArtistEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.remove(entity);
            session.getTransaction().commit();
            logger.info("Artist Entity deleted successfully");
        } catch (Exception e) {
            logger.error("ArtistEntityController.delete() method failed" + ArtistController.class);
            e.printStackTrace();
        }
    }

    @Override
    public void update(ArtistEntity entity) {
        try {
            Session session = databaseConnectionHibernate();
            session.getTransaction().begin();
            session.merge(entity);
            session.getTransaction().commit();
            logger.info("Artist Entity updated successfully");
        } catch (Exception e) {
            logger.error("ArtistEntityController.update() method failed" + ArtistController.class);
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<ArtistEntity> list() {
        Session session = databaseConnectionHibernate();
        String hql = "FROM ArtistEntity";
        TypedQuery<ArtistEntity> query = session.createQuery(hql, ArtistEntity.class);

        ArrayList<ArtistEntity> results = (ArrayList<ArtistEntity>) query.getResultList();
        results.stream().forEach(System.out::println);
        logger.info("Artist Entities listed successfully" + ArtistController.class);
        return results;
    }

    @Override
    public ArtistEntity find(long id) {
        Session session = databaseConnectionHibernate();
        ArtistEntity artistEntity;
        try {
            artistEntity = session.find(ArtistEntity.class, id);

            if (artistEntity != null) {
                return artistEntity;
            } else {
                System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
                return null;
            }
        } catch (Exception e) {
            logger.error("ArtistEntityController find() method failed !!!!! " + ArtistEntity.class);
            e.printStackTrace();
        }
        return null;
    }
}
