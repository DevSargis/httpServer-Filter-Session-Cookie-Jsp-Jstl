package com.onlinsestore.servletsonlinestore.Dao;

import java.util.List;
import java.util.Optional;

public interface Dao<K, T> {
    List<T> findAll();
    Optional<T> findById(K id);
    T save(T entity);
    boolean delete (K id);
    void update(T entity);
}
