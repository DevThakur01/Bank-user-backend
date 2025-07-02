package com.devthakur.UserBankApp.repository;

import com.devthakur.UserBankApp.entity.CreateAccount;
import com.devthakur.UserBankApp.entity.TransactionHistory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionHistoryRepo extends MongoRepository<TransactionHistory,ObjectId> {
    List<TransactionHistory> findByIdIn(List<ObjectId> ids);

}
