package com.resellerapp.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Email
    @Column(nullable = false,unique = true)
    private String email;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private Set<Offer> offers;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "buyer")
    private Set<Offer> boughtOffers;

    public User() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Set<Offer> getBoughtOffers() {
        return boughtOffers;
    }

    public void setBoughtOffers(Set<Offer> boughtOffers) {
        this.boughtOffers = boughtOffers;
    }
}
