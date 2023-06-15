package com.example.demo.user.domain;

import com.example.demo.common.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
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

  public boolean hasEnoughMoneyToOrderMenu(int quantity, int price) {
    return money.getValue() > quantity * price;
  }

  public void decreaseMoney(int quantity, int price) {
    this.money.decrease(quantity, price);
  }
}
