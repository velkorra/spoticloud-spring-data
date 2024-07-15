package com.example.spoticloudspringdata.repositories.implementations;

import com.example.spoticloudspringdata.entities.User;
import com.example.spoticloudspringdata.repositories.base.classes.AbstractBaseRepository;
import com.example.spoticloudspringdata.repositories.base.classes.SoftDeletableRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public class UserRepository extends SoftDeletableRepository<User, Integer> {
    private final UserJpaRepository repository;
    public UserRepository(JpaRepository<User, Integer> repository) {
        super(repository);
        this.repository = (UserJpaRepository) repository;
    }

    public Set<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}

@Repository
interface UserJpaRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    @Query("select u from User u where u.deleted = false and u.username = :username")
    Set<User> findByUsername(String username);

    @Query("select u from User u where u.deleted = false and u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("select u.email from User u")
    Set<String> findAllEmails();


}