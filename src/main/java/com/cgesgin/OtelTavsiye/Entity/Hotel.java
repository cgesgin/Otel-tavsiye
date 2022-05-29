package com.cgesgin.OtelTavsiye.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "starRating")
    private int starRating;

    @Column(name = "iscarPark")
    private boolean iscarPark;

    @Column(name = "isVentilation")
    private boolean isVentilation;

    @Column(name = "isWifi")
    private boolean isWifi;

    @Column(name = "isAward")
    private boolean isAward;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Comment> comments;

    public Hotel() {
        this.comments= new HashSet<>();
    }

    public Hotel(int id, String name, int starRating, boolean iscarPark, boolean isVentilation, boolean isWifi, boolean isAward, String email, Set<Comment> comments) {
        this.id = id;
        this.name = name;
        this.starRating = starRating;
        this.iscarPark = iscarPark;
        this.isVentilation = isVentilation;
        this.isWifi = isWifi;
        this.isAward = isAward;
        this.email = email;
        this.comments = comments;
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

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public boolean isIscarPark() {
        return iscarPark;
    }

    public void setIscarPark(boolean iscarPark) {
        this.iscarPark = iscarPark;
    }

    public boolean isVentilation() {
        return isVentilation;
    }

    public void setVentilation(boolean ventilation) {
        isVentilation = ventilation;
    }

    public boolean isWifi() {
        return isWifi;
    }

    public void setWifi(boolean wifi) {
        isWifi = wifi;
    }

    public boolean isAward() {
        return isAward;
    }

    public void setAward(boolean award) {
        isAward = award;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
