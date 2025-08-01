package com.example.springbootfirst.repository;

import com.example.springbootfirst.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegisterRepository extends JpaRepository<RegisterDetails, Integer> {
    Optional<RegisterDetails> findByUserName(String userName);
    List<RegisterDetails> findByUserNameContainingIgnoreCase(String userName);

}
