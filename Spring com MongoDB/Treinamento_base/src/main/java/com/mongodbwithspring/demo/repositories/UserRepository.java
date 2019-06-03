package com.mongodbwithspring.demo.repositories;

import com.mongodbwithspring.demo.domain.user.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Author, String> {
}
