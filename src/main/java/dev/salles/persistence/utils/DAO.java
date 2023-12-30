package dev.salles.persistence.utils;

import java.util.List;
import java.util.Optional;

public interface DAO<T, K> {
    void insert(T entity);
    void update(T entity);
    void delete(K key);
    Optional<T> select(K key);
    List<T> selectAll();
}
