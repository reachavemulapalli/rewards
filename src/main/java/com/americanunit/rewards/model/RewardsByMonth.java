package com.americanunit.rewards.model;

import lombok.*;

@Data
@Builder
@Getter
@Setter
public class RewardsByMonth {
    private int month;
    private Double rewards;

}
