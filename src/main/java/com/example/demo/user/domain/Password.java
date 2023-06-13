package com.example.demo.user.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {

  @Column(name = "password")
  private String password;

  public Password(String password) {
    validate(password);
    this.password = password;
  }

  public boolean match(String pwd){
    return this.password.equals(pwd);
  }

  private void validate(String password){
    Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{6,20}$");
    Matcher matcher = pattern.matcher(password);
    if(!matcher.find()) throw new InvalidPasswordException();
  }
}
