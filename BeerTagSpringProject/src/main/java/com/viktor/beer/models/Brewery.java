package com.viktor.beer.models;

import javax.persistence.*;

@Entity
@Table(name = "brewery")
public class Brewery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brewery_id")
    private int id;

    @Column(name = "brewery_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public Brewery() {
    }

    public Brewery(String name) {
        setName(name);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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
}
