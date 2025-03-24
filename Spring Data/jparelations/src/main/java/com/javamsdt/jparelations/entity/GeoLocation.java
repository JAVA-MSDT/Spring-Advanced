package com.javamsdt.jparelations.entity;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "geo_location")
@Data
@EqualsAndHashCode(exclude = {"addresses"})
public class GeoLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "geo_id")
    private long geoId;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @OneToMany(mappedBy = "geoLocation", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Address> addresses;

}
