package com.example.clayMarket.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "clay_supplier",
            joinColumns = { @JoinColumn(name = "supplier_id") },
            inverseJoinColumns = { @JoinColumn(name = "clay_id") }
    )
    private List<Clay> clayList;
}
