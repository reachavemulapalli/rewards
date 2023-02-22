package com.americanunit.rewards.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


/*
Util class to calculate the  rewards based on the transaction amount
 */
@Component
@Getter
@Setter
@NoArgsConstructor
public class RewardCalculator {
    private Double minAmountForFirstReward = 50.00;
    private Double maxAmountForFirstReward = 100.00;
    private Double  firstRewardValue = 1.00;

    private Double secondRewardValue = 2.00;

public double rewardCal(double tranAmount){
    double rewards = 0.0;
    if(tranAmount<= minAmountForFirstReward){
        return rewards;
    }
    if(tranAmount>minAmountForFirstReward && tranAmount<=maxAmountForFirstReward){
        rewards=(tranAmount-minAmountForFirstReward)*firstRewardValue;
    }else {
        rewards = (maxAmountForFirstReward-minAmountForFirstReward)*firstRewardValue+(tranAmount-maxAmountForFirstReward)*secondRewardValue;
    }
return rewards;
}

}
