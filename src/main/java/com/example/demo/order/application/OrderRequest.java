package com.example.demo.order.application;

public record OrderRequest(
  long menuId,
  long userId,
  int quantity
  ) {
}
