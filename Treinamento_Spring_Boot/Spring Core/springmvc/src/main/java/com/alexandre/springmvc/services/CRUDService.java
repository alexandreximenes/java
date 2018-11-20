package com.alexandre.springmvc.services;

import java.util.List;

public interface CRUDService<T> {
    List<T> listaAllProducts();

    T getById(Integer id);

    T saveOrUpdate(T t);

    boolean delete(Integer id);
}
