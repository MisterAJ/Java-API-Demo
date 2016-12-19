package com.teamtreehouse.wordbank.model;

import javax.persistence.*;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private double internetUsers;

    @Column
    private double literacy;

    public Country() {
    }

    public Country(CountryBuilder builder) {
        this.name = builder.name;
        this.internetUsers = builder.internetUsers;
        this.literacy = builder.literacy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInternetUsers() {
        return internetUsers;
    }

    public void setInternetUsers(float internetUsers) {
        this.internetUsers = internetUsers;
    }

    public double getLiteracy() {
        return literacy;
    }

    public void setLiteracy(float literacy) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (getId() != country.getId()) return false;
        if (Double.compare(country.getInternetUsers(), getInternetUsers()) != 0) return false;
        if (Double.compare(country.getLiteracy(), getLiteracy()) != 0) return false;
        return getName() != null ? getName().equals(country.getName()) : country.getName() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        temp = Double.doubleToLongBits(getInternetUsers());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLiteracy());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public static class CountryBuilder {
        private String name;
        private double internetUsers;
        private double literacy;

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
