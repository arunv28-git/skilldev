package com.example.demo.repository;

import com.example.demo.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {
    // You can define custom query methods here if needed
}
