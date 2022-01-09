package com.viktor.beer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "beers")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beer_id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "beer_name")
    private String name;

    @Column(name = "abv")
    private double abv;

    @ManyToOne
    @JoinColumn(name = "style_id")
    private Style style;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserDetails owner;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "beer_tags",
            joinColumns = @JoinColumn(name = "beer_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    @JoinTable(
            name = "beer_rating",
            joinColumns = @JoinColumn(name = "beer_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Rating> ratingList;

    @Column(name = "picture")
    private String picture;

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    public Beer(int id, String name, double abv, Style style, List<Tag> tags, Brewery brewery) {
        setId(id);
        setName(name);
        setAbv(abv);
        setStyle(style);
        setTags(tags);
        setBrewery(brewery);
    }

    public Beer() {
        
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

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public UserDetails getOwner() {
        return owner;
    }

    public void setOwner(UserDetails owner) {
        this.owner = owner;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Double getAverageRating() {
//        double sum = 0.0;
//
//        for (int i = 0; i < ratingList.size(); i++) {
//            sum += ratingList.get(i).getRating();
//        }
//
//        if (ratingList.size() != 0) {
//            return sum / ratingList.size();
//        } else {
//            return 0.0;
//        }
//    }
}
