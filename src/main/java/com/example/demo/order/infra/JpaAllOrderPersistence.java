package com.example.demo.order.infra;

import com.example.demo.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAllOrderPersistence extends JpaRepository<Order, Long> {
}
