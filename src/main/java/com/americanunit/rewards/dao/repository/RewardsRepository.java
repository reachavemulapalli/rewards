package com.americanunit.rewards.dao.repository;

import com.americanunit.rewards.dao.entity.CustomerEntity;
import com.americanunit.rewards.dao.entity.Rewards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RewardsRepository extends JpaRepository<Rewards,Integer> {

    // Optional<CustomerEntity> findByCustomer(String customerId);

}
