package com.americanunit.rewards.dao.repository;

import com.americanunit.rewards.dao.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    Optional<CustomerEntity> findByEmailId(String emailId);

}
