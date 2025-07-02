package com.devthakur.UserBankApp.repository;

import com.devthakur.UserBankApp.entity.CreateAccount;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CreateAccountRepo extends MongoRepository<CreateAccount, ObjectId> {

    @Query("{ 'accountNumber' : ?0 }")
    CreateAccount findByAccountNumber(long accountNumber);

}
