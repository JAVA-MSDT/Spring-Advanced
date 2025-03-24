package com.javamsdt.jparelations.controller;

import java.util.List;

import com.javamsdt.jparelations.entity.Job;
import com.javamsdt.jparelations.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/job")
@AllArgsConstructor
public class JobController {

    private final JobRepository jobRepository;


    @GetMapping()
    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

}
