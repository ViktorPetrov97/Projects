package com.viktor.beer.models;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int id;

    @Column(name = "country_name")
    @Size(min = 2,max = 15,message = "Name should be between 2 and 15 symbols")
    private String name;

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int countryId) {
        this.id = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
