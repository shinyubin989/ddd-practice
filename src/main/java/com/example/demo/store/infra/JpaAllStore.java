package com.example.demo.store.infra;

import com.example.demo.store.domain.AllStore;
import com.example.demo.store.domain.Store;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaAllStore implements AllStore {

  private final JpaAllStorePersistence jpaAllStorePersistence;

  @Override
  public Store findById(Long storeId) {
    return jpaAllStorePersistence.findById(storeId).orElseThrow(NoSuchStoreException::new);
  }

  @Override
  public Store findByIdWithPessimisticLock(Long storeId) {
    return jpaAllStorePersistence.findByIdWithPessimisticLock(storeId).orElseThrow(NoSuchStoreException::new);
  }
}
