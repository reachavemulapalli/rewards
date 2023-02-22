package com.americanunit.rewards.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RewardCalculatorTest {
    RewardCalculator rewardCalculator = new RewardCalculator();

    @Test
    public void calculateRewardsTest()
    {
        //Amount < 50
        double rewards = rewardCalculator.rewardCal(49.0);
        Assertions.assertTrue(rewards == 0.0);
        //Amount 0
        rewards = rewardCalculator.rewardCal(0.0);
        Assertions.assertTrue(rewards == 0.0);
        //Amount < 100 but >50
        rewards = rewardCalculator.rewardCal(75.00);
        Assertions.assertTrue(rewards == 25.00);
        //Amount = 100
        rewards = rewardCalculator.rewardCal(100.00);
        Assertions.assertTrue(rewards == 50.00);
        //Amount > 100
        rewards = rewardCalculator.rewardCal(120.00);
        Assertions.assertTrue(rewards == 90.00);
    }
}
