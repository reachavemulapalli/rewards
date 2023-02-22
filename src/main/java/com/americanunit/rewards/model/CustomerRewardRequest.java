package com.americanunit.rewards.model;

import lombok.*;

import java.util.Date;

@Data
@Builder
@Setter
@Getter
public class CustomerRewardRequest {
    private String emailId;
    private Date startDate;
    private Date EndDate;

}
