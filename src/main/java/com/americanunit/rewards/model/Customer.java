package com.americanunit.rewards.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Getter
@Setter
@Jacksonized
public class Customer {

    @JsonProperty("customer_id")
    private Integer customer_id;
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("emailId")
    private String emailId;

    @JsonProperty("transactionList")
    private List<CustomerTransaction> transactionList;
}
