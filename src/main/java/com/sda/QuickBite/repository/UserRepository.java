package com.sda.QuickBite.repository;

import com.sda.QuickBite.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    Optional<User> findByEmail(String email);


    Optional<User> findByUserId(Long userId);
}
