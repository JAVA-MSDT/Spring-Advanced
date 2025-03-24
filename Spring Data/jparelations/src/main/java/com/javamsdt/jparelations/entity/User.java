package com.javamsdt.jparelations.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(exclude = {"job", "addresses"})
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_address",
            joinColumns = { @JoinColumn(name = "user_user_id", referencedColumnName = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_address_id", referencedColumnName = "address_id") })
    private Set<Address> addresses;

}
