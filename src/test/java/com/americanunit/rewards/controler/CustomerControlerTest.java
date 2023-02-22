package com.americanunit.rewards.controler;

import com.americanunit.rewards.model.Customer;
import com.americanunit.rewards.model.CustomerTransaction;
import com.americanunit.rewards.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class CustomerControlerTest {
    CustomerControler customerControler;

    @Mock
    CustomerService customerService;

    @BeforeEach
    public void setup()
    {
        customerControler = new CustomerControler();
        customerControler.setCustomerService(customerService);
    }

    @Test
    public void addAllCustomerTest()
    {
       ResponseEntity<String> responseEntity =  customerControler.addCustomers(new HashSet<>());
       Assertions.assertTrue(responseEntity.getStatusCode() == HttpStatusCode.valueOf(204));
        responseEntity =  customerControler.addCustomers(makeNewCustomers());
        Assertions.assertTrue(responseEntity.getStatusCode() == HttpStatusCode.valueOf(200));
        Mockito.doThrow(new RuntimeException("Test Exception")).when(customerService).addAllCustomers(Mockito.anyList());
        responseEntity =  customerControler.addCustomers(makeNewCustomers());
        Assertions.assertTrue(responseEntity.getStatusCode() == HttpStatusCode.valueOf(500));

    }

    private Set<Customer> makeNewCustomers()
    {
        Set<Customer> customers = new HashSet<>();
        customers.add(Customer.builder().customer_id(1).emailId("xyz@gmail.com").firstName("Joe").lastName("Miller")
                .transactionList(makeTransactionList()).build());
        customers.add(Customer.builder().customer_id(2).emailId("abc@gmail.com").firstName("Jack").lastName("Doe")
                .transactionList(makeTransactionList()).build());
        return customers;
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

}
