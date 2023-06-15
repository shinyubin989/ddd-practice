package com.example.demo.order.application;

import com.example.demo.menu.domain.Menu;
import com.example.demo.menu.infra.JpaAllMenu;
import com.example.demo.order.domain.Order;
import com.example.demo.order.infra.JpaAllOrder;
import com.example.demo.store.domain.Store;
import com.example.demo.store.infra.JpaAllStore;
import com.example.demo.user.domain.User;
import com.example.demo.user.infra.JpaAllUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final JpaAllOrder jpaAllOrder;
  private final JpaAllUser jpaAllUser;
  private final JpaAllStore jpaAllStore;
  private final JpaAllMenu jpaAllMenu;

  @Transactional
  public void order(OrderRequest orderRequest){
    User user = jpaAllUser.findByIdWithPessimisticLock(orderRequest.userId());
    Menu menu = jpaAllMenu.findByIdWithPessimisticLock(orderRequest.menuId());
    Store store = jpaAllStore.findByIdWithPessimisticLock(menu.getStore().getId());

    if(!user.hasEnoughMoneyToOrderMenu(orderRequest.quantity(), menu.getPrice())) throw new LackOfUserMoneyException();
    if(!menu.hasEnoughQuantity(orderRequest.quantity())) throw new LackOfMenuQuantityException();
    if(!store.isStoreOpen()) throw new StoreNotOpenedException();

    user.decreaseMoney(orderRequest.quantity(), menu.getPrice());
    menu.decreaseQuantity(orderRequest.quantity());

    jpaAllOrder.save(new Order(user, store));
    jpaAllMenu.save(menu);
    jpaAllUser.save(user);
  }
}
