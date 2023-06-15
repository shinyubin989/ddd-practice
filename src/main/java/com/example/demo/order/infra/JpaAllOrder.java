package com.example.demo.order.infra;

import com.example.demo.order.domain.AllOrder;
import com.example.demo.order.domain.Order;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaAllOrder implements AllOrder {

  private final JpaAllOrderPersistence jpaAllOrderPersistence;

  @Override
  public Order save(Order order) {
    return jpaAllOrderPersistence.save(order);
  }
}
