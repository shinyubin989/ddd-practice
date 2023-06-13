package com.example.demo.user.ui;

import com.example.demo.common.response.DefaultResponseDto;
import com.example.demo.user.application.SignUpRequest;
import com.example.demo.user.application.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/signup")
@RequiredArgsConstructor
public class SignupController {

  private final SignupService signupService;

  @PostMapping("")
  public DefaultResponseDto signUp(SignUpRequest signUpRequest) {
    signupService.signUp(signUpRequest);
    return new DefaultResponseDto(true, "회원가입 완료");
  }
}
