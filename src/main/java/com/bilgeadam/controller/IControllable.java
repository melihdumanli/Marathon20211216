package com.bilgeadam.controller;

import com.bilgeadam.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.ArrayList;

public interface IControllable<T> {
    public void create(T entity);

    public void delete(T entity);

    public void update(T entity);

    public ArrayList<T> list();

    public T find(long id);

    default Session databaseConnectionHibernate() {
        return HibernateUtils.getSessionfactory().openSession();
    }
}
