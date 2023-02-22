package com.americanunit.rewards.dao;

import com.americanunit.rewards.dao.entity.CustomerEntity;
import com.americanunit.rewards.dao.entity.Rewards;
import com.americanunit.rewards.dao.entity.Transaction;
import com.americanunit.rewards.model.CustomerRewardsResponse;
import com.americanunit.rewards.model.CustomerTransaction;
import com.americanunit.rewards.model.RewardsByMonth;
import com.americanunit.rewards.util.RewardCalculator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import java.util.*;

@Mapper
public interface CustomerDaoMapper {

    CustomerDaoMapper INSTANCE = Mappers.getMapper(CustomerDaoMapper.class);

    @Mapping(source = "firstName" , target = "firstName" )
    @Mapping(source = "lastName" , target = "lastName" )
    @Mapping(source = "emailId" , target = "emailId" )
    @Mapping(source = "rewards" , target = "rewards", qualifiedByName = "calculateRewardsByMonth")
    @Mapping(source = "rewards" , target = "totalRewards", qualifiedByName = "calculateTotalRewards")

    CustomerRewardsResponse mapFromCustomer(CustomerEntity customerEntity);


    @Mapping(source = "firstName" , target = "firstName" )
    @Mapping(source = "lastName" , target = "lastName" )
    @Mapping(source = "emailId" , target = "emailId" )
    @Mapping(source = "customer_id" , target = "customer_id" )
    @Mapping(source = "transactionList" , target = "transactions", qualifiedByName = "calculateRewards")
    CustomerEntity mapFromCustomerRequest(com.americanunit.rewards.model.Customer customer);
     @Named("calculateRewardsByMonth")
     default List<RewardsByMonth> calculateRewardsByMonth(List<Rewards> rewardsSet) {
         List<RewardsByMonth> rewardsByMonths = new ArrayList<>(rewardsSet.size());
         Map<Integer, RewardsByMonth> rewardsMap = new HashMap<>();
         for (Rewards reward : rewardsSet) {
             if (rewardsMap.get(reward.getTimestamp().getMonth()) != null) {
                 rewardsMap.get(reward.getTimestamp().getMonth()).setRewards(rewardsMap.get(reward.getTimestamp().getMonth()).getRewards() + reward.getReward());
             } else {
                 rewardsMap.put(reward.getTimestamp().getMonth(), RewardsByMonth.builder().month(reward.getTimestamp().getMonth()).rewards(reward.getReward()).build());
             }
         }
         return rewardsMap.values().stream().toList();
     }

    @Named("calculateTotalRewards")
    default Double calculateTotalRewards(List<Rewards> rewardsSet) {
        List<RewardsByMonth> rewardsByMonths = new ArrayList<>(rewardsSet.size());
        Double total = 0.0;
        for (Rewards reward : rewardsSet) {

            total= total+reward.getReward();
        }
        return total;
    }
    @Named("calculateRewards")
    default  List<Transaction> calculateRewards(List<CustomerTransaction> transactionList)
    {
        List<Transaction> transactions = new ArrayList<>();
        for (CustomerTransaction transaction: transactionList) {
            Transaction tran = new Transaction();
            tran.setTransaction_id(transaction.getTransaction_id());
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
