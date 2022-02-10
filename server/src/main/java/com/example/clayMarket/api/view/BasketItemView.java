package com.example.clayMarket.api.view;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BasketItemView {

    private Long id;

    private ClayView clay;

    private Long count;
}
