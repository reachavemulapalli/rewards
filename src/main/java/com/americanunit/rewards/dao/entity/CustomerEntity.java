package com.americanunit.rewards.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "_customer")
public class CustomerEntity {
    @Id
    @JsonProperty("customer_id")
    @Column(name = "customer_id")
    private Integer customer_id;

    @JsonProperty("firstName")
    @Column(name = "firstName")
    private String firstName;
    @JsonProperty("lastName")
    @Column(name = "lastName")
    private String lastName;
    @JsonProperty("emailId")
    @Column(name = "emailId")
    private String emailId;

    @JsonProperty("transactions")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "customer")
    private List<Transaction> transactions;

    @JsonProperty("rewards")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true,  mappedBy = "customer")
    private List<Rewards> rewards;


}
