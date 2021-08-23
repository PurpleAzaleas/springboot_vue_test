package com.example.dao;

public interface BaseFDao<T,K> {
    void insert(T t);
    T selectOne(K k);
}
