package com.example.demo.store.domain;

public interface AllStore {

  Store findById(Long storeId);

  Store findByIdWithPessimisticLock(Long storeId);
}
