package com.teamtreehouse.wordbank.model;

import javax.persistence.*;

@Entity
public class Country {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private int id;


    // @Column
    private String name;

    @Column
    private Double internetUsers;

    @Column
    private Double literacy;

    public Country() {
    }

    public Country(CountryBuilder builder) {
        this.name = builder.name;
        this.internetUsers = builder.internetUsers;
        this.literacy = builder.literacy;
    }
    /*
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInternetUsers() {
        return internetUsers;
    }

    public void setInternetUsers(Double internetUsers) {
        this.internetUsers = internetUsers;
    }

    public double getLiteracy() {
        return literacy;
    }

    public void setLiteracy(Double literacy) {
        this.literacy = literacy;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", internetUsers=" + internetUsers +
                ", literacy=" + literacy +
                '}';
    }

    public static class CountryBuilder {
        private String name;
        private Double internetUsers;
        private Double literacy;

        public CountryBuilder(String name) {
            this.name = name;
        }

        public CountryBuilder withInternetUsers(Double internetUsers) {
            this.internetUsers = internetUsers;
            return this;
        }

        public CountryBuilder withLiteracy(Double literacy) {
            this.literacy = literacy;
            return this;
        }

        public Country build() {
            return new Country(this);
        }

}   }
