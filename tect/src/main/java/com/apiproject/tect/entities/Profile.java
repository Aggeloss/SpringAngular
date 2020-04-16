package com.apiproject.tect.entities;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String country;
    private String city;
    private String description;

//    @OneToOne
//    @MapsId

    @OneToOne(targetEntity = AppUser.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser user;

    public Profile(int id, String country, String city, String description, AppUser user) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.description = description;
        this.user = user;
    }

    public Profile() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}
