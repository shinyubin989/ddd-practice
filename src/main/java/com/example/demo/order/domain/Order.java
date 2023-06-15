package com.example.demo.order.domain;

import com.example.demo.common.domain.BaseEntity;
import com.example.demo.store.domain.Store;
import com.example.demo.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

  @OneToOne
  @JoinColumn(name = "orderer_id")
  private User orderer;

  @OneToOne
  @JoinColumn(name = "store_id")
  private Store store;

  @Version
  private long version;

  public Order(User orderer, Store store) {
    this.orderer = orderer;
    this.store = store;
  }

}
