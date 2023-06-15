package com.example.demo.store.domain;

import com.example.demo.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "owner_id")
  private User owner;

  private String name;

  private boolean isOpen;

  public boolean isStoreOpen(){
    return this.isOpen;
  }

}
