package com.example.demo.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Money {

  private int value;

  public Money(int value){this.value = value;}

  public void decrease(int quantity, int price) {
    this.value -= quantity * price;
  }

}
