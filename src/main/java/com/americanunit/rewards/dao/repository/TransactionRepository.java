package com.americanunit.rewards.dao.repository;

import com.americanunit.rewards.dao.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
