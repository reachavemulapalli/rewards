package com.americanunit.rewards.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Getter
@Setter
@Builder
@Jacksonized
public class CustomerRewardsResponse {
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("emailId")
    private String emailId;
    @JsonProperty("totalRewards")
    private Double totalRewards;

    @JsonProperty("rewards")
    private List<RewardsByMonth> rewards;
}
