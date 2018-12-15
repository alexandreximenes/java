package com.jpaadvanced.start.service;

import java.util.List;

public interface CourseService<T> {
    T saveOrUpdate(T t);
    T findById(Long id);
    void remove(Long id);
    List<T> findAll();
}
