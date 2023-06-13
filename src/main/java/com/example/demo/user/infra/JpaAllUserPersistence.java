package com.example.demo.user.infra;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAllUserPersistence extends JpaRepository<User, Long> {

  boolean existsByUserId(UserId userId);
}
