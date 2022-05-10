package com.javamsdt.jparelations.entity;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "geo_location")
@Data
public class GeoLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "geo_id")
    private long geoId;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @OneToMany(mappedBy = "geoLocation")
    private List<Address> addresses;

}
