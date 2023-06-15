package com.example.demo.order.infra;

import com.example.demo.order.application.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;

@RequiredArgsConstructor
public class JpaOrderDao implements OrderDao {

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
//  @Query(
//    """
//
//    """
//  )
//  void saveOrder()
}
