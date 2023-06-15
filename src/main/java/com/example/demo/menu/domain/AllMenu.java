package com.example.demo.menu.domain;

public interface AllMenu {

  Menu findById(Long id);

  Menu findByIdWithPessimisticLock(Long menuId);

  Menu save(Menu menu);

}
