package com.example.demo.menu.domain;

import com.example.demo.common.domain.BaseEntity;
import com.example.demo.store.domain.Store;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu extends BaseEntity {

  @ManyToOne
  @JoinColumn(name = "store_id")
  private Store store;

  private String name;

  private int quantity;

  private int price;

  @Version
  private long version;

  public boolean hasEnoughQuantity(int requestQuantity) {
    return requestQuantity >= this.quantity;
  }

  public void decreaseQuantity(int requestQuantity) {
    quantity -= requestQuantity;
  }

}
