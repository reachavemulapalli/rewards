package com.americanunit.rewards.service.impl;

import com.americanunit.rewards.dao.CustomerDao;
import com.americanunit.rewards.model.Customer;
import com.americanunit.rewards.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Override
    public void addAllCustomers(List<Customer> customers) {
        customerDao.addCustomers(customers);
    }
}
