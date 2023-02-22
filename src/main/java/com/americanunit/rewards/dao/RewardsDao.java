package com.americanunit.rewards.dao;

import com.americanunit.rewards.model.CustomerRewardsResponse;

import java.util.List;

public interface RewardsDao {
    public List<CustomerRewardsResponse> getAllCustomersRewards();
}
