package com.viktor.beer.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "beer_rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // TODO: 9/25/2020 Eventually here needs to be OneToOne with user 
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserDetails user;

    @ManyToOne
    @JoinColumn(name="beer_id")
    private Beer beer;


    @Column(name = "rating")
    @Positive
    @Min(value = 0,message = "You cannot rate with less than 0 stars")
    @Max(value = 5,message = "You cannot rate with more than 5 stars")
    private int rating;


    public Rating() {
    }

    public Rating(UserDetails user, Beer beer, int rate)
    {
        setRating(rate);
        setBeer(beer);
        setUser(user);
    }

    public Rating(int rating,Beer beer) {
        setRating(rating);
        setBeer(beer);
    }

    public int getRating() {
        return rating;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
