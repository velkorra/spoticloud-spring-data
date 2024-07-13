package com.example.spoticloudspringdata.repositories.base.interfaces;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, Id> {
    T save(T entity);
    T findById(Id id);
    List<T> findAll();

}
