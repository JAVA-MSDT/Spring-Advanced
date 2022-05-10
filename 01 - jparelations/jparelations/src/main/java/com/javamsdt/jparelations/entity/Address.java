package com.javamsdt.jparelations.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long addressId;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "room_number")
    private int roomNumber;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "geo_location_id")
    private GeoLocation geoLocation;

    @ManyToMany
    @JoinTable(name = "user_address",
            joinColumns = { @JoinColumn(name = "user_address_id", referencedColumnName = "address_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_user_id", referencedColumnName = "user_id") })
    private Set<User> users;
}
