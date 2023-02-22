package com.americanunit.rewards.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "_transaction")
public class Transaction {
    @Id
    private Integer transaction_id;
    private double amount;
    private Date timestamp;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @JsonProperty("rewards")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true,  mappedBy = "transaction")
    private Rewards rewards;

}
