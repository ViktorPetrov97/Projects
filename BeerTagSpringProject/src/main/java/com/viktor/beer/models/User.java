package com.viktor.beer.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Size(min = 4, message = "Username is required")
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @Size(min = 4, message = "Password is required")
    private String password;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(name = "enabled")
    private boolean enabled;

    @OneToOne
    @JoinTable(
            name = "user_details",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private UserDetails userDetails;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private Set<Authority> authoritySet;

    public boolean isAdmin() {
        return authoritySet.stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    }

    public Set<Authority> getAuthoritySet() {
        return authoritySet;
    }

    public void setAuthoritySet(Set<Authority> authoritySet) {
        this.authoritySet = authoritySet;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    // TODO: 9/23/2020 Connection between User and userDetails !!!

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }
}
