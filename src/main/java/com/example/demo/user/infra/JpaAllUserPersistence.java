package com.example.demo.user.infra;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface JpaAllUserPersistence extends JpaRepository<User, Long> {

  boolean existsByUserId(UserId userId);

  @Lock(value = LockModeType.PESSIMISTIC_WRITE)
  @Query(
    "SELECT u FROM User u WHERE u.id = :userId"
  )
  Optional<User> findByIdWithPessimisticLock(Long userId);
}
