package com.americanunit.rewards.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
public class CustomerTransaction {

    private Integer transaction_id;
    private Integer customer_id;
    private double amount;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date timeStamp;
}
