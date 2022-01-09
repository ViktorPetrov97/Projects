package com.viktor.beer.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(AuthorityId.class)
@Table(name = "authorities")
public class Authority {

    @Id
    @Column(name = "username")
    private String username;

    @Id
    @Column(name = "authority")
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Authority() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority1 = (Authority) o;
        return Objects.equals(username, authority1.username) &&
                Objects.equals(authority, authority1.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, authority);
    }
}
