package com.americanunit.rewards.dao.impl;

import com.americanunit.rewards.dao.CustomerDao;
import com.americanunit.rewards.dao.CustomerDaoMapper;
import com.americanunit.rewards.dao.entity.CustomerEntity;
import com.americanunit.rewards.dao.entity.Rewards;
import com.americanunit.rewards.dao.entity.Transaction;
import com.americanunit.rewards.dao.repository.CustomerRepository;
import com.americanunit.rewards.model.Customer;
import com.americanunit.rewards.model.CustomerRewardsResponse;
import com.americanunit.rewards.model.CustomerTransaction;
import com.americanunit.rewards.util.RewardCalculator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerDaoImpl implements CustomerDao {

   private final CustomerRepository customerRepository;

    @Override
    public CustomerEntity addCustomer(Customer cust) {


        CustomerEntity entity = CustomerDaoMapper.INSTANCE.mapFromCustomerRequest(cust);
        return customerRepository.saveAndFlush(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addCustomers(List<Customer> customers) {

        for (Customer cust:customers) {
            CustomerEntity entity = CustomerDaoMapper.INSTANCE.mapFromCustomerRequest(cust);
            for (Transaction tran:entity.getTransactions()
            ) {
                tran.getRewards().setCustomer(entity);
                tran.setCustomer(entity);
            }

            customerRepository.saveAndFlush(entity);
        }

    }

    @Override
    public void removeCustomer(Customer cust) {

    }

    @Override
    public List<CustomerRewardsResponse> getAllCustomerRewards() {

       List<CustomerEntity> listOfCustomer = customerRepository.findAll();

       List<CustomerRewardsResponse> customerRewards = new ArrayList<>(listOfCustomer.size());

        for (CustomerEntity cust:listOfCustomer) {
            log.info("Size of the rewards"+ cust.getRewards().size());
          customerRewards.add(CustomerDaoMapper.INSTANCE.mapFromCustomer(cust));

        }
        return customerRewards;
    }

    private List<Transaction> calculateRewards(List<CustomerTransaction> transactionList)
    {
        List<Transaction> transactions = new ArrayList<>();
        for (CustomerTransaction transaction: transactionList) {
            Transaction tran = new Transaction();
            tran.setAmount(transaction.getAmount());
            tran.setTimestamp(transaction.getTimeStamp());
            Rewards reward = new Rewards();
            reward.setTimestamp(transaction.getTimeStamp());
            reward.setReward(new RewardCalculator().rewardCal(transaction.getAmount()));
            tran.setRewards(reward);
            transactions.add(tran);
        }
        return transactions;
    }
}
