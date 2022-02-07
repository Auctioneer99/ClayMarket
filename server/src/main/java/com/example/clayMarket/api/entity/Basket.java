package com.example.clayMarket.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "basket")
public class Basket {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @OneToMany(mappedBy = "basket")
    private List<BasketItem> basketItems;
}
