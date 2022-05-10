package com.javamsdt.jparelations.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "job")
@Data
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
    private User user;

}
