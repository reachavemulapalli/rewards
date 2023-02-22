package com.americanunit.rewards.dao.impl;

import com.americanunit.rewards.dao.entity.CustomerEntity;
import com.americanunit.rewards.dao.repository.CustomerRepository;
import com.americanunit.rewards.model.Customer;
import com.americanunit.rewards.model.CustomerRewardsResponse;
import com.americanunit.rewards.model.CustomerTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerDaoImplTest {

    @Mock
    CustomerRepository customerRepository;


    CustomerDaoImpl customerDao ;

    @BeforeEach
    public void setup()
    {
        customerDao = new CustomerDaoImpl(customerRepository);
    }

    @Test
    public void addCustomerTest()
    {
         customerDao.addCustomer(makeNewCustomer());
         Mockito.verify(customerRepository, Mockito.times(1)).saveAndFlush(Mockito.any());

    }


    @Test
    public void addAllCustomerTest()
    {
        customerDao.addCustomers(makeNewCustomers());
        Mockito.verify(customerRepository, Mockito.times(2)).saveAndFlush(Mockito.any());

    }

    @Test
    public void getAllCustomerRewards()
    {
        Mockito.when(customerRepository.findAll()).thenReturn(makeNewCustomerEntity());
        List<CustomerRewardsResponse>  rewardsResponse = customerDao.getAllCustomerRewards();
        Assertions.assertTrue(rewardsResponse.size() == 2);

    }

    private Customer makeNewCustomer()
    {
        return  Customer.builder().customer_id(1).emailId("xyz@gmail.com").firstName("Joe").lastName("Miller")
                .transactionList(makeTransactionList()).build();
    }

    private List<Customer> makeNewCustomers()
    {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(Customer.builder().customer_id(1).emailId("xyz@gmail.com").firstName("Joe").lastName("Miller")
                .transactionList(makeTransactionList()).build());
        customerList.add(Customer.builder().customer_id(2).emailId("abc@gmail.com").firstName("Jack").lastName("Doe")
                .transactionList(makeTransactionList()).build());
        return customerList;
    }

    private List<CustomerTransaction> makeTransactionList()
    {
        List<CustomerTransaction> customerTransactionList = new ArrayList<>();
        customerTransactionList.add(CustomerTransaction.builder().transaction_id(1).customer_id(1).amount(25.00).build());
        customerTransactionList.add(CustomerTransaction.builder().transaction_id(2).customer_id(1).amount(50.00).build());
        customerTransactionList.add(CustomerTransaction.builder().transaction_id(3).customer_id(1).amount(75.00).build());
        customerTransactionList.add(CustomerTransaction.builder().transaction_id(4).customer_id(1).amount(25.00).build());

        return customerTransactionList;

    }

    private List<CustomerEntity> makeNewCustomerEntity()
    {
        List<CustomerEntity> customerEntities = new ArrayList<>();
        CustomerEntity customer = new CustomerEntity();
        customer.setRewards(new ArrayList<>());
        customer.setTransactions(new ArrayList<>());
        customer.setCustomer_id(1);
        customer.setEmailId("xyz@gmail.com");
        customer.setLastName("Joe");
        customer.setFirstName("Miller");
        customerEntities.add(customer);

        CustomerEntity customer1 = new CustomerEntity();
        customer1.setRewards(new ArrayList<>());
        customer1.setTransactions(new ArrayList<>());
        customer1.setCustomer_id(2);
        customer1.setEmailId("abc@gmail.com");
        customer1.setLastName("Jack");
        customer1.setFirstName("Doe");
        customerEntities.add(customer1);
        return customerEntities;
    }
}
