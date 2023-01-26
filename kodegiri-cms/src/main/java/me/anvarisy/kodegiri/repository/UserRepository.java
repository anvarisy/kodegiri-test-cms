package me.anvarisy.kodegiri.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import me.anvarisy.kodegiri.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUserName(String username);
}
