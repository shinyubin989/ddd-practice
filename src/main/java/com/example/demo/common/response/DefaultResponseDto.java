package com.example.demo.common.response;

public record DefaultResponseDto(
  boolean success,
  String message
) {
}