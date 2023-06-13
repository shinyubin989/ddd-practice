package com.example.demo.user.application;

import com.sun.istack.NotNull;

public record SignUpRequest(
  @NotNull
  String userId,
  @NotNull
  String password,
  @NotNull
  String name
) {
}
