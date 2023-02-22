package com.americanunit.rewards.service.impl;


import com.americanunit.rewards.dao.CustomerDao;
import com.americanunit.rewards.model.CustomerRewardsResponse;
import com.americanunit.rewards.service.RewardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RewardsServiceImpl implements RewardService {

    private final CustomerDao customerDao;
    @Override
    public List<CustomerRewardsResponse> getAllCustomersRewards() {
        List<CustomerRewardsResponse> customerRewardsResponses = customerDao.getAllCustomerRewards();
        log.info("Customer Reward Responses size {}", customerRewardsResponses.size());
        return customerRewardsResponses;
    }
}
