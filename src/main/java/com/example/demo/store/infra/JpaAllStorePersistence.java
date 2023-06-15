package com.example.demo.store.infra;

import com.example.demo.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface JpaAllStorePersistence extends JpaRepository<Store, Long> {

  @Lock(value = LockModeType.PESSIMISTIC_WRITE)
  @Query(
    "SELECT s FROM Store s WHERE s.id = :storeId"
  )
  Optional<Store> findByIdWithPessimisticLock(Long storeId);
}
