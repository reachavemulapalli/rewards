package com.americanunit.rewards.controler;

import com.americanunit.rewards.model.CustomerRewardsResponse;
import com.americanunit.rewards.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rewards")
public class RewardControler {

    @Autowired
    private RewardService rewardService;

    @GetMapping
    public List<CustomerRewardsResponse> getCustomerRewards() {
        return rewardService.getAllCustomersRewards();
    }



}
