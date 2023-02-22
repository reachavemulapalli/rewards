package com.americanunit.rewards.dao;

import com.americanunit.rewards.dao.entity.CustomerEntity;
import com.americanunit.rewards.model.Customer;
import com.americanunit.rewards.model.CustomerRewardsResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-21T20:03:34-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class CustomerDaoMapperImpl implements CustomerDaoMapper {

    @Override
    public CustomerRewardsResponse mapFromCustomer(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        CustomerRewardsResponse.CustomerRewardsResponseBuilder customerRewardsResponse = CustomerRewardsResponse.builder();

        customerRewardsResponse.firstName( customerEntity.getFirstName() );
        customerRewardsResponse.lastName( customerEntity.getLastName() );
        customerRewardsResponse.emailId( customerEntity.getEmailId() );
        customerRewardsResponse.rewards( calculateRewardsByMonth( customerEntity.getRewards() ) );
        customerRewardsResponse.totalRewards( calculateTotalRewards( customerEntity.getRewards() ) );

        return customerRewardsResponse.build();
    }

    @Override
    public CustomerEntity mapFromCustomerRequest(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setFirstName( customer.getFirstName() );
        customerEntity.setLastName( customer.getLastName() );
        customerEntity.setEmailId( customer.getEmailId() );
        customerEntity.setCustomer_id( customer.getCustomer_id() );
        customerEntity.setTransactions( calculateRewards( customer.getTransactionList() ) );

        return customerEntity;
    }
}
