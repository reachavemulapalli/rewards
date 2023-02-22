package com.americanunit.rewards.dao;

import com.americanunit.rewards.dao.entity.CustomerEntity;
import com.americanunit.rewards.model.Customer;
import com.americanunit.rewards.model.CustomerRewardsResponse;

import java.util.List;

public interface CustomerDao {
    public CustomerEntity addCustomer(Customer cust);
    public void addCustomers(List<Customer> customers);
    public void removeCustomer(Customer cust);
    public List<CustomerRewardsResponse> getAllCustomerRewards();

}
