package com.teamtreehouse.wordbank;

import com.teamtreehouse.wordbank.model.Country;
import com.teamtreehouse.wordbank.model.Country.CountryBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Application {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        /* Country country = new CountryBuilder("Faith")
                .withInternetUsers(76.2)
                .withLiteracy(83.2)
                .build();
        save(country); */

        // Display List
        fetchAllContacts().stream().forEach(System.out::println);

    }

    @SuppressWarnings("unchecked")
    private static List<Country> fetchAllContacts() {
        List<Country> countries;
        try (Session session = sessionFactory.openSession()) {
            // Create Criteria
            Criteria criteria = session.createCriteria(Country.class);
            countries = criteria.list();
        }

        return countries;
    }

    private static void save(Country country) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(country);

        session.getTransaction().commit();

        session.close();
    }

}
