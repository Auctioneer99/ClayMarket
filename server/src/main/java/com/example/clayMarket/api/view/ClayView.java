package com.example.clayMarket.api.view;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClayView {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private Double weight;

    private String image;

    private CategoryView category;

    private List<SupplierView> suppliers;
}
