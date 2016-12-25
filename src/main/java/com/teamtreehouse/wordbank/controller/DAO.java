package com.teamtreehouse.wordbank.controller;


import com.teamtreehouse.wordbank.model.Country;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class DAO {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @SuppressWarnings("unchecked")
    public static List<Country> fetchAllContacts() {
        List<Country> countries;
        try (Session session = sessionFactory.openSession()) {
            // Create Criteria
            Criteria criteria = session.createCriteria(Country.class);
            countries = criteria.list();
        }
        return countries;
    }

    public static void save(Country country) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(country);

        session.getTransaction().commit();

        session.close();
    }

    public static void update(Country country) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.update(country);

        session.getTransaction().commit();

        session.close();
    }

    public static void delete(Country country) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.delete(country);

        session.getTransaction().commit();

        session.close();
    }

    public static Country findById(String code) {
        Session session = sessionFactory.openSession();

        Country country = session.get(Country.class,code);

        session.close();

        return country;
    }
}
