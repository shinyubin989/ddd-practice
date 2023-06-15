package com.example.demo.menu.infra;

import com.example.demo.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface JpaAllMenuPersistence extends JpaRepository<Menu, Long> {

  @Lock(value = LockModeType.PESSIMISTIC_WRITE)
  @Query(
    "SELECT m FROM Menu m WHERE m.id = :menuId"
  )
  Optional<Menu> findByIdWithPessimisticLock(Long menuId);
}
