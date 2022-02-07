package com.example.clayMarket.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "basket_item")
public class BasketItem {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clay_id")
    private Clay clay;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @Column(name = "count")
    private Long count;
}
