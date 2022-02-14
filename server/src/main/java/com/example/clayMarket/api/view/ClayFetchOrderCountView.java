package com.example.clayMarket.api.view;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClayFetchOrderCountView {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private Double weight;

    private CategoryView category;

    private Long count;
}
