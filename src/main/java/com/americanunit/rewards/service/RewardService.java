package com.americanunit.rewards.service;

import com.americanunit.rewards.model.CustomerRewardsResponse;

import java.util.List;

public interface RewardService {
    public List<CustomerRewardsResponse> getAllCustomersRewards();
}
