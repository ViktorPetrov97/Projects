package com.viktor.beer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username")
    @Size(min = 2,max = 20,message = "Name not valid length!")
    private String username;

    @Column(name = "first_name")
    @Size(min = 2,max = 20,message = "First name not valid length!")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2,max = 20,message = "Last name not valid length!")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

//    @OneToOne
//    @JoinColumn(name = "username")
//    private User user;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email")
    @Size(min = 2,max = 50,message = "Email not valid length!") //todo pattern
        private String email;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "wish_beer_list",
            joinColumns = @JoinColumn(name = "beer_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Beer> usersWishList;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "drank_beer_list",
            joinColumns = @JoinColumn(name = "beer_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Beer> usersDrankList;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "beer_rating",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "id")
//    )
//    private List<Rating> ratedBeers;

    private String picture;

//    public List<Rating> getRatedBeers() {
//        return ratedBeers;
//    }
//
//    public void setRatedBeers(List<Rating> ratedBeers) {
//        this.ratedBeers = ratedBeers;
//    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Beer> getUsersWishList() {
        return usersWishList;
    }

    public Set<Beer> getUsersDrankList() {
        return usersDrankList;
    }

    public void addToWishlist(Beer beer){
        usersWishList.add(beer);
    }

    public void addToDranklist(Beer beer){
        usersDrankList.add(beer);
    }

//    public UserDetails(int id, String username, String email) {
//        setName(username);
//        setEmail(email);
//        setFirstName(firstName);
//        setLastName(lastName);
//    }

    public UserDetails() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
