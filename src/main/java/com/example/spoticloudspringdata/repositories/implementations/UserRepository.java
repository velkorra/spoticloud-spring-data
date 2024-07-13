package com.example.spoticloudspringdata.repositories.implementations;

import com.example.spoticloudspringdata.entities.User;
import com.example.spoticloudspringdata.repositories.UserJpaRepository;
import com.example.spoticloudspringdata.repositories.base.classes.AbstractBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository extends AbstractBaseRepository<User, Integer> {
    public UserRepository(JpaRepository<User, Integer> repository) {
        super(repository);
    }

    public void delete(User user) {
        user.setDeleted(true);
    }
    public void deleteById(Integer id) {
        repository.findById(id).ifPresent(user -> user.setDeleted(true));
    }

    public User findByUsername(String username){
        return ((UserJpaRepository) repository).findByUsername(username);
    }
    public User findByEmail(String email){
        return ((UserJpaRepository) repository).findByEmail(email);
    }
}
