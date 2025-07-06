package com.example.expensetracker.repository;

import com.example.expensetracker.model.expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenceRepository extends MongoRepository<expense, String> {

}
