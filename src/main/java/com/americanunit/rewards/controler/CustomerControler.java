package com.americanunit.rewards.controler;

import com.americanunit.rewards.model.Customer;
import com.americanunit.rewards.service.CustomerService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/customers")
@Setter
@Slf4j
public class CustomerControler {

    @Autowired
    private CustomerService customerService;

    /**
     * Add the list of customers provided along with the transaction details to the DB
     * @param customers
     * @return
     */
    @PostMapping
    public ResponseEntity<String> addCustomers(@RequestBody Set<Customer> customers) {
        try {
            List<Customer> customerList = customers.stream().toList();
            if(customerList.isEmpty())
                return ResponseEntity.noContent().build();
            customerService.addAllCustomers(customerList);
            return ResponseEntity.ok("Added All customers");
        }catch (Exception e)
        {
            log.error("Exception occured while fetching the customer data", e);
            return ResponseEntity.internalServerError().build();
        }

    }

}
