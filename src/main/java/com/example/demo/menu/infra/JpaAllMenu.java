package com.example.demo.menu.infra;

import com.example.demo.menu.domain.AllMenu;
import com.example.demo.menu.domain.Menu;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaAllMenu implements AllMenu {

  private final JpaAllMenuPersistence jpaAllMenuPersistence;

  @Override
  public Menu findById(Long id) {
    return jpaAllMenuPersistence.findById(id).orElseThrow(NoSuchMenuException::new);
  }

  @Override
  public Menu findByIdWithPessimisticLock(Long menuId) {
    return jpaAllMenuPersistence.findByIdWithPessimisticLock(menuId).orElseThrow(NoSuchMenuException::new);
  }

  @Override
  public Menu save(Menu menu) {
    return jpaAllMenuPersistence.save(menu);
  }
}
