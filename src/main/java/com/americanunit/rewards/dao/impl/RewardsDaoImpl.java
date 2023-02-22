package com.americanunit.rewards.dao.impl;

import com.americanunit.rewards.dao.RewardsDao;
import com.americanunit.rewards.dao.repository.RewardsRepository;
import com.americanunit.rewards.model.CustomerRewardsResponse;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RewardsDaoImpl implements RewardsDao {
    private RewardsRepository rewardsRepository;
    @Override
    public List<CustomerRewardsResponse> getAllCustomersRewards() {
        return null;
    }
}
