package com.example.demo.user.domain;


public interface AllUser {
  User findById(Long id);

  void save(User user);

  boolean existsByUserId(UserId userId);

  User findByIdWithPessimisticLock(Long userId);
}
