package com.reddict.reddictClone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reddict.reddictClone.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//	Optional<VerificationToken> findByUsername(String username);
    Optional<User> findByUsername(String username);
}