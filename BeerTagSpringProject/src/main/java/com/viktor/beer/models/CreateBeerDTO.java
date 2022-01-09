package com.viktor.beer.models;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class CreateBeerDTO {
    private int id;
    @Size(min = 5, max = 20, message = "Name must be between 2 & 20 symbols!")
    private String name;
    @PositiveOrZero(message = "ABV must be non negative number!")
    private double abv;
    @Positive(message = "StyleId must be positive number!")
    private int styleId;
    @Positive(message = "BreweryId must be positive number!")
    private int breweryId;
    @PositiveOrZero(message = "TagID should be positive ot zero")
    private int tagId;

    private String picture;

    public CreateBeerDTO() {
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

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
