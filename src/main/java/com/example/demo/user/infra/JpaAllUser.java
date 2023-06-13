package com.example.demo.user.infra;

import com.example.demo.user.domain.AllUser;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaAllUser implements AllUser {

  private final JpaAllUserPersistence jpaAllUserPersistence;

  @Override
  public User findById(Long id) {
    return jpaAllUserPersistence.findById(id).orElseThrow(NoSuchUserException::new);
  }

  @Override
  public void save(User user) {
    jpaAllUserPersistence.save(user);
  }

  @Override
  public boolean existsByUserId(UserId userId) {
    return jpaAllUserPersistence.existsByUserId(userId);
  }
}
