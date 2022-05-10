package com.javamsdt.jparelations.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @OneToOne()
    @JoinColumn(name = "job_id", referencedColumnName = "job_id")
    private Job job;

    @ManyToMany
    @JoinTable(name = "user_address",
            joinColumns = { @JoinColumn(name = "user_user_id", referencedColumnName = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_address_id", referencedColumnName = "address_id") })
    private Set<Address> address;

}
