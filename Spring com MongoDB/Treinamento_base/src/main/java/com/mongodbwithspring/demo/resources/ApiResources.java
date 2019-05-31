package com.mongodbwithspring.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ApiResources {

    default ResponseEntity<Object> findAll() {
        return null;
    }
    default ResponseEntity<Object> findById(String id) {
        return null;
    }
    default ResponseEntity<Object> save(Object o) {
        return null;
    }
    default ResponseEntity<Object> update(String id, Object o) {
        return null;
    }default ResponseEntity<Object> deleteById(String id) {
        return null;
    }

}
