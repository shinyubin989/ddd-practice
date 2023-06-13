package com.example.demo.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserId {

  @Column(name = "user_id")
  private String userId;

  public UserId(String userId){
    validate(userId);
    this.userId = userId;
  }

  private void validate(String id){
    Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{6,20}$");
    Matcher matcher = pattern.matcher(id);
    if(!matcher.find()) throw new InvalidPasswordException();
  }

  /**
   * db에 동일한 userId가 존재하는지 체크하는건 UserId 클래스의 역할이 아니라고 생각해 Service영역에서 처리함
   */



}
