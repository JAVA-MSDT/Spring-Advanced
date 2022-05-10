package com.javamsdt.jparelations.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "job")
@Data
@EqualsAndHashCode(exclude = "user")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private long jobId;

    @Column(name = "title")
    private String title;

    @Column(name = "salary")
    private double salary;

    @OneToOne(mappedBy = "job")
    @ToString.Exclude
    private User user;

}
