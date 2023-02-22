package com.americanunit.rewards.dao.entity;
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
@Table(name = "_rewards")
public class Rewards {

    @Id
    @GeneratedValue
    private Integer id;
    private double reward;
    private Date timestamp;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;
}
