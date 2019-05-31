package com.mongodbwithspring.demo.repositories;

import com.mongodbwithspring.demo.domain.post.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
