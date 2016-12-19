package com.teamtreehouse.wordbank;

import com.teamtreehouse.wordbank.model.Country;
import com.teamtreehouse.wordbank.model.Country.CountryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Application {
    public static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        Country country = new CountryBuilder("Faith")
                .withInternetUsers(76.2)
                .withLiteracy(83.2)
                .build();
    }
}
