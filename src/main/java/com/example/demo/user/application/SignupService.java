package com.example.demo.user.application;

import com.example.demo.user.domain.Money;
import com.example.demo.user.domain.Password;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserId;
import com.example.demo.user.infra.JpaAllUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignupService {

  private final JpaAllUser jpaAllUser;

  @Transactional
  public void signUp(SignUpRequest signUpRequest){
    UserId userId = new UserId(signUpRequest.userId());
    if(jpaAllUser.existsByUserId(userId)) throw new DuplicatedUserIdException();
    Password password = new Password(signUpRequest.password());
    Money money = new Money(0);
    jpaAllUser.save(new User(userId, password, signUpRequest.name(), money));
  }
}
