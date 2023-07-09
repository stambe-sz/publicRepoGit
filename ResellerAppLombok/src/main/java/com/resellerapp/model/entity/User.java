package com.resellerapp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private Set<Offer> offers;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "buyer")
    private Set<Offer> boughtOffers;
}
