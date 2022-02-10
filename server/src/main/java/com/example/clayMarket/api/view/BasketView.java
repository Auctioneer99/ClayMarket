package com.example.clayMarket.api.view;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BasketView {

    private Long id;

    private String userId;

    private List<BasketItemView> basketItems;
}
