package com.example.demo.dao;

import java.util.List;

public interface GenericDAO<ID extends Number,K> {

    void add(K k);

    K findById(ID id);

    K update(K k);

    void deleteById(ID id);

    List<K> getAll();

}
