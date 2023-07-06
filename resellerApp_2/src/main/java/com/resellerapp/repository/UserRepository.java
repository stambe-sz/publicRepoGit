package com.resellerapp.repository;

import com.resellerapp.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
    Optional<User> findByUsernameAndPassword(String username, String password);
}
