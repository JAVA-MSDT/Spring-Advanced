package com.javamsdt.jparelations;

import com.javamsdt.jparelations.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class JpaRelationsApplication implements ApplicationRunner {

	private final JobRepository jobRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaRelationsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("===================== JOB ENTITY =====================");
		jobRepository.findAll().forEach(System.out::println);
		System.out.println("===================== JOB ENTITY (USER) =====================");
		jobRepository.findAll().forEach(job -> System.out.println(job.getUser()));
	}
}
