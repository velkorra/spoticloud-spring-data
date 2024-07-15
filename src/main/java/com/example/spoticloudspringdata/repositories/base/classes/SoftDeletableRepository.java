package com.example.spoticloudspringdata.repositories.base.classes;

import com.example.spoticloudspringdata.entities.SoftDeletable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class SoftDeletableRepository<T extends SoftDeletable, Id>  extends AbstractBaseRepository<T, Id> {
    public SoftDeletableRepository(JpaRepository<T, Id> repository) {
        super(repository);
    }

    @Override
    public Optional<T> findById(Id id) {
        return repository.findById(id).filter(e -> !e.isDeleted());
    }

    @Override
    public List<T> findAll() {
        return repository.findAll().stream().filter(e -> !e.isDeleted()).toList();
    }
}
