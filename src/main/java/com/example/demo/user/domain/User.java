package com.example.demo.user.domain;

import com.example.demo.common.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

  @Embedded
  private UserId userId;

  private String name;

  @Embedded
  private Password password;

  @Embedded
  private Money money;

  @Builder
  public User(UserId userId, Password password, String name, Money money) {
    this.userId = userId;
    this.password = password;
    this.name = name;
    this.money = money;
  }
}
