package com.rest.servicedb.repository;

import com.rest.dto.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Subscription, Long> {

}
